package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaqueAgua;
import raiz.ataque.decorador.MultiplicadorMagico;
import raiz.personagem.strategy.pulo.PuloBaixo;
import raiz.personagem.strategy.movimento.MovimentoRapido;

public class Personagem05 extends Personagem {
    
    public Personagem05(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new MultiplicadorMagico(new AtaqueAgua()), new MovimentoRapido(), new PuloBaixo(), vida,
                coordenada, dimX, dimY);
    }
    
}