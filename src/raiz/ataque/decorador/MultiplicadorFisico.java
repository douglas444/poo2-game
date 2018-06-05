package raiz.ataque.decorador;

import raiz.ataque.Ataque;

public class MultiplicadorFisico extends Decorador {
    
    public MultiplicadorFisico(Ataque ataque) {
        super(ataque);
    }
    
    @Override
    public int getDano() {
        return 2 * getAtaque().getDano();
    }
    
}
