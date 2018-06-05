package raiz.ataque.decorador;

import raiz.ataque.Ataque;

public abstract class Decorador implements Ataque {
    
    private Ataque ataque;
    
    public Decorador(Ataque ataque) {
        this.ataque = ataque;
    }
    
    @Override
    public abstract int getDano();

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }
    
    
    
}
