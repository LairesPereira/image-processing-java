package processors;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    public BufferedImage binarization(File originalFile) throws IOException{
        try {
            BufferedImage img = ImageIO.read(originalFile);
            for(int row = 0; row < img.getWidth(); row++) {
                for(int col = 0; col < img.getHeight(); col++) {
                    int pixel = img.getRGB(row, col);
                    Color color = new Color(pixel, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int colorsValue = (r + g + b) / 3;
                    if (colorsValue > 127) {
                        img.setRGB(row, col, new Color(255, 255, 255).getRGB());
                    } else {
                        img.setRGB(row, col, 0);
                    }
                }
            }
            return img;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage colorInverter(File originalFile) throws IOException{
        try {
            BufferedImage img = ImageIO.read(originalFile);
            for(int row = 0; row < img.getWidth(); row++) {
                for(int col = 0; col < img.getHeight(); col++) {
                    int pixel = img.getRGB(row, col);
                    Color color = new Color(pixel, true);
                    int r = 255 - color.getRed();
                    int g = 255 - color.getGreen();
                    int b = 255 - color.getBlue();
                    img.setRGB(row, col, new Color(r, g, b).getRGB());
                }
            }
            return img;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage removeColorByThreshold(File originalFile, int threshold) throws IOException{
        try {
            BufferedImage img = ImageIO.read(originalFile);
            BufferedImage whiteCanva = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            for(int row = 0; row < img.getWidth(); row++) {
                for(int col = 0; col < img.getHeight(); col++) {
                    int pixel = img.getRGB(row, col);
                    Color color = new Color(pixel, true);
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b =  color.getBlue();
                    int colorsValue = (r + g + b) / 3;
                    if (colorsValue > threshold) {
                        whiteCanva.setRGB(row, col, new Color(0, 0, 0, 0).getRGB());
                    } else {
                        whiteCanva.setRGB(row, col, pixel);
                    }
                }
            }
            return img;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage replaceBackground(File originalFile, File secondaryImage, int threshold) throws IOException{
        try {
            BufferedImage img = ImageIO.read(originalFile);
            BufferedImage secondImage = ImageIO.read(secondaryImage);
            BufferedImage noBackground = removeColorByThreshold(originalFile, threshold);
            // find what image is bigger and create a white canva that size.
            BufferedImage whiteCanva = (img.getWidth() + img.getHeight() > secondImage.getWidth() + secondImage.getHeight()) ?
                    new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB) :
                    new BufferedImage(secondImage.getWidth(), secondImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

            for(int row = 0; row < img.getWidth(); row++) {
                for (int col = 0; col < img.getHeight(); col++) {
                    if(noBackground.getRGB(row,col) == 0)
                        whiteCanva.setRGB(row, col, secondImage.getRGB(row, col));
                    else whiteCanva.setRGB(row, col, img.getRGB(row, col));
                }
            }
            return whiteCanva;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
