import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * The true enemy here
 * 
 * @author Matt
 * @version April 14, 2015
 */
public class Thor
{
    /** description of instance variable x (add comment for each instance variable) */
    private BufferedImage left, right, dead1_1, dead1_2, dead2;
    private int DX;
    

    /**
     * Default constructor for objects of class Thor
     */
    public Thor()
    {
        left = null;
        right = null;
        dead1_1 = null;
        dead1_2 = null;
        dead2 = null;
        try {left = ImageIO.read(new File("Images\\Thor\\thor left.png"));
            right = ImageIO.read(new File("Images\\Thor\\thor right.png"));
            dead1_1 = ImageIO.read(new File("Images\\Thor\\dead 1_1.png"));
            dead1_2 = ImageIO.read(new File("Images\\Thor\\dead 1_2.png"));
            dead2 = ImageIO.read(new File("Images\\Thor\\dead 2.png"));
        } catch (java.io.IOException e) {}

        
        if (Math.random() < .5){
            dx = -1 * Math.random() * 3
        }
        else{
            dx = Math.random() * 3
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void sampleMethod(int y)
    {
    }

}
