package raiz.personagem;

import raiz.Coordenada;
import raiz.ataque.AtaqueAgua;
import raiz.ataque.decorador.MultiplicadorMagico;
import raiz.personagem.strategy.movimento.MovimentoRapido;
import raiz.personagem.strategy.pulo.PuloAlto;

public class PersonagemE extends Personagem {
    
    public PersonagemE(int vida, Coordenada coordenada, int dimX, int dimY) {
        super(new MultiplicadorMagico(new AtaqueAgua()), new MovimentoRapido(), new PuloAlto(), vida,
                coordenada, dimX, dimY);
    }
    
}