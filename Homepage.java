import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Homepage extends JFrame implements ActionListener {
	JPanel panel;

	JLabel usernameLabel, passwordLabel,newaccountLabel;
	JTextField usernameTextField;
	JPasswordField passwordField;
	static JButton loginButton;
	JButton signUpButton, exitButton, forgotPasswordButton, aboutButton, adminLoginButton;
	ImageIcon exitIcon;
	ImageIcon aboutIcon;
	JCheckBox showPasswordCheckBox;

	public Homepage() {
		//name of the frame
		super("Login Home Page");
		this.setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 700);
		panel.setLayout(null);
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Segeo UI", Font.BOLD, 15));
		usernameLabel.setForeground(Color.black);
		usernameLabel.setBounds(435, 245, 200, 35);
		panel.add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(435, 280, 200, 35);
		//usernameTextField.setFont(new Font("Serif", Font.PLAIN, 19));
		// usernameTextField.addFocusListener(new FocusListener() {
		// @Override
		// public void focusGained(FocusEvent e) {
		// usernameTextField.setText("");
		// }

		// @Override
		// public void focusLost(FocusEvent e) {
		// if (usernameTextField.getText().isEmpty()) {
		// usernameTextField.setText("User Name");
		// }
		// }
		// });
		panel.add(usernameTextField);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Segeo UI", Font.BOLD, 15));
		passwordLabel.setForeground(Color.black);
		passwordLabel.setBounds(435, 315, 200, 35);
		panel.add(passwordLabel);
		passwordField = new JPasswordField();
		//passwordField.setFont(new Font("Serif", Font.PLAIN, 19));
		passwordField.setBounds(435, 345, 200, 35);
		// passwordField.addFocusListener(new FocusListener() {
		// @Override
		// public void focusGained(FocusEvent e) {
		// passwordField.setText("");
		// }

		// @Override
		// public void focusLost(FocusEvent e) {
		// if (passwordField.getText().isEmpty()) {
		// passwordField.setText("Password");
		// }
		// }
		// });
		panel.add(passwordField);

		showPasswordCheckBox = new JCheckBox("Show password");
		showPasswordCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		showPasswordCheckBox.setBounds(435, 385, 200, 40);
		showPasswordCheckBox.addActionListener(this);
		showPasswordCheckBox.setOpaque(false);
		showPasswordCheckBox.setFocusable(false);
		showPasswordCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(showPasswordCheckBox);

		forgotPasswordButton = new JButton("Forgotten Password ?");
		forgotPasswordButton.setBounds(430, 415, 200, 40);
		Font forgotFont = new Font("Segoe UI", Font.PLAIN, 14);
		forgotPasswordButton.setBorder(BorderFactory.createEmptyBorder());
		forgotPasswordButton.setFont(forgotFont);
		forgotPasswordButton.setOpaque(false);
		forgotPasswordButton.setForeground(new Color(179, 63, 64));
		forgotPasswordButton.setOpaque(false);
		forgotPasswordButton.setBackground(new Color(0, 0, 0, 0));
		panel.add(forgotPasswordButton);
		forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		loginButton.setForeground(Color.white);
		loginButton.setBackground(new Color(102, 140, 208));
		loginButton.setBounds(485, 455, 90, 35);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(loginButton);

		newaccountLabel = new JLabel("Don't have an account?");
		newaccountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		newaccountLabel.setForeground(Color.black);
		newaccountLabel.setBounds(430, 500, 200, 35);
		panel.add(newaccountLabel);


		signUpButton = new JButton("Sign Up");
		signUpButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		signUpButton.setForeground(Color.red);
		signUpButton.setBackground(new Color(102, 140, 208));
		signUpButton.setBorder(null);
		signUpButton.setBounds(570, 500, 90, 35);
		signUpButton.setOpaque(false);
		signUpButton.addActionListener(this);
		signUpButton.setFocusable(false);
		signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(signUpButton);

		adminLoginButton = new JButton("Admin Login");
		adminLoginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		adminLoginButton.setForeground(Color.white);
		adminLoginButton.setBackground(new Color(102, 140, 208));
		adminLoginButton.setOpaque(false);
		adminLoginButton.setBounds(790, 20, 190, 35);
		adminLoginButton.addActionListener(this);
		adminLoginButton.setFocusable(false);
		adminLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(adminLoginButton);

		exitIcon = new ImageIcon("test/Exit.png");
		exitButton = new JButton("Exit",exitIcon);
		exitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		exitButton.setForeground(Color.white);

		exitButton.setBounds(30, 595,100, 35); 
		exitIcon.getIconWidth();
		exitIcon.getIconHeight();
		exitButton.setBackground(Color.black);
		exitButton.setOpaque(false);
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		panel.add(exitButton);

		//aboutIcon = new ImageIcon("test/about.png");
		aboutButton = new JButton("Contributors");
		aboutButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		aboutButton.setForeground(Color.white);
		aboutButton.setBounds(15, 20, 140, 35);
		aboutButton.setBackground(new Color(102, 140, 208));
		aboutButton.setOpaque(false);
		aboutButton.addActionListener(this);
		aboutButton.setFocusable(false);
		aboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aboutButton.setBorder(BorderFactory.createEmptyBorder());
		panel.add(aboutButton);

		usernameLabel = new JLabel(new ImageIcon(getClass().getResource("/images/homepage.png")));
		usernameLabel.setBounds(0, 0, 1000, 700);
		panel.add(usernameLabel);

		JButton button1 = new JButton();
		panel.add(button1);
		button1.requestFocusInWindow();

		this.add(panel);
		setVisible(true);
		exitButton.addActionListener(this);
		aboutButton.addActionListener(this);
		forgotPasswordButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == signUpButton) {
			Registration registration = new Registration();
			this.setVisible(false);
			registration.setVisible(true);
		}

		else if (ae.getSource() == loginButton) {
			if (usernameTextField.getText().length() <= 0 || passwordField.getText().length() <= 0) {
				JOptionPane.showMessageDialog(this, "Enter User Name and Password");

			}

			else {

				try {
					String userNameS = "Name            :  " + usernameTextField.getText();
					String passwordS = "Password      :  " + passwordField.getText();

					BufferedReader reader = new BufferedReader(new FileReader("data\\data.txt"));

					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int i = 0; i <= totalLines; i++) {
						String line = Files.readAllLines(Paths.get("data\\data.txt")).get(i);

						if (line.equals(userNameS)) {
							String line2 = Files.readAllLines(Paths.get("data\\data.txt")).get((i + 1));

							if (line2.equals(passwordS)) {

								JOptionPane.showMessageDialog(null, "Login Successful.");

								Home home = new Home();
								this.setVisible(false);
								home.setVisible(true);

								String line3 = Files.readAllLines(Paths.get("data\\data.txt")).get((i + 2));
								String line4 = Files.readAllLines(Paths.get("data\\data.txt")).get((i + 3));
								String line5 = Files.readAllLines(Paths.get("data\\data.txt")).get((i + 4));
								String line6 = Files.readAllLines(Paths.get("data\\data.txt")).get((i + 5));

								BufferedWriter writer = new BufferedWriter(new FileWriter("data\\login data.txt"));
								writer.write("" + line);
								writer.write("\n" + line2);
								writer.write("\n" + line3);
								writer.write("\n" + line4);
								writer.write("\n" + line5);
								writer.write("\n" + line6);
								writer.close();

								break;
							}
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong User Name or Password!");
				}

			}
		} else if (ae.getSource() == adminLoginButton) {
			setVisible(false);
			AdminLogin adminLogin = new AdminLogin();
			adminLogin.setVisible(true);
			JOptionPane.showMessageDialog(null, "By default, Admin Name and Password is : 'admin'", "Information!",
					JOptionPane.INFORMATION_MESSAGE);
		}

		else if (ae.getSource() == exitButton) {
			int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure want to exit ?", "Alart!",
					JOptionPane.YES_NO_OPTION);

			if (yesORno == 0) {
				System.exit(1);
			}
		}

		else if (ae.getSource() == aboutButton) {
			Contribution madeby = new Contribution();
			this.setVisible(false);
			madeby.setVisible(true);
		} else if (ae.getSource() == forgotPasswordButton) {
			panel.setVisible(false);
			new ForgetPass();
		}

		else if (showPasswordCheckBox.isSelected()) {
			passwordField.setEchoChar((char) 0);
		} else {
			passwordField.setEchoChar('*');

		}

	}

	public static void main(String[] args) {
		Homepage homepage = new Homepage();
		homepage.setVisible(true);
		// EventQueue.invokeLater(() -> loginButton.requestFocusInWindow());

	}

}
