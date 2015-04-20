import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This is the panel that sits inside Application and handles all the drawing of the images.
 * 
 * @author Matt Wright
 * @version April 13, 2015
 */
public class Window extends JPanel
implements ActionListener
{
    /** the player Loki */
    private Loki player;
    private Image background;
    private Thor[] thors;
    private int round;

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {        
        background = null;
        try {background = ImageIO.read(new File("Images\\asgard.jpg"));
        } catch (java.io.IOException e) {}
        player = new Loki(background.getWidth(this)/2);

        setPreferredSize(new Dimension(background.getWidth(this), background.getHeight(this)));

        round = 1;
        
        makeThors();        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
        drawThor(g);
        drawLoki(g);
        repaint();
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
    private void drawThor(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();


        for(int i = 0;i < thors.length; i++){
            g.drawImage(thors[i].getMove(), thors[i].getX(), h-200, this);
        }
    }

    /**
     * Draws Loki on the board
     *
     * @pre     Application has called Window
     * @post    Loki is drawn
     * @param   g    The Graphics Object
     */
    private void drawLoki(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        g.drawImage(player.getBufferedImage(1), player.getX(), h-200, this);
    }

    public void actionPerformed(ActionEvent e) {

        //x += 1;
        //y += 1;

        //if (y >) {

        //   y = INITIAL_Y;
        //   x = INITIAL_X;
        //}
        repaint();
    }
    
    private void makeThors()
    {
        thors = new Thor[round];
        for(int i = 0; i < round; i++){
            thors[i] = new Thor(background.getWidth(this));
        }
    }
    
    private void die()
    {
        
    }
}
