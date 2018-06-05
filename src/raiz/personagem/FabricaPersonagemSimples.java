package raiz.personagem;

import raiz.Coordenada;

public class FabricaPersonagemSimples extends FabricaPersonagem {
    
        
    private static FabricaPersonagemSimples instancia = null;
    
    private FabricaPersonagemSimples() {super();}
    
    public static synchronized FabricaPersonagem getInstancia() {
        if (instancia == null) {
            instancia = new FabricaPersonagemSimples();
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
            personagem = new Personagem01(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.4) {
            personagem = new Personagem02(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.6) {
            personagem = new Personagem03(vidaInicial, posicaoInicial, dimX, dimY);
        } else if (r <= 0.8) {
            personagem = new Personagem04(vidaInicial, posicaoInicial, dimX, dimY);
        } else {
            personagem = new Personagem05(vidaInicial, posicaoInicial, dimX, dimY);
        }
        
        return personagem;
    }
    
}
