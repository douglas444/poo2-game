package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaqueAgua;
import raiz.ataque.decorador.MultiplicadorCritico;
import raiz.personagem.strategy.movimento.MovimentoLento;
import raiz.personagem.strategy.pulo.PuloBaixo;

public class PersonagemD extends Personagem {
    
    public PersonagemD(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new MultiplicadorCritico(new AtaqueAgua()), new MovimentoLento(), new PuloBaixo(), vida,
                coordenada, dimX, dimY);
    }
    
}