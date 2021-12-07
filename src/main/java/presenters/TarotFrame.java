package presenters;

import entities.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TarotFrame extends JFrame {

    private JPanel cardsPanel;
    private JTextArea readingArea;
    private GridLayout layout;

    public TarotFrame(ArrayList<Card> cards, String reading) {
        super();
        setName("Tarot Reader 3000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        readingArea = new JTextArea(reading);
        cardsPanel = new JPanel();
        layout = new GridLayout(1, cards.size());
        cardsPanel.setLayout(layout);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        for (Card card : cards) {
            cardsPanel.add(new TarotCardImage(card.getName()));
        }
        add(cardsPanel, BorderLayout.CENTER);
        setVisible(true);
        add(readingArea, BorderLayout.SOUTH);
        setVisible(true);
    }
}