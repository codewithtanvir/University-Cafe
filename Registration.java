import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Registration extends JFrame implements ActionListener {

	JLabel labelTitle, labelUserName, labelMobileNumber, labelEmail, labelGender, labelOccupation, labelPassword, labelRetypePassword, labelShowPassword, labelAlreadyHaveAccount;

	JTextField textFieldUserName, textFieldMobileNumber, textFieldEmail;

	JButton buttonCreateAccount, buttonLogin;

	JPasswordField passwordField, retypePasswordField;

	JComboBox comboBoxGender, comboBoxOccupation;

	JCheckBox checkBoxShowPassword;

	JPanel panelRight;

	public Registration() {
		super("Sign Up");
		this.setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelRight = new JPanel();
		panelRight.setBounds(-200, 0, 500, 700);
		panelRight.setBackground(new Color(223, 207, 190));//transparent color for panel 2 
		panelRight.setLayout(null);

		labelTitle = new JLabel("Create your account");
		labelTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
		labelTitle.setForeground(Color.red);
		labelTitle.setBounds(340, 75, 500, 38);
		panelRight.add(labelTitle);

		labelUserName = new JLabel("User Name :");
		labelUserName.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelUserName.setForeground(Color.black);
		labelUserName.setBounds(270, 130, 200, 20);
		panelRight.add(labelUserName);

		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		textFieldUserName.setBounds(420, 130, 235, 25);
		textFieldUserName.addActionListener(this);
		panelRight.add(textFieldUserName);

		labelMobileNumber = new JLabel("Mobile Number :");
		labelMobileNumber.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelMobileNumber.setForeground(Color.black);
		labelMobileNumber.setBounds(270, 180, 250, 25);
		panelRight.add(labelMobileNumber);

		textFieldMobileNumber = new JTextField();
		textFieldMobileNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldMobileNumber.setBounds(420, 180, 235, 25);
		textFieldMobileNumber.addActionListener(this);
		panelRight.add(textFieldMobileNumber);

		labelEmail = new JLabel("Email :");
		labelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelEmail.setForeground(Color.black);
		labelEmail.setBounds(270, 230, 250, 25);
		panelRight.add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldEmail.setBounds(420, 230, 235, 25);
		textFieldEmail.addActionListener(this);
		panelRight.add(textFieldEmail);

		labelGender = new JLabel("Gender :");
		labelGender.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelGender.setForeground(Color.black);
		labelGender.setBounds(270, 280, 250, 22);
		panelRight.add(labelGender);

		String gender[] = { "Male", "Female" };
		comboBoxGender = new JComboBox(gender);
		comboBoxGender.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxGender.setBounds(420, 280, 235, 25);
		panelRight.add(comboBoxGender);

		labelOccupation = new JLabel("Occupation :");
		labelOccupation.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelOccupation.setForeground(Color.black);
		labelOccupation.setBounds(270, 330, 250, 22);
		panelRight.add(labelOccupation);

		String Occupation[] = { "Student", "Faculty", "Staff" };
		comboBoxOccupation = new JComboBox(Occupation);
		comboBoxOccupation.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxOccupation.setBounds(420, 330, 235, 25);
		panelRight.add(comboBoxOccupation);

		labelPassword = new JLabel("Password : ");
		labelPassword.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelPassword.setForeground(Color.black);
		labelPassword.setBounds(270, 380, 250, 25);
		panelRight.add(labelPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		passwordField.setBounds(420, 380, 235, 25);
		passwordField.setEchoChar('*');
		passwordField.addActionListener(this);
		panelRight.add(passwordField);

		labelRetypePassword = new JLabel("Retype Password:");
		labelRetypePassword.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		labelRetypePassword.setForeground(Color.black);
		labelRetypePassword.setBounds(270, 430, 250, 25);
		panelRight.add(labelRetypePassword);

		retypePasswordField = new JPasswordField();
		retypePasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		retypePasswordField.setBounds(420, 430, 235, 25);
		retypePasswordField.setEchoChar('*');
		retypePasswordField.addActionListener(this);
		panelRight.add(retypePasswordField);

		checkBoxShowPassword = new JCheckBox("Show password");
		checkBoxShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		checkBoxShowPassword.setForeground(Color.black);
		checkBoxShowPassword.setBackground(new Color(223, 207, 190));
		checkBoxShowPassword.setBounds(415, 460, 270, 20);
		checkBoxShowPassword.addActionListener(this);
		checkBoxShowPassword.setFocusable(false);
		checkBoxShowPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRight.add(checkBoxShowPassword);

		buttonCreateAccount = new JButton("Create Account");
		buttonCreateAccount.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		buttonCreateAccount.setForeground(Color.white);
		buttonCreateAccount.setBackground(new Color(102, 140, 208));
		buttonCreateAccount.setBounds(360, 500, 270, 38);
		buttonCreateAccount.addActionListener(this);
		buttonCreateAccount.setFocusable(false);
		buttonCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRight.add(buttonCreateAccount);

		labelAlreadyHaveAccount = new JLabel("Already have an account?");
		labelAlreadyHaveAccount.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		labelAlreadyHaveAccount.setForeground(Color.black);
		labelAlreadyHaveAccount.setBounds(325, 550, 300, 30);
		panelRight.add(labelAlreadyHaveAccount);

		buttonLogin = new JButton("Login");
		buttonLogin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		buttonLogin.setForeground(Color.red);
		buttonLogin.setBackground(new Color(223, 207, 190));
		buttonLogin.setBorder(null);
		buttonLogin.setBounds(585, 550, 80, 30);
		buttonLogin.addActionListener(this);
		buttonLogin.setFocusable(false);
		buttonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelRight.add(buttonLogin);

		this.add(panelRight);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == buttonLogin) {
			Homepage l = new Homepage();
			this.setVisible(false);
			l.setVisible(true);
		}

		else if (ae.getSource() == buttonCreateAccount) {

			if (textFieldUserName.getText().length() <= 0 || textFieldMobileNumber.getText().length() <= 0 || textFieldEmail.getText().length() <= 0
					|| passwordField.getText().length() <= 0 || retypePasswordField.getText().length() <= 0) {
				JOptionPane.showMessageDialog(this, "Fill all information");
			}

			else if (!(passwordField.getText()).equals(retypePasswordField.getText())) {
				JOptionPane.showMessageDialog(this, " Password doesn't match ");
			}

			else {
				JOptionPane.showMessageDialog(this, " Account created successfully !! ");

				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("data\\data.txt", true));
					writer.write("Name            :  " + textFieldUserName.getText());
					writer.write("\nPassword      :  " + passwordField.getText());
					writer.write("\nMobile        :  " + textFieldMobileNumber.getText());
					writer.write("\nEmail         :  " + textFieldEmail.getText());
					writer.write("\nGender        :  " + comboBoxGender.getSelectedItem());
					writer.write("\nOccupation    :  " + comboBoxOccupation.getSelectedItem() + "\n=================\n");
					writer.close();

				} catch (IOException e) {
					System.out.println("exception handled");
				}

				textFieldUserName.setText(null);
				textFieldMobileNumber.setText(null);
				textFieldEmail.setText(null);
				passwordField.setText(null);
				retypePasswordField.setText(null);
			}

		}

		else if (checkBoxShowPassword.isSelected()) {
			passwordField.setEchoChar((char) 0);
			retypePasswordField.setEchoChar((char) 0);

		}

		else {
			passwordField.setEchoChar('*');
			retypePasswordField.setEchoChar('*');

		}

	}

	public static void main(String[] args) {
		Registration r = new Registration();

	}

}