package raiz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import raiz.ataque.AtaqueAgua;
import raiz.inimigo.Inimigo;
import raiz.inimigo.Inimigo01;
import raiz.personagem.Personagem;
import raiz.personagem.Personagem01;
import raiz.ataque.AtaqueFogo;
import raiz.ataque.AtaquePlanta;
import raiz.escudo.EscudoFogo;
import raiz.inimigo.Inimigo02;
import raiz.inimigo.Inimigo03;
import raiz.personagem.FabricaPersonagem;
import raiz.personagem.FabricaPersonagemSimples;

public class Application extends JFrame implements KeyListener, MouseListener {
    
    private static Application application;
    private static Drawer drawer;
    private Personagem personagem;
    
    private Application(){}

    public static Application getInstance(){

        if (application == null) {
            application = new Application();
        }
        return application;
    }
    
    public void initialize(){
        
        addKeyListener(this);
        addMouseListener(this);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        drawer = new Drawer(getGraphics());
        mainLoop();
        
    }
        
    private void mainLoop() {
        
        /*
        
        -> O personagem fica parado e os 3 inimigos vão ao encontro dele.
        
        -> O personagem tem a vida decrementada para cada inimigo colidindo com ele
        a cada ciclo do jogo.
        
        -> Os inimigos começam a atacar quando encostam no personagem (sem contar
        com o dano que o personagem leva só de estar em contato com o inimigo,
        conforme o ítem anterior).
        
        -> Tanto o inimigo quanto o personagem são subclasses da classe Corpo,
        e implementam o método executarAcao, que define a ação de cada um. Essa
        implementação pode ser mudada para alterar o comportamento dos inimigos
        e do personagem.
        
        -> Personagem começa com um escudo de fogo, que bloqueia ataques do tipo
        planta. (Escudo de fogo bloqueia planta, de água bloqueia fogo e de planta
        bloqueia água).
        
        */
        
        Inimigo inimigo01 = new Inimigo01(new Coordenada(0, 0), 16, 16, new AtaqueFogo());
        Inimigo inimigo02 = new Inimigo02(new Coordenada(300, 200), 16, 16, new AtaqueAgua());
        Inimigo inimigo03 = new Inimigo03(new Coordenada(200, 100), 16, 16, new AtaquePlanta());
        
        FabricaPersonagem fabricaPersonagem;
        fabricaPersonagem = FabricaPersonagemSimples.getInstancia();
        
        personagem = fabricaPersonagem.criarPersonagem();
        
        personagem.setEscudo(new EscudoFogo());
        
        personagem.registrarObservador(inimigo01);
        personagem.registrarObservador(inimigo02);
        personagem.registrarObservador(inimigo03);
        personagem.notificarObservadores();
        
        List<Corpo> corpos = new ArrayList<>();
        
        corpos.add(inimigo01);
        corpos.add(inimigo02);
        corpos.add(inimigo03);
        corpos.add(personagem);
        
        while (personagem.getEstado() == Estado.VIVO) {
            corpos.forEach(executavel -> executavel.executarAcao(corpos));
            
            drawer.draw(corpos);
        
            try {
                Thread.sleep(1000/ 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {
        personagem.KeyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        personagem.KeyReleased(e);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
    
}
