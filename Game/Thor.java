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
    /** Images for the movement and death of Thor */
    private BufferedImage left, right, dead1_1, dead1_2, dead2;
    /** The speed at which Thor flies at you */
    private double dx;
    /** The state of Thor*/
    private boolean life;

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
            dx = -1 * Math.random() * 3;
        }
        else{
            dx = Math.random() * 3;
        }
        
        life = true;
    }
    
    /**
     * Returns the speed of the Thor object
     *
     * @pre     Game works and is running
     * @post    Thor object left untouched
     * @return  Speed of Thor and negative if heading left and positive if heading right
     */
    public double getSpeed(){
        return dx;
    }
    
    /**
     * Returns the BufferedImage of the Thor object used in painting the board
     *
     * @pre     Game works and running
     * @post    Thor object left untouched
     * @param   What image you want; 1 for left, 2 for right, 3 for first dead image, 4 for second dead image,
     *          5 for third dead image
     * @return  The BufferedImage you requested
     */
    public BufferedImage getBufferedImage(int pic){
        if(life){
            if(dx < 0){return left;}
            else{return right;}
        }
        else if(pic == 2){return right;}
        else if(pic == 2){return dead1_1;}
        else if(pic == 2){return dead1_2;}
        else{return dead2;}
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
