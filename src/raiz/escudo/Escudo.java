package raiz.escudo;

import raiz.ataque.Ataque;

public abstract class Escudo {

    private Escudo sucessor;
    
    public void setSucessor(Escudo sucessor) {
        this.sucessor = sucessor;
    }
    
    public Escudo getSucessor() {
        return sucessor;
    }
    
    public abstract boolean processarDefesa(Ataque ataque);
}
