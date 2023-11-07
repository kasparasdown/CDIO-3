import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Frame extends JFrame implements ActionListener{
	JButton button;
	JLabel label;
    JTextArea text;
	JPanel botPanel, midPanel;
	Font myFont = new Font("myFont", Font.BOLD, 25);

	Frame(){
		

		label = new JLabel("Welcome to Monopoly");
		label.setBounds(150, 150, 300, 200);
		label.setVisible(true);
        label.setFont(myFont);
        label.setBackground(Color.gray);

		botPanel = new JPanel();
		midPanel = new JPanel();
		botPanel.setBackground(Color.darkGray);
		midPanel.setBackground(Color.lightGray);
		botPanel.setPreferredSize(new Dimension(100, 100));
		midPanel.setPreferredSize(new Dimension(100, 100));
		
		button = new JButton();
		button.setBounds(0, 0, 50, 25);
		button.addActionListener(this);
		button.setText("I'm a button!");
		
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setFont(myFont);
		button.setForeground(Color.white);
		button.setBackground(Color.black);
		button.setBorder(BorderFactory.createEtchedBorder());
		
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

	@Override
	public void actionPerformed(ActionEvent click) {
		if(click.getSource()==button) {

		}	
	}
}
    
