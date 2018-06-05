package raiz.inimigo;

import java.util.List;
import raiz.Coordenada;
import raiz.Corpo;
import raiz.personagem.Personagem;
import raiz.Observador;
import raiz.ataque.Atacante;
import raiz.ataque.Ataque;
import raiz.inimigo.strategy.perseguicao.Perseguicao;

public abstract class Inimigo extends Corpo implements Observador, Atacante {

    private Coordenada coordenadaPersonagem;
    private Perseguicao perseguicao;
    private Ataque ataque;
    
    public Inimigo(Perseguicao perseguicao, Coordenada coordenada,
            int dimX, int dimY, Ataque ataque) {
        super(coordenada, dimX, dimY, "img/inimigo.png");
        this.perseguicao = perseguicao;
        this.ataque = ataque;
    }
    
    public void perseguir() {
        perseguicao.perseguir(getCoordenada(), coordenadaPersonagem != null ?
                coordenadaPersonagem : getCoordenada());
    }
    
    @Override
    public void atualizar(Object object) {
        coordenadaPersonagem = ((Personagem) object).getCoordenada();
    }
    
    @Override
    public void executarAcao(List<Corpo> corpos) {
        
        perseguir();
        
        corpos.forEach(corpo -> {
            if (corpo instanceof Personagem) {
                if(corpo.checaColisao(this)) {
                    ((Atacante) corpo).receberAtaque(ataque);
                }
            }
        });
        
        System.out.println("[Inimigo] Posicao: " + super.toString() + ";");
    }
    
    @Override
    public void atacar(Atacante alvo) {
        alvo.receberAtaque(ataque);
        System.out.println("Inimigo atacou!");
    }
    
    @Override
    public void receberAtaque(Ataque ataque) {
        System.out.println("Inimigo recebeu ataque!");
    }
}
