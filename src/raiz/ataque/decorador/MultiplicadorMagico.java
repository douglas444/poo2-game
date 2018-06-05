package raiz.ataque.decorador;

import raiz.ataque.Ataque;

public class MultiplicadorMagico extends Decorador {
    
    public MultiplicadorMagico(Ataque ataque) {
        super(ataque);
    }
        
    @Override
    public int getDano() {
        return 3 * getAtaque().getDano();
    }
    
}
