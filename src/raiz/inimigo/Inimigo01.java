package raiz.inimigo;

import raiz.Coordenada;
import raiz.ataque.Ataque;
import raiz.inimigo.strategy.perseguicao.PerseguicaoLenta;

public class Inimigo01 extends Inimigo {
    
    public Inimigo01(Coordenada coordenada, int dimX, int dimY, Ataque ataque) {
        super(new PerseguicaoLenta(), coordenada, dimX, dimY, ataque);
    }
    
}
