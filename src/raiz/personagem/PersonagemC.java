package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaqueAgua;
import raiz.personagem.strategy.movimento.MovimentoRapido;
import raiz.personagem.strategy.pulo.PuloAlto;

public class PersonagemC extends Personagem {
    
    public PersonagemC(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new AtaqueAgua(), new MovimentoRapido(), new PuloAlto(), vida,
                coordenada, dimX, dimY);
    }
    
}