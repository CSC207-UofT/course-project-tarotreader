package presenters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TarotCardImage extends JPanel {
    private BufferedImage image;

    public TarotCardImage(String cardName) {
        try {
            image = ImageIO.read(new File(cardName + ".png"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
