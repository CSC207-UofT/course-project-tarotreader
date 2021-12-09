package presenters;

import entities.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

public class TarotFrame extends JFrame {

    private JPanel cardsPanel;
    private JTextArea readingArea;
    private GridLayout layout;

    public TarotFrame(ArrayList<Card> cards, String reading) {
        super();
        setName("Tarot Reader 3000");
        setVisible(true);
        setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 900);
        setLocationRelativeTo(null);
        setVisible(true);
        readingArea = new JTextArea(reading);
        readingArea.setLineWrap(true);
        readingArea.setSize(300,300);
        cardsPanel = new JPanel();
        cardsPanel.setBackground(Color.BLACK);
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
        readingArea.setEditable(false);
        readingArea.setBackground(Color.ORANGE);

    }
}
