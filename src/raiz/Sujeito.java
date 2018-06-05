package raiz;

import raiz.Observador;

public interface Sujeito {

    public void registrarObservador(Observador observador);
    public void removerObservador(Observador observador);
    public void notificarObservadores();
    
}
