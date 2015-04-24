import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This is the main character
 * 
 * @author Matt
 * @version April 24, 2015
 */
public class Loki
{
    /** Images for the movement of Loki */
    private BufferedImage leftRun, rightRun, sitLeft, sitRight;
    /** The speed and position of Loki */
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
        //NOTED THAT I CAN DO THIS IN THE MOVE METHOD AND REMOVE THIS METHOD
        state = direction;
    }

    /**
     * Returns the x position of Loki
     *
     * @pre     Game works and is running
     * @post    Loki object left untouched
     * @return  Position of Loki on the x-axis
     */
    public int getX(){
        x = x+dx;
        return x;
    }
    
    /**
     * Returns the BufferedImage of the Loki object used in painting the board
     *
     * @pre     Game works and running
     * @post    Loki object left untouched
     * @return  The BufferedImage you requested, based on whether Loki is moving or the last direction he moved
     */
    public BufferedImage getBufferedImage(){
        if(dx < 0){return leftRun;}
        else if(dx > 0){return rightRun;}
        else if(state){return sitLeft;}
        else{return sitRight;}
    }
    
    /**
     * Returns the direction of thor
     *
     * @return     -1 if left, 1 if right
     */
    public int getDirection()
    {
        if(state){return -1;}
        return 1;
    }

}
