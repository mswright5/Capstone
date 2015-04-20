import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * This is the panel that sits inside Application and handles all the drawing of the images.
 * 
 * @author Matt Wright
 * @version April 13, 2015
 */
public class Window extends JPanel implements KeyListener
{
    /** the player Loki */
    private Loki player;
    private Image background;
    private ArrayList<Thor> thors;
    private int round;
    private Timer timer;

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {        
        background = null;
        try {background = ImageIO.read(new File("Images\\asgard.jpg"));} 
        catch (java.io.IOException e) {}
        player = new Loki(background.getWidth(this)/2);

        setPreferredSize(new Dimension(background.getWidth(this), background.getHeight(this)));

        round = 1;
        makeThors();        

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 25);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
        drawThor(g);
        drawLoki(g);
        g.drawString("Round: " + round, background.getWidth(this) - 100, 20);
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

        for(int i = 0;i < thors.size(); i++){
            if ( Math.abs(thors.get(i).getX() - player.getX()) < 128 ){
                die(g);
            }
            else{
                g.drawImage(thors.get(i).getMove(), thors.get(i).getX(), h-200, this);
            }
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

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if( keyCode == KeyEvent.VK_LEFT) { }
        else if( keyCode == KeyEvent.VK_RIGHT){}
    }

    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {}
    
    
    private void makeThors()
    {
        thors = new ArrayList<Thor>();
        for(int i = 0; i < round; i++){
            thors.add(new Thor(background.getWidth(this)));
        }
    }

    private void die(Graphics g)
    {
        thors = new ArrayList<Thor>();
        g.drawString("You died!", background.getWidth(this)/2, background.getHeight(this)/2);
        repaint();
        //try{Thread.sleep(10000);}
        //catch(java.lang.InterruptedException e) {}

    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {            
            repaint();
        }
    }
}
