package raiz.inimigo;

import raiz.Coordenada;
import raiz.ataque.Ataque;
import raiz.inimigo.strategy.perseguicao.PerseguicaoMedia;

public class Inimigo02 extends Inimigo {
    
    public Inimigo02(Coordenada coordenada, int dimX, int dimY, Ataque ataque) {
        super(new PerseguicaoMedia(), coordenada,dimX, dimY, ataque);
    }
     
}
