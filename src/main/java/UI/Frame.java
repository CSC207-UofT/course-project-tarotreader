package UI;
import controllers.TarotUIController;
import entities.Reading;
import javax.swing.JFrame;

public class Frame extends JFrame{
    private TarotUIController appController;
    private Panel appPanel;

    /**
     * Checks if the app has ran and then loads the setupFrame() to create the frame
     * @param appControllerz - Looks for the program to run
     */
    public Frame(TarotUIController appControllerz)
    {
        super();
        this.appController = appControllerz;
        appPanel = new Panel(appController);

        setupFrame();
    }

    public void closeFrame()
    {
        this.setVisible(false);
        this.dispose();
    }

    /**
     * Constructor sets up the frame and its values/conditions
     */
    private void setupFrame()
    {
        this.setContentPane(appPanel);
        this.setTitle("Tarot Card Program");
        this.setResizable(false);
        this.setSize(900, 750);	//CAN CHANGE IN THE FUTURE!!!
        this.setVisible(true);
    }
}


