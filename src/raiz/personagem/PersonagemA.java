package raiz.personagem;

import raiz.Coordenada;
import raiz.personagem.strategy.pulo.PuloMedio;
import raiz.ataque.AtaqueFogo;
import raiz.personagem.strategy.movimento.MovimentoRapido;

public class PersonagemA extends Personagem {
    
    public PersonagemA(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new AtaqueFogo(), new MovimentoRapido(), new PuloMedio(), vida,
                coordenada, dimX, dimY);
    }
}
