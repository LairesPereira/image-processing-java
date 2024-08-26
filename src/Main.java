import processors.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ImageProcessor imageProcessor = new ImageProcessor();
        try {
            BufferedImage result = imageProcessor.colorInverter(new File("src/files/Fire02.jpg"));
            ImageIO.write(result, "png", new File("teste.png"));
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}