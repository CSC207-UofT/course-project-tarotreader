package UI;
import javax.swing.JOptionPane;

public class PopupDisplay {
    private final String windowTitle;

    public PopupDisplay()
    {
        windowTitle = "Tarot Reader";
    }

    public void displayText(String message)
    {
        JOptionPane.showMessageDialog(null,  message, windowTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public String collectResponse(String question)
    {
        String answer = "";

        answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE);

        return answer;
    }
}

