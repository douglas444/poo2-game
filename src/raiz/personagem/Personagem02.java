package raiz.personagem;

import raiz.Coordenada;
import raiz.personagem.strategy.pulo.PuloAlto;
import raiz.personagem.strategy.movimento.MovimentoRapido;
import raiz.ataque.AtaquePlanta;

public class Personagem02 extends Personagem {
    
    public Personagem02(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new AtaquePlanta(), new MovimentoRapido(), new PuloAlto(), vida,
                coordenada, dimX, dimY);
    }
    
}
