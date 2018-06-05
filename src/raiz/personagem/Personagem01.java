package raiz.personagem;

import raiz.Coordenada;
import raiz.personagem.strategy.pulo.PuloMedio;
import raiz.personagem.strategy.movimento.MovimentoMedio;
import raiz.ataque.AtaqueFogo;

public class Personagem01 extends Personagem {
    
    public Personagem01(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new AtaqueFogo(), new MovimentoMedio(), new PuloMedio(), vida,
                coordenada, dimX, dimY);
    }
}
