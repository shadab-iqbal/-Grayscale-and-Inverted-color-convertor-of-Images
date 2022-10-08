/**
 * Create a gray scale version of an image by setting all color components of each pixel to the same value.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = ( inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen() ) / 3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inFile = new ImageResource(f);
            ImageResource gray = makeGray(inFile);
            gray.draw();
        }
    }
    
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File fl : dr.selectedFiles()) {
            ImageResource ir = new ImageResource(fl);
            ImageResource newImage = makeGray(ir);
            newImage.setFileName("gray-" + ir.getFileName());
            newImage.draw();
            newImage.save();
        }
    }

    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
}
