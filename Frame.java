import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    JButton rollButton, skipButton, buyButton;
    JButton[] playerButton = new JButton[3];
    JLabel label, plabel;
    static JLabel locationLabel;
    JLabel[] pointsLabel;
    JPanel botPanel, midPanel, rightPanel;
    Font myFont = new Font("myFont", Font.BOLD, 23);
    Font smallFont = new Font("smallFont", Font.BOLD, 15);

    Frame() {
        label = new JLabel("Choose the number of players");
        label.setFont(myFont);
        label.setBackground(Color.gray);
        label.setVisible(true);
        label.setBorder(BorderFactory.createEmptyBorder(15, 0, 30, 0));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        locationLabel = new JLabel("START");
        locationLabel.setPreferredSize(new Dimension(250, 250));
        locationLabel.setFont(myFont);
        locationLabel.setBackground(Color.gray);
        locationLabel.setVisible(false);
        locationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        botPanel = new JPanel();
        botPanel.setBackground(Color.darkGray);
        botPanel.setPreferredSize(new Dimension(100, 100));
        botPanel.setLayout(new FlowLayout());

        midPanel = new JPanel();
        midPanel.setBackground(Color.lightGray);
        midPanel.setPreferredSize(new Dimension(100, 100));
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

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
        this.setTitle("Junior Monopoly");
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setVisible(true);
        this.setForeground(Color.darkGray);
        this.setLayout(new BorderLayout());
        this.add(botPanel, BorderLayout.SOUTH);
        this.add(midPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        botPanel.add(rollButton);
        botPanel.add(skipButton);
        botPanel.add(buyButton);
        midPanel.add(label);
        midPanel.add(locationLabel);

    }
    public void turnRoll(boolean status) {
            skipButton.setVisible(!status);
            rollButton.setVisible(status);

            Player currentPlayer = GameUtils.getCurrentPlayer();
            Tiles currentTile = currentPlayer.getCurrentTile(currentPlayer.getTile().getAllTiles());
            if (currentTile instanceof PropertyField) {
                PropertyField property = (PropertyField) currentTile;
        
                //debbuging
                System.out.println("Owner: " + property.getOwner());
                System.out.println("Is property owned? " + property.isOwned());
        
                buyButton.setVisible((property.getOwner() == null && !status) || (property.getOwner() != currentPlayer));
            } else {
                buyButton.setVisible(false);
            }
    }

    //Takes click from buttons, and do stuff
    @Override
    public void actionPerformed(ActionEvent click) {
        for (int j = 0; j < 3; j++) {
            if (click.getSource() == playerButton[j]) {
                GameUtils.totalPlayers(j + 2);
                for (var i = 0; i < 3; i++) {
                    playerButton[i].setVisible(false);
                }
                rollButton.setVisible(true);
                label.setText(GameUtils.getCurrentPlayer().getName() + " starts. Roll!");
                getPlayerLabels(); //Inserts the players Points on the right side
                locationLabel.setVisible(true);
            }
        }
        var rollResult = 0;
        //Rolls for turn, change turn to buystep/skipstep
        if (click.getSource() == rollButton) {
            turnRoll(false);
            rollResult = Die.dieRoll();
            GameUtils.getCurrentPlayer().addCoins(rollResult);//Adding coins to player wallet. NEED CHANGE!
            label.setText(GameUtils.getCurrentPlayer().getName() + " rolled: " + rollResult);
            GameUtils.getCurrentPlayer().move(rollResult);
            getPlayerLabels();
        }
        //Pass turn to next player
        if (click.getSource() == skipButton) {
            GameUtils.switchPlayer();
            locationLabel.setText(GameUtils.getCurrentPlayer().getCurrentTileString()); //Tells the new player where they are standing. CHANGE INTEGER
            label.setText(GameUtils.getCurrentPlayer().getName() + " it's your turn now, roll");
            turnRoll(true);
        }
        if (click.getSource() == buyButton) {
            GameUtils.getCurrentPlayer().buyProperty();
        }
    }

    //Call to get label with all the players points on.
    public JLabel[] getPlayerLabels() {
        rightPanel.removeAll();

        pointsLabel = new JLabel[GameUtils.playerNumbers];
        for (int i = 0; i < GameUtils.playerNumbers; i++) {
            pointsLabel[i] = new JLabel("P" + (i + 1) + ": " + GameUtils.getPlayerNumb(i).getCoin() + "$");
            pointsLabel[i].setFont(myFont);
            pointsLabel[i].setForeground(Color.BLACK);
			pointsLabel[i].setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            rightPanel.add(pointsLabel[i]);
        }
        rightPanel.revalidate();
        rightPanel.repaint();
        return pointsLabel;
    }
    //Tells the player location on Board
    public static void locationLabelText(String input) {
        locationLabel.setText(input);
    }
}
