package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaquePlanta;
import raiz.personagem.strategy.movimento.MovimentoLento;
import raiz.personagem.strategy.pulo.PuloBaixo;

public class PersonagemB extends Personagem {
    
    public PersonagemB(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new AtaquePlanta(), new MovimentoLento(), new PuloBaixo(), vida,
                coordenada, dimX, dimY);
    }
    
}
