import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImageOp;

/**
 * This is the panel that sits inside Application and handles all the drawing of the images.
 * 
 * @author Matt Wright
 * @version April 13, 2015
 */
public class Window extends JPanel
    //implements ActionListener
{
    /** the player Loki */
    private Loki player;

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        player.move(g);
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
        
        g2d.drawImage(thor.getBufferedImage(1), null, w-200, h-200);
    }
    
    /**
     * Draws Loki on the board
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
        
        Loki loki = new Loki();
        
        g2d.drawImage(thor.getBufferedImage(1), null, w-200, h-200);
    }

}
