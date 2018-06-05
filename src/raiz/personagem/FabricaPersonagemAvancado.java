package raiz.personagem;

import raiz.Coordenada;

public class FabricaPersonagemAvancado extends FabricaPersonagem {
    
        
    private static FabricaPersonagemAvancado instancia = null;
    
    private FabricaPersonagemAvancado() {super();}
    
    public static synchronized FabricaPersonagem getInstancia() {
        if (instancia == null) {
            instancia = new FabricaPersonagemAvancado();
        }
        return instancia;
    }

    
    @Override
    public Personagem criarPersonagem() {
        
        Coordenada posicaoInicial = new Coordenada(250, 250);
        int dimX = 16;
        int dimY = 16;
        int vidaInicial = 100;
        
        Personagem personagem;
        
        double r = Math.random();
        
        if (r <= 0.2) {
            personagem = new PersonagemA(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.4) {
            personagem = new PersonagemB(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.6) {
            personagem = new PersonagemC(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.8) {
            personagem = new PersonagemD(vidaInicial, posicaoInicial, dimX, dimY);
        } else {
            personagem = new PersonagemE(vidaInicial, posicaoInicial, dimX, dimY);
        }
        
        return personagem;
    }
    
}
