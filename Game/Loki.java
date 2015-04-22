import java.awt.Graphics;
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
public class Loki
{
    /** Images for the movement and death of Loki */
    private BufferedImage leftRun, rightRun, sitLeft, sitRight;
    /** The speed of Loki */
    private int x, dx;
    /** True if player last moved left, false if he looked right */
    private boolean state;

    /**
     * Default constructor for objects of class Thor
     */
    public Loki(int width)
    {
        x = width; 
        leftRun = null;
        rightRun = null;
        sitLeft = null;
        sitRight = null;
        try {leftRun = ImageIO.read(new File("Images\\Loki\\run left.png"));
            rightRun = ImageIO.read(new File("Images\\Loki\\run right.png"));
            sitLeft = ImageIO.read(new File("Images\\Loki\\sit left.png"));
            sitRight = ImageIO.read(new File("Images\\Loki\\sit right.png"));
        } catch (java.io.IOException e) {}
    }
    
    /**
     * Moves the Player
     *
     * @pre     Game is working
     * @post    Game still works
     * @param   speed   the speed at which the player will move
     */
    public void move(int speed)
    {
        dx = speed;
    }
    
    /**
     * Moves the Player
     *
     * @pre     Game is working
     * @post    Game still works
     * @param   direction   true if player last moved left, false if right
     */
    public void setState(boolean direction)
    {
        state = direction;
    }

    /**
     * Returns the x position of the Thor object
     *
     * @pre     Game works and is running
     * @post    Thor object left untouched
     * @return  Speed of Thor and negative if heading left and positive if heading right
     */
    public int getX(){
        x = x+dx;
        return x;
    }
    
    /**
     * Returns the BufferedImage of the Loki object used in painting the board
     *
     * @pre     Game works and running
     * @post    Thor object left untouched
     * @param   What image you want; 1 for runnning left, 2 for running right, 3 for first set left, 
     *          4 for sit right 
     * @return  The BufferedImage you requested
     */
    public BufferedImage getBufferedImage(){
        if(dx < 0){return leftRun;}
        else if(dx > 0){return rightRun;}
        else if(state){return sitLeft;}
        else{return sitRight;}
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     -1 if left, 1 if right
     */
    public int getDirection()
    {
        if(state){return -1;}
        return 1;
    }

}
