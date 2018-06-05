package raiz;

public class Coordenada {
    
    private int x;
    private int y;

    public Coordenada() {
    
    }
    
    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Coordenada subtrair(Coordenada coordenada) {
        Coordenada resultado = new Coordenada();
        resultado.setX(x - coordenada.getX());
        resultado.setY(y - coordenada.getY());
        return resultado;
    }
    
    public Coordenada somar(Coordenada coordenada) {
        Coordenada resultado = new Coordenada();
        resultado.setX(x + coordenada.getX());
        resultado.setY(y + coordenada.getY());
        return resultado;
    }
    
    public Coordenada unitario() {
        Coordenada resultado = new Coordenada();
        resultado.setX((int) (x < 0 ? Math.floor((double) x / Math.sqrt(Math.pow(x,2) + Math.pow(y,2))) : Math.ceil((double) x / Math.sqrt(Math.pow(x,2) + Math.pow(y,2)))));
        resultado.setY((int) (y < 0 ? Math.floor((double) y / Math.sqrt(Math.pow(x,2) + Math.pow(y,2))) : Math.ceil((double) y / Math.sqrt(Math.pow(x,2) + Math.pow(y,2)))));
        return resultado;
    }
    
    public Coordenada multiplicaEscalar(int escalar) {
        Coordenada resultado = new Coordenada();
        resultado.setX(x * escalar);
        resultado.setY(y * escalar);
        return resultado;
    }
}
