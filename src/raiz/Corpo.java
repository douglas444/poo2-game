package raiz;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

public abstract class Corpo {

    private Coordenada coordenada;
    
    private int dimX;
    private int dimY;
    private Image image;

    public Corpo(Coordenada coordenada, int dimX, int dimY, String imagem) {
        this.image = new ImageIcon(imagem).getImage();
        this.coordenada = coordenada;
        this.dimX = dimX;
        this.dimY = dimY;
    }
    
    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public int getDimX() {
        return dimX;
    }

    public void setDimX(int dimX) {
        this.dimX = dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public void setDimY(int dimY) {
        this.dimY = dimY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
   
    
    public abstract void executarAcao(List<Corpo> corpos);
    
    public boolean checaColisao(Corpo corpo) {
        
        int dir = coordenada.getX() + dimX;
        int esq = coordenada.getX();
        int inf = coordenada.getY();
        int sup = coordenada.getY() + dimY;
        
        int corpo_dir = corpo.getCoordenada().getX() + corpo.getDimX();
        int corpo_esq = corpo.getCoordenada().getX();
        int corpo_inf = corpo.getCoordenada().getY();
        int corpo_sup = corpo.getCoordenada().getY() + corpo.getDimY();
        
        return dir > corpo_esq &&
                esq < corpo_dir &&
                sup > corpo_inf &&
                inf < corpo_sup;
    }
    
    @Override
    public String toString() {
        return "(" + coordenada.getX() + ", " + coordenada.getY() + ")";
    }
}
