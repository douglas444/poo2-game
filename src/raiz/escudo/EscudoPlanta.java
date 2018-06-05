package raiz.escudo;

import raiz.ataque.Ataque;
import raiz.ataque.AtaqueAgua;

public class EscudoPlanta extends Escudo {

    @Override
    public boolean processarDefesa(Ataque ataque) {
        
            if (ataque instanceof AtaqueAgua) {
                return true;
            }
            
            return getSucessor() != null && getSucessor().processarDefesa(ataque);
    }
    
}
