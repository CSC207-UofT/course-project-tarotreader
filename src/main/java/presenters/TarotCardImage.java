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
        String imagePath= "resources/images/";
        try {
            image = ImageIO.read(new File(imagePath+ cardName + ".png"));
        }
        catch (IOException ex) {
            System.out.println("There was issue loading one or more card images. Sorry about that :(");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}