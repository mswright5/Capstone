import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * The true enemy here
 * 
 * @author Matt
 * @version April 24, 2015
 */
public class Thor
{
    /** Images for the movement and death of Thor (the last three are not currently used) */
    private Image left, right, dead1_1, dead1_2, dead2;
    /** The speed at which Thor flies at you and the position of Thor on the x-axis*/
    private int dx, x;

    /**
     * Default constructor for objects of class Thor
     */
    public Thor(int width)
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

        //randomly determines the speed of thor, and places him accordingly on the x-axis
        if (Math.random() < .5){
            dx = (int) (-1 * Math.random() * 3);
            if(dx == 0){
                dx = -1;
            }
            x = (int) (width - Math.random() * 100 - 128);
        }
        else{
            dx = (int) (Math.random() * 3);
            if(dx == 0){
                dx = 1;
            }
            x = (int) (Math.random() * 100 + 128);
        }
    }

    /**
     * Returns the x position of the Thor object
     *
     * @pre     Game works and is running
     * @post    Thor object left untouched
     * @return  The position of Thor on the x-axis
     */
    public int getX(){
        x = x+dx;
        return x;
    }

    /**
     * Returns the Image of the Thor object used in painting the board
     *
     * @pre     Thor is moving
     * @post    Thor object left untouched
     * @return  Image of thor moving, null if not moving (normally not returned)
     */
    public Image getMove(){
        if(dx < 0){return left;}
        else if(dx > 0){return right;}
        return null;
    }
}
