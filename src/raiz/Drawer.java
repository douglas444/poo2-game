package raiz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;

public class Drawer {

    private Graphics frame;
    private BufferedImage backBuffer;
    private Image backgroundImage ;
    
    Drawer(Graphics frame){

        this.frame = frame;
        this.backBuffer = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        backgroundImage = new ImageIcon("img/back.png").getImage();
    }

    private void DrawBackground(){
        backBuffer.getGraphics().clipRect(0, 0, 500, 500);

        for (int i = 0; i < 500/32 + 1; i++) {
            for (int j = 0; j < 500/32 + 1; j++) {

                backBuffer.getGraphics().drawImage(backgroundImage,
                        i * 32, j * 32, Application.getInstance());
            }
        }
    }

    public void draw(List<Corpo> corpos){
        DrawBackground();
        
        backBuffer.getGraphics().clipRect(0, 0,
                                            500,
                                            500);
        corpos.forEach(corpo -> {
            backBuffer
                    .getGraphics()
                    .drawImage(corpo.getImage(),
                            (int) corpo.getCoordenada().getX(),
                            (int) corpo.getCoordenada().getY(),
                            Application.getInstance());
        });
        this.frame.drawImage(backBuffer, 0, 0, Application.getInstance());
    }
}
