package raiz.inimigo;

import raiz.Coordenada;
import raiz.ataque.Ataque;
import raiz.inimigo.strategy.perseguicao.PerseguicaoRapida;

public class Inimigo03 extends Inimigo {
    
    public Inimigo03(Coordenada coordenada, int dimX, int dimY, Ataque ataque) {
        super(new PerseguicaoRapida(), coordenada, dimX, dimY, ataque);
    }
    
}
