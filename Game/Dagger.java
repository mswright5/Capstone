import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * The Dagger that Loki shoots
 * 
 * @author Matt
 * @version April 24, 2015
 */
public class Dagger
{
    /** Images for the movement of Dagger */
    private BufferedImage left, right;
    /** The speed and location of Dagger */
    private int x, dx;

    /**
     * Default constructor for objects of class Dagger
     */
    public Dagger(int start, int speed)
    {
        x = start; 
        dx = speed;
        left = null;
        right = null;
        try {left = ImageIO.read(new File("Images\\Dagger\\left.png"));
            right = ImageIO.read(new File("Images\\Dagger\\right.png"));
        } catch (java.io.IOException e) {}
    }

    /**
     * Returns the x position of the Dagger object
     *
     * @pre     Game works and is running
     * @post    Dagger object left untouched
     * @return  Position of the object on the x-axis
     */
    public int getX(){
        x = x+dx;
        return x;
    }
    
    /**
     * Returns the BufferedImage of the Dagger object used in painting the board
     *
     * @pre     Game works and running
     * @post    You have the image
     * @return  The BufferedImage you requested
     */
    public BufferedImage getBufferedImage(){
        if(dx < 0){return left;}
        else if(dx > 0){return right;}
        return null;
    }
    
}
