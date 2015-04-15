import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This is the panel that sits inside Application and handles all the drawing of the images.
 * 
 * @author Matt Wright
 * @version April 13, 2015
 */
public class Window extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawThor(g);
    }

    /**
     * Draws Thor on the board
     *
     * @pre        Application has called Windows
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void drawThor(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        
        Thor thor = new Thor();
        
        //g2d.drawImage(thor.getBufferedImage(1)
    }

}
