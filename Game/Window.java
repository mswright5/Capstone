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

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {
        player = new Loki();
        background = null;
        try {background = ImageIO.read(new File("Images\\asgard.jpg"));
        } catch (java.io.IOException e) {}

        setPreferredSize(new Dimension(background.getWidth(this), background.getHeight(this)));

        for(int i = 0; i < 10; i++){
            thors[i] = new Thor();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
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
    private void drawThor(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        Thor thor = new Thor();

        for(int i = 0;i < thors.length; i++){
            g.drawImage(thors[i].getImage(1), w-200, h-200, this);
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

        Loki loki = new Loki();

        g.drawImage(loki.getBufferedImage(1), w-200, h-200, this);
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
}
