package raiz.personagem;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import raiz.Estado;
import java.util.List;
import raiz.Coordenada;
import raiz.Corpo;
import raiz.personagem.strategy.pulo.Pulo;
import raiz.personagem.strategy.movimento.Movimento;
import raiz.ataque.Ataque;
import raiz.Observador;
import raiz.Sujeito;
import raiz.ataque.Atacante;
import raiz.escudo.Escudo;
import raiz.inimigo.Inimigo;

public abstract class Personagem extends Corpo implements Sujeito, Atacante {
    
    private int ButtonUp;
    private int ButtonDown;
    private int ButtonLeft;
    private int ButtonRight;
    
    private int vida;
    
    private Estado estado;
    private Ataque ataque;
    private Movimento movimento;
    private Pulo pulo;
    
    private Escudo escudo;
    
    private List<Observador> observadores = new ArrayList<>();
    
    public Personagem(Ataque ataque, Movimento movimento, Pulo pulo, int vida,
            Coordenada coordenada, int dimX, int dimY) {
        
        super(coordenada, dimX, dimY, "img/jogador.png");
        
        this.vida = vida;
        this.estado = Estado.VIVO;
        this.ataque = ataque;
        this.movimento = movimento;
        this.pulo = pulo;
        
    }
    
    @Override
    public void atacar(Atacante alvo) {
        alvo.receberAtaque(ataque);
        System.out.println("Personagem atacou");
    }
    
    @Override
    public void receberAtaque(Ataque ataque) {
        if (!escudo.processarDefesa(ataque)) {
            vida -= ataque.getDano();
            System.out.println("Personagem recebeu ataque!");
        } else {
            System.out.println("Personagem bloqueou ataque!");
        }
    }
    
    public void movimentar() {
        Coordenada direcao = new Coordenada(ButtonRight - ButtonLeft, ButtonDown - ButtonUp);
        movimento.movimentar(super.getCoordenada(), direcao.getX(), direcao.getY());
    }
    
    public void pular() {
        pulo.pular();
        System.out.println("Personagem pulou");
    }
    
    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }
    
    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }
    
    @Override
    public void notificarObservadores() {
        observadores.forEach(observador -> observador.atualizar(this));
    }

    @Override
    public void executarAcao(List<Corpo> corpos) {
                
        corpos.forEach(corpo -> {
            if (corpo instanceof Inimigo) {
                if(corpo.checaColisao(this)) {
                    --vida;
                    System.out.println("Inimigo colidindo com personagem!");
                }
            }
        });
        
        if (vida <= 0) {
            vida = 0;
            estado = Estado.MORTO;
            System.out.println("Personagem está morto!");
        }
        
        System.out.println("[Personagem] Posicao: " + super.toString() + "; Vida: " + vida + ";");
        
        movimentar();
    }

    public void KeyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                this.ButtonUp = 1;
                break;
            case KeyEvent.VK_DOWN:
                this.ButtonDown = 1;
                break;
            case KeyEvent.VK_LEFT:
                this.ButtonLeft = 1;
                break;
            case KeyEvent.VK_RIGHT:
                this.ButtonRight = 1;
                break;
        }
    }

    public void KeyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                this.ButtonUp = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.ButtonDown = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.ButtonLeft = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.ButtonRight = 0;
                break;
        }
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

    public Pulo getPulo() {
        return pulo;
    }

    public void setPulo(Pulo pulo) {
        this.pulo = pulo;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
    
    
}
