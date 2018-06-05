package raiz.personagem.strategy.movimento;

import raiz.Coordenada;

public class MovimentoRapido implements Movimento {
    
    @Override
    public void movimentar(Coordenada coordenada, int x, int y) {
        Coordenada novaCoordenada = coordenada.somar(new Coordenada(x * 3, y * 3));
        coordenada.setX(novaCoordenada.getX());
        coordenada.setY(novaCoordenada.getY());
    }
    
}
