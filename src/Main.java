import processors.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ImageProcessor imageProcessor = new ImageProcessor();
        try {
            BufferedImage q1 = imageProcessor.binarization(new File("src/files/Imagem1.jpg"));
            ImageIO.write(q1, "jpg", new File("src/files/processed/questao01-image1-binary.jpg"));

            BufferedImage q2 = imageProcessor.colorInverter(new File("src/files/Imagem1.jpg"));
            ImageIO.write(q2, "jpg", new File("src/files/processed/questao02-image1-binary.jpg"));

            BufferedImage q4 = imageProcessor.binarization(new File("src/files/Imagem2.jpg"));
            ImageIO.write(q4, "jpg", new File("src/files/processed/questao04-image1-binary.jpg"));

            BufferedImage q5 = imageProcessor.colorInverter(new File("src/files/Imagem2.jpg"));
            ImageIO.write(q5, "jpg", new File("src/files/processed/questao05-image1-binary.jpg"));

            BufferedImage q7 = imageProcessor.binarization(new File("src/files/Imagem3.jpg"));
            ImageIO.write(q7, "jpg", new File("src/files/processed/questao07-image1-binary.jpg"));

            BufferedImage q8 = imageProcessor.colorInverter(new File("src/files/Imagem3.jpg"));
            ImageIO.write(q8, "jpg", new File("src/files/processed/questao08-image1-binary.jpg"));

            BufferedImage q10 = imageProcessor.binarization(new File("src/files/Imagem4.jpg"));
            ImageIO.write(q10, "jpg", new File("src/files/processed/questao010-image1-binary.jpg"));

            BufferedImage q11 = imageProcessor.colorInverter(new File("src/files/Imagem4.jpg"));
            ImageIO.write(q11, "jpg", new File("src/files/processed/questao11-image1-binary.jpg"));
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}