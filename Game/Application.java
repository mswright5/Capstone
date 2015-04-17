import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.*;

/**
 * This is the application that will run the game. It contains a main method to start everything
 * 
 * @author Matt Wright
 * @version April 13, 2015
 */
public class Application extends JFrame
{
    private final int PANEL_WIDTH = 1280;
    private final int PANEL_HEIGHT = 720;

    /**
     * Default constructor for objects of class Application
     */
    public Application()
    {
        add(new Window());

        setSize(PANEL_WIDTH, PANEL_HEIGHT);

        setTitle("Loki Survival");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Main method that starts everything
     *
     * @pre     you have the game and a working computer
     * @post    the game will run
     */
    public static void main()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }

}
