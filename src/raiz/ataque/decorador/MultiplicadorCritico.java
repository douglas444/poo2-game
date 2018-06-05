package raiz.ataque.decorador;

import raiz.ataque.Ataque;

public class MultiplicadorCritico extends Decorador {
    
    public MultiplicadorCritico(Ataque ataque) {
        super(ataque);
    }
    
    @Override
    public int getDano() {
        return 5 * getAtaque().getDano();
    }
    
}
