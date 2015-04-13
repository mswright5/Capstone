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
    private final int PANEL_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 200;
    private final int PANEL_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 200;

    /**
     * Default constructor for objects of class Application
     */
    public Application()
    {
        add(new Window());

        setSize(PANEL_WIDTH, PANEL_HEIGHT);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
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
