package raiz.personagem.strategy.movimento;

import raiz.Coordenada;

public class MovimentoMedio implements Movimento {
    
    @Override
    public void movimentar(Coordenada coordenada, int x, int y) {
        Coordenada novaCoordenada = coordenada.somar(new Coordenada(x * 2, y * 2));
        coordenada.setX(novaCoordenada.getX());
        coordenada.setY(novaCoordenada.getY());
    }
    
}
