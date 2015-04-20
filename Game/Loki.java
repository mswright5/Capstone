import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;

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
            sitRight = ImageIO.read(new File("Images\\Loki\\sit left.png"));
        } catch (java.io.IOException e) {}
    }
    
    /**
     * Moves the Player
     *
     * @pre     Game is working
     * @post    Game still works
     * @param   g   the Graphics object
     */
    public void move(Graphics g)
    {
        
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
    public BufferedImage getBufferedImage(int pic){
        if(dx < 0){return leftRun;}
        else if(dx > 0){return rightRun;}
        else if(Math.random() < .5){return sitLeft;}
        else{return sitRight;}
    }
    
    
}
