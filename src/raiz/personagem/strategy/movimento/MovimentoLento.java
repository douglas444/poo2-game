package raiz.personagem.strategy.movimento;

import raiz.Coordenada;

public class MovimentoLento implements Movimento {
    
    @Override
    public void movimentar(Coordenada coordenada, int x, int y) {
        Coordenada novaCoordenada = coordenada.somar(new Coordenada(x, y));
        coordenada.setX(novaCoordenada.getX());
        coordenada.setY(novaCoordenada.getY());
    }
    
}
