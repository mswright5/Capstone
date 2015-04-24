import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This is the application that will run the game. It contains a main method to start everything and give the
 * window focus for the keyboard.
 * 
 * @author Matt Wright
 * @version April 24, 2015
 */
public class Application extends JFrame
{
    private final int PANEL_WIDTH = 1280;
    private final int PANEL_HEIGHT = 720;
    
    private Window panel;
    
    /**
     * Default constructor for objects of class Application
     */
    public Application()
    {
        panel = new Window();
        add(panel);
        
        addWindowListener(new FrameWindowListener());

        setSize(PANEL_WIDTH, PANEL_HEIGHT);

        setTitle("Loki Survival");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Main method that starts everything
     *
     * @pre     you have the game and a working computer and jre installed
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
    
    
    /**This is the application that will run the game. It contains a main method to start everything and give the
       window focus for the keyboard. */
    class FrameWindowListener extends WindowAdapter
    {
        public void windowOpened(WindowEvent event)
        {
            panel.requestFocusInWindow();
        }
    }

}
