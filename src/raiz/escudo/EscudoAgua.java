package raiz.escudo;

import raiz.ataque.Ataque;
import raiz.ataque.AtaqueFogo;

public class EscudoAgua extends Escudo {

    @Override
    public boolean processarDefesa(Ataque ataque) {
        
            if (ataque instanceof AtaqueFogo) {
                return true;
            }
            
            return getSucessor() != null && getSucessor().processarDefesa(ataque);
    }
    
}
