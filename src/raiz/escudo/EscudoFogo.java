package raiz.escudo;

import raiz.ataque.Ataque;
import raiz.ataque.AtaquePlanta;

public class EscudoFogo extends Escudo {

    @Override
    public boolean processarDefesa(Ataque ataque) {
        
            if (ataque instanceof AtaquePlanta) {
                return true;
            }
            
            return getSucessor() != null && getSucessor().processarDefesa(ataque);
    }
    
}
