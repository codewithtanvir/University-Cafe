import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
	
	JLabel signOutLabel, aboutUsLabel, homeLabel, breakfastLabel, lunchLabel, profileLabel;
	JButton signOutButton, homeButton, breakfastButton, lunchButton, profileButton, drinksButton;
	JPanel panel;

	public Home()
	{
		super("Home");
		this.setSize(1000,715);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(0,0,1000,700);
		panel.setBackground(new Color(216,228,250));
		panel.setLayout(null);

		signOutButton = new JButton( new ImageIcon(getClass().getResource("/images/logout.png")));// button name signout
		//signOutButton.setFont(new Font("Segoe UI",Font.PLAIN,17)); // Change font to Segoe UI
		
		//signOutButton.setBorder(null);
		signOutButton.setBounds(5,605,100,50); // Adjusted button size and position
		//signOutButton.setBackground(new Color(255,0,0));
		signOutButton.addActionListener(this);
		//panel.add(signOutButton);
	   
		
	   
		// homeButton = new JButton("Home");
		// homeButton.setFont(new Font("Segoe UI",Font.BOLD,23)); // Change font to Segoe UI
		// homeButton.setForeground(Color.red);
		// homeButton.setBackground(new Color(0,0,0,200));
		// homeButton.setBorder(null);
		// homeButton.setBounds(590,135,100,50); // Adjusted button size and position
		// homeButton.addActionListener(this);
		// panel.add(homeButton);

		breakfastButton = new JButton( new ImageIcon(getClass().getResource("/images/1.png")));
		breakfastButton.setFont(new Font("Open Sans",Font.BOLD,23));
		breakfastButton.setForeground(Color.DARK_GRAY);
	//	breakfastButton.setBackground(new Color(173,216,230));
		breakfastButton.setBorder(null);
		breakfastButton.setBounds(119,494,185,152); // Adjusted button size and position
		breakfastButton.addActionListener(this);
		panel.add(breakfastButton);

		lunchButton = new JButton(new ImageIcon(getClass().getResource("/images/2.png")));
		lunchButton.setFont(new Font("Segoe UI",Font.BOLD,23)); // Change font to Segoe UI
		lunchButton.setForeground(Color.white);
		//lunchButton.setBackground(new Color(0,0,0,200));
		lunchButton.setBorder(null);
		lunchButton.setBounds(414,494,185,152); // Adjusted button size and position
		lunchButton.addActionListener(this);
		panel.add(lunchButton);

		ImageIcon profileIcon = new ImageIcon("images/profile.png");
		profileButton = new JButton(profileIcon);
		profileButton.setOpaque(false);
		profileButton.setBounds(920,9,profileIcon.getIconWidth(), profileIcon.getIconHeight());
		profileButton.addActionListener(this);
		profileButton.setBackground(Color.black);
		profileButton.setBorder(BorderFactory.createEmptyBorder());
		panel.add(profileButton);
	   
		drinksButton = new JButton( new ImageIcon(getClass().getResource("/images/3.png")));
		drinksButton.setFont(new Font("Segoe UI",Font.BOLD,23)); // Change font to Segoe UI
		drinksButton.setForeground(Color.white);
		drinksButton.setBackground(new Color(0,0,0,200));
		drinksButton.setBorder(null);
		drinksButton.setBounds(709,494,185,152); // Adjusted button size and position
		drinksButton.addActionListener(this);
		panel.add(drinksButton);

		JLabel label = new JLabel(new ImageIcon(getClass().getResource("/images/aiubCafeteria.png")));
		label.setBounds(0,0,1000,700);
		panel.add(label);

		this.add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
		
		if (ae.getSource() == signOutButton) {
			Homepage homepage = new Homepage();
			this.setVisible(false);
			homepage.setVisible(true);
		}

		else if(ae.getSource()==profileButton)
		{
			Profile userInfo = new Profile();
			this.setVisible(false);
			userInfo.setVisible(true);
		}

		else if(ae.getSource()==breakfastButton)
		{
			Breakfast breakfast = new Breakfast();
			this.setVisible(false);
			breakfast.setVisible(true);
		}
		
		else if(ae.getSource()==lunchButton)
		{
			Lunch lunch = new Lunch();
			this.setVisible(false);
			lunch.setVisible(true);
		}

		

		else if(ae.getSource()==drinksButton)
		{
			Drinks drinks = new Drinks();
			this.setVisible(false);
			drinks.setVisible(true);
		}
	}

	public static void main(String [] args)
	{
		Home home = new Home();
		home.setVisible(true);
		
		
	}
}