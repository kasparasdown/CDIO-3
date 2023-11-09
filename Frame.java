import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Frame extends JFrame implements ActionListener{
	JButton rollButton, skipButton;
	JButton[] playerButton = new JButton[3];
	JLabel label;
	JPanel botPanel, midPanel;
	Font myFont = new Font("myFont", Font.BOLD, 25);
	ImageIcon logo;

	Frame(){

		label = new JLabel("Choose the number of players");
		label.setBounds(150, 150, 300, 200);
        label.setFont(myFont);
        label.setBackground(Color.gray);
		label.setVisible(true);

		botPanel = new JPanel();
		midPanel = new JPanel();
		botPanel.setBackground(Color.darkGray);
		midPanel.setBackground(Color.lightGray);
		botPanel.setPreferredSize(new Dimension(100, 100));
		midPanel.setPreferredSize(new Dimension(100, 100));
		
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
		
		for (var i=0; i<3; i++) {
			playerButton[i] = new JButton(String.valueOf(i+2));
			playerButton[i].addActionListener(this);
			playerButton[i].setFont(myFont);
			playerButton[i].setFocusable(false);
			botPanel.add(playerButton[i]);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
        this.setForeground(Color.darkGray);
		this.setLayout(new BorderLayout());
		botPanel.add(rollButton);
		botPanel.add(skipButton);
		midPanel.add(label);
		this.add(botPanel, BorderLayout.SOUTH);
		this.add(midPanel, BorderLayout.CENTER);
		

	}
	
	public void turnRoll(boolean isTrue) {
		if(isTrue) {
			skipButton.setVisible(false);
			rollButton.setVisible(true);
		}
		else {
			skipButton.setVisible(true);
			rollButton.setVisible(false);
		}
	}

	//Choosing number of players, and starts the game.
	@Override
	public void actionPerformed(ActionEvent click) {
		for(int j=0; j<3; j++) {
			if(click.getSource()==playerButton[j]) {
				Player.totalPlayers(j+2);
				Player.createPlayers();
				for (var i=0; i<3; i++) {
					playerButton[i].setVisible(false);
				}
				rollButton.setVisible(true);
				label.setText(Player.getCurrentPlayer().getName()+" starts. Press the Roll rollButton");
			}
		}
		if(click.getSource()==rollButton) {
				turnRoll(false);
				var rollResult = Die.dieRoll(); // Call the dieRoll method on the class itself
				Player.getCurrentPlayer().addCoins(rollResult); //Change later to money from the game!!!!
				label.setText(Player.getCurrentPlayer().getName()+" rolled: " + rollResult);
			}
		if(click.getSource()==skipButton) {
			Player.switchPlayer();
			label.setText(Player.getCurrentPlayer().getName()+" its your turn now, roll");
			turnRoll(true);
		}
	}
}
    
