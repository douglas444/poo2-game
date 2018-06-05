package raiz.inimigo.strategy.perseguicao;

import raiz.Coordenada;

public class PerseguicaoLenta extends Perseguicao {
    
    @Override
    public void perseguir(Coordenada coordenada, Coordenada alvo) {
        
        Coordenada direcao = alvo.subtrair(coordenada);
        direcao = direcao.multiplicaEscalar(1);
        Coordenada novaCoordenada = direcao.unitario();
        novaCoordenada = coordenada.somar(novaCoordenada);
        
        coordenada.setX(novaCoordenada.getX());
        coordenada.setY(novaCoordenada.getY());
    }
    
}
