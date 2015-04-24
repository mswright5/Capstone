import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This is the panel that sits inside Application and handles all the drawing of the images.
 * 
 * @author Matt Wright
 * @version April 24, 2015
 */
public class Window extends JPanel 
{        
    /** A list of the enemy for the windows to draw */
    private ArrayList<Thor> thors;
    /** A list of daggers for the windows to draw when the player shoots */
    private ArrayList<Dagger> daggers;
    /** The background image */
    private Image background;
    /** The player, that is played by the user */
    private Loki player;
    /** The timer to create an illusion of FPS; it repaints the window every so often */
    private Timer timer;
    /** The round that the current user in on */
    private int round;
    /** Is the game over? */
    private boolean isOver;

    /**
     * Default constructor for objects of class Window
     */
    public Window()
    {        
        isOver = false;
        background = null;
        try {background = ImageIO.read(new File("Images\\asgard.jpg"));} 
        catch (java.io.IOException e) {}
        player = new Loki(background.getWidth(this)/2 - 50);
        daggers = new ArrayList<Dagger>();

        round = 1;
        makeThors();  
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 25);
        
        setPreferredSize(new Dimension(background.getWidth(this), background.getHeight(this)));
        setFocusable(true);
        setVisible(true);
        addKeyListener(new KeyboardPressListener());                
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
        if(isOver){die(g);}
        else{
            drawLoki(g);
            drawThor(g);        
            drawDaggers(g);
            g.drawString("Round: " + round, background.getWidth(this) - 100, 20);
        }
    }

    /**
     * Draws Thor on the board
     *
     * @pre     Application has called Windows
     * @post    Thor is drawn
     * @param   g   The graphics object to be drawn on
     */
    private void drawThor(Graphics g)

    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int h = (int) size.getHeight();

        //check if a dagger has hit Thor
        for(int i = 0; i < thors.size();i++){
            for(int j = 0; j < daggers.size(); j++){
                if (Math.abs(thors.get(i).getX() - daggers.get(j).getX()) < 50){
                    thors.remove(i);
                    daggers.remove(j);
                    //If all thors have died, make more
                    if(thors.size() == 0) {
                        round++;
                        makeThors();
                    }
                    break;
                }
            }
        }
        
        //Draws all remaining Thors (if all thors absent, previous loop should have made more
        for(int i = 0;i < thors.size(); i++){
            //if thor has hit the player, game is over
            if ( Math.abs(thors.get(i).getX() - player.getX()) < 120 ){
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
     * @param   g    The Graphics Object to be drawn on
     */
    private void drawLoki(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int h = (int) size.getHeight();

        g.drawImage(player.getBufferedImage(), player.getX(), h-200, this);
    }

    /**
     * Draws Daggers on the board
     *
     * @pre     Application has called Window
     * @post    dagger is drawn
     * @param   g    The Graphics Object
     */
    private void drawDaggers(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getSize();
        int h = (int) size.getHeight();

        for(int i = 0; i < daggers.size(); i++){
            g.drawImage(daggers.get(i).getBufferedImage(), daggers.get(i).getX(), h-200, this);
        }
    }

    /**
     * Creates thors
     *
     * @pre     All thors have died, or game is just starting
     * @post    private instance variable thors is populated according to what round it is
     */
    private void makeThors()
    {
        thors = new ArrayList<Thor>();
        for(int i = 0; i < round; i++){
            thors.add(new Thor(background.getWidth(this)));
        }
    }

    /**
     * Deals with the player dying
     *
     * @pre     Enemy has touched the player
     * @post    Game stops (must restart game to start again)
     * @param   g   Graphics object to print out that you died
     */
    private void die(Graphics g)
    {
        thors = new ArrayList<Thor>();
        setFont(new Font("Font", Font.BOLD, 50));
        g.setColor(Color.RED);
        g.drawString("You died! Rounds: " + round, background.getWidth(this)/3, 
            background.getHeight(this)/2);
        isOver = true;
        setEnabled(false);
    }

    /**
     * This is a timer that calls the repaint method every so often, creating the illusion of 
     * movement
     * 
     * @author Matt Wright
     * @version April 24, 2015
     */
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {            
            repaint();
        }
    }

    /**
     * This is the keyboard listener that listens for the arrow key presses and spacebar
     * and deals with it
     * 
     * @author Matt Wright
     * @version April 24, 2015
     */
    private class KeyboardPressListener implements KeyListener
    {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if( keyCode == KeyEvent.VK_LEFT) {player.move(-2);}
            else if( keyCode == KeyEvent.VK_RIGHT){player.move(2);}
            if (keyCode == KeyEvent.VK_SPACE) {
                if(player.getDirection() < 0){
                    daggers.add(new Dagger(player.getX() -50, -4));
                }

                else if(player.getDirection() > 0){
                    daggers.add(new Dagger(player.getX() +50, 4));
                }
            }
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if( keyCode == KeyEvent.VK_LEFT){      
                player.move(0);
                player.setState(true);
            }
            else if( keyCode == KeyEvent.VK_RIGHT ) {
                player.move(0);
                player.setState(false);
            }
        }

        public void keyTyped(KeyEvent e) {}
    }
}

