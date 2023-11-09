import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    JButton rollButton, skipButton, buyButton;
    JButton[] playerButton = new JButton[3];
    JLabel label, plabel;
    JLabel[] pointsLabel;
    JPanel botPanel, midPanel, rightPanel;
    Font myFont = new Font("myFont", Font.BOLD, 23);
    Font smallFont = new Font("smallFont", Font.BOLD, 15);
    ImageIcon logo;

    Frame() {
        label = new JLabel("Choose the number of players");
        label.setFont(myFont);
        label.setBackground(Color.gray);
        label.setVisible(true);

        botPanel = new JPanel();
        botPanel.setBackground(Color.darkGray);
        botPanel.setPreferredSize(new Dimension(100, 100));
        botPanel.setLayout(new FlowLayout());

        midPanel = new JPanel();
        midPanel.setBackground(Color.lightGray);
        midPanel.setPreferredSize(new Dimension(100, 100));
        midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.orange);
        rightPanel.setPreferredSize(new Dimension(125, 100));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rollButton = new JButton("Roll");
        rollButton.setBounds(0, 0, 50, 25);
        rollButton.addActionListener(this);
        rollButton.setFocusable(false);
        rollButton.setHorizontalTextPosition(JButton.CENTER);
        rollButton.setVerticalTextPosition(JButton.CENTER);
        rollButton.setFont(myFont);
        rollButton.setBackground(Color.white);
        rollButton.setVisible(false);

        skipButton = new JButton("Pass");
        skipButton.setBounds(0, 0, 50, 25);
        skipButton.addActionListener(this);
        skipButton.setFocusable(false);
        skipButton.setHorizontalTextPosition(JButton.CENTER);
        skipButton.setVerticalTextPosition(JButton.CENTER);
        skipButton.setFont(myFont);
        skipButton.setBackground(Color.white);
        skipButton.setVisible(false);

        buyButton = new JButton("Buy");
        buyButton.setBounds(0, 0, 50, 25);
        buyButton.addActionListener(this);
        buyButton.setFocusable(false);
        buyButton.setHorizontalTextPosition(JButton.CENTER);
        buyButton.setVerticalTextPosition(JButton.CENTER);
        buyButton.setFont(myFont);
        buyButton.setBackground(Color.white);
        buyButton.setVisible(false);

        for (var i = 0; i < 3; i++) {
            playerButton[i] = new JButton(String.valueOf(i + 2));
            playerButton[i].addActionListener(this);
            playerButton[i].setFont(myFont);
            playerButton[i].setFocusable(false);
            botPanel.add(playerButton[i]);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setVisible(true);
        this.setForeground(Color.darkGray);
        this.setLayout(new BorderLayout());
        botPanel.add(rollButton);
        botPanel.add(skipButton);
        botPanel.add(buyButton);
        midPanel.add(label);
        this.add(botPanel, BorderLayout.SOUTH);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

    }

    public void turnRoll(boolean status) {
            skipButton.setVisible(!status);
            rollButton.setVisible(status);
            if(true) buyButton.setVisible(!status); //Change to true, when player is on a UnOwned Property!
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        for (int j = 0; j < 3; j++) {
            if (click.getSource() == playerButton[j]) {
                Player.totalPlayers(j + 2);
                Player.createPlayers();
                for (var i = 0; i < 3; i++) {
                    playerButton[i].setVisible(false);
                }
                rollButton.setVisible(true);
                label.setText(Player.getCurrentPlayer().getName() + " starts. Roll!");
                getPlayerLabels();
            }
        }
        if (click.getSource() == rollButton) {
            turnRoll(false);
            var rollResult = Die.dieRoll();
            Player.getCurrentPlayer().addCoins(rollResult);
            label.setText(Player.getCurrentPlayer().getName() + " rolled: " + rollResult);
            getPlayerLabels();
        }
        if (click.getSource() == skipButton) {
            Player.switchPlayer();
            label.setText(Player.getCurrentPlayer().getName() + " it's your turn now, roll");
            turnRoll(true);
        }
    }

    public JLabel[] getPlayerLabels() {
        // Clear existing labels
        rightPanel.removeAll();

        pointsLabel = new JLabel[Player.playerNumbers];
        for (int i = 0; i < Player.playerNumbers; i++) {
            pointsLabel[i] = new JLabel("P" + (i + 1) + ": " + Player.getPlayerNumb(i).getCoin() + "$");
            pointsLabel[i].setFont(myFont);
            pointsLabel[i].setForeground(Color.BLACK);
			pointsLabel[i].setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            rightPanel.add(pointsLabel[i]);
        }
        // Refresh the GUI
        rightPanel.revalidate();
        rightPanel.repaint();

        return pointsLabel;
    }
}
