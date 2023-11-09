import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class Frame extends JFrame implements ActionListener{
	JButton button;
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
		
		button = new JButton();
		button.setBounds(0, 0, 50, 25);
		button.addActionListener(this);
		button.setText("Roll");
		
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setFont(myFont);
		button.setBackground(Color.white);
		button.setVisible(false);
		
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
		botPanel.add(button);
		midPanel.add(label);
		this.add(botPanel, BorderLayout.SOUTH);
		this.add(midPanel, BorderLayout.CENTER);
		

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
				button.setVisible(true);
				label.setText(Player.getCurrentPlayer().getName()+" starts. Press the Roll button");
			}
		}
		if(click.getSource()==button) {
				var rollResult = Die.dieRoll(); // Call the dieRoll method on the class itself
				label.setText(Player.getCurrentPlayer().getName()+" rolled: " + rollResult);
			}
	}
}
    
