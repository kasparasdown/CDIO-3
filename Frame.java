import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    JButton rollButton, skipButton;
    JButton buyButton;
    JButton[] playerButton = new JButton[3];
    JLabel label, plabel, logoLabel, cardLabel, ownerLabel;
    JLabel locationLabel;
    JLabel[] pointsLabel;
    JPanel botPanel, midPanel, rightPanel;
    Font myFont = new Font("myFont", Font.BOLD, 23);
    Font smallFont = new Font("smallFont", Font.BOLD, 15);
    ImageIcon logo;

    Frame() {
        
        //top mainlabel
        label = new JLabel("Choose the number of players");
        label.setFont(myFont);
        label.setBackground(Color.gray);
        label.setVisible(true);
        label.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        //bottom label, tells what chancecard you drew
        cardLabel = new JLabel();
        cardLabel.setFont(myFont);
        cardLabel.setBackground(Color.gray);
        cardLabel.setVisible(false);
        cardLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Adds the image of the tiles, with owner names
        logoLabel = new JLabel();
        logoLabel.setVisible(false);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setIcon(Images.getImageIcon(0));
        logoLabel.setFont(new Font("myFont", Font.BOLD, 40));
        logoLabel.setForeground(Color.RED);
        logoLabel.setHorizontalTextPosition(JLabel.CENTER); //ownerlabel location

        
        //tells you where you are. Second label from top
        locationLabel = new JLabel("START");
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
        midPanel.add(logoLabel);
        midPanel.add(cardLabel);

    }
    //Switch between start of turn(rolling) and end of turn (buying or passing turn)
    public void turnRoll(boolean status) {
            buyButtonVisible(false); //Reset buybutton
            skipButton.setVisible(!status);
            rollButton.setVisible(status);
            if(Player.getCurrentPlayer().getTile() instanceof PropertyField){
                PropertyField tile = (PropertyField) Player.getCurrentPlayer().getTile();
                if((!tile.isOwned()) && tile.getPrice()<Player.getCurrentPlayer().getCoin()) {
                    buyButtonVisible(!status); //Change to true, when player is on a UnOwned Property!
                }
            }
    }
    public void buyButtonVisible(boolean status) {
        buyButton.setVisible(status);
    }
    public void setChanceCard(boolean visible, String text) {
        cardLabel.setVisible(visible);
        cardLabel.setText(text);
    }

    //Takes click from buttons, and do stuff
    @Override
    public void actionPerformed(ActionEvent click) {
        for (int j = 0; j < 3; j++) {
            if (click.getSource() == playerButton[j]) {
                Player.totalPlayers(j + 2);
                Player.createPlayers(); //This makes the player objects
                for (var i = 0; i < 3; i++) {
                    playerButton[i].setVisible(false);
                }
                rollButton.setVisible(true);
                label.setText(Player.getCurrentPlayer().getName() + " starts. Roll!");
                getPlayerLabels(); //Inserts the players Points on the right side
                locationLabel.setVisible(true);
                logoLabel.setVisible(true);
            }
        }
        var rollResult = 0;
        //Rolls for turn, change turn to buystep/skipstep
        if (click.getSource() == rollButton) {
            rollResult = Die.dieRoll();
            label.setText(Player.getCurrentPlayer().getName() + " rolled: " + rollResult);
            GameUtils.move(rollResult);
            turnRoll(false);
        }
        //Pass turn to next player
        if (click.getSource() == skipButton) {
            GameUtils.switchPlayer();
            turnRoll(true);
        }
        if (click.getSource() == buyButton) {
            GameUtils.buyProperty();
        }
        getPlayerLabels();
    }

    //Call to get label with all the players points on.
    public JLabel[] getPlayerLabels() {
        rightPanel.removeAll();

        pointsLabel = new JLabel[Player.playerNumbers];
        for (int i = 0; i < Player.playerNumbers; i++) {
            pointsLabel[i] = new JLabel("P" + (i + 1) + ": " + Player.getPlayerNumb(i).getCoin() + "$");
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
    public void locationLabelText(String input) {
        locationLabel.setText(input);
    }
    public void labelText(String input) {
        label.setText(input);
    }
    public void setLogo(int numb) {
        logoLabel.setIcon(Images.getImageIcon(numb));
    }
    public void setOwner(String name) {
        logoLabel.setText(name);
    }
    public void hideAll() {
        botPanel.setVisible(false);
        logoLabel.setVisible(false);
        locationLabel.setVisible(false);
        cardLabel.setVisible(false);
    }
}
