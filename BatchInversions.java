
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class BatchInversions {
    
    public ImageResource makeInversion (ImageResource image) {
        ImageResource newImage = new ImageResource(image.getWidth(), image.getHeight());
        for (Pixel pxl : newImage.pixels()) {
            Pixel oldPxl = image.getPixel(pxl.getX(), pxl.getY());
            pxl.setRed(255 - oldPxl.getRed());
            pxl.setBlue(255 - oldPxl.getBlue());
            pxl.setGreen(255 - oldPxl.getGreen());
        }   
        return newImage;
    }
    
    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            ImageResource inverted = makeInversion(image);
            inverted.setFileName("inverted-" + image.getFileName());
            inverted.draw();
            inverted.save();
        }
    }

}
