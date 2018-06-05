package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaqueAgua;
import raiz.ataque.decorador.MultiplicadorCritico;
import raiz.personagem.strategy.pulo.PuloBaixo;
import raiz.personagem.strategy.movimento.MovimentoRapido;

public class Personagem04 extends Personagem {
    
    public Personagem04(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new MultiplicadorCritico(new AtaqueAgua()), new MovimentoRapido(), new PuloBaixo(), vida,
                coordenada, dimX, dimY);
    }
    
}