package raiz.personagem.strategy.pulo;

public class PuloAlto implements Pulo {
    
    @Override
    public void pular() {
        System.out.println("Comportamento de pulo alto");
    }
    
}