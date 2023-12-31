import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
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

public class AdminLogin extends JFrame implements ActionListener {

    JPanel panel;
    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton exitButton, backButton;
    JCheckBox showPasswordCheckbox;
    static JButton loginButton;

    AdminLogin() {

        this.setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(0, 0, 1000, 700);
        panel.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        usernameLabel.setForeground(Color.white);
        usernameLabel.setBounds(400, 180, 200, 40);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(400, 220, 200, 30);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        usernameField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                usernameField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("User Name");
                }
            }
        });
        panel.add(usernameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(400, 250, 200, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        passwordField.setBounds(400, 290, 200, 30);
        passwordField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                passwordField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                }
            }
        });
        panel.add(passwordField);

        showPasswordCheckbox = new JCheckBox("Show password");
        showPasswordCheckbox.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        showPasswordCheckbox.setForeground(Color.white);
        showPasswordCheckbox.setBackground(new Color(202, 120, 246));
        showPasswordCheckbox.setOpaque(false);
        showPasswordCheckbox.setBounds(400, 330, 200, 30);
        showPasswordCheckbox.addActionListener(this);
        showPasswordCheckbox.setFocusable(false);
        showPasswordCheckbox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(showPasswordCheckbox);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(102, 140, 208));
        loginButton.setBounds(400, 370, 200, 35);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(loginButton);

        ImageIcon exitIcon = new ImageIcon("images/Exit.png");
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
        ImageIcon back = new ImageIcon("images/Back.png");
        backButton = new JButton(back);
        backButton.setBounds(22, 30, back.getIconWidth(), back.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.addActionListener(this);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        panel.add(backButton);

        usernameLabel = new JLabel(new ImageIcon(getClass().getResource("/images/AdminCafe.png")));
        usernameLabel.setBounds(0, 0, 1000, 700);
        panel.add(usernameLabel);

        this.add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exitButton) {
            int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure want to exit ?", "Alert!",
                    JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) {
                System.exit(1);
            }
        }

        else if (ae.getSource() == backButton) {
            Homepage homepage = new Homepage();
            this.setVisible(false);
            homepage.setVisible(true);
        } else if (showPasswordCheckbox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        }

        else if (ae.getSource() == loginButton) {

            String username = usernameField.getText().toLowerCase();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                try {

                    String userNameS = "Name : " + username;
                    String passwordS = "Password : " + password;
                    BufferedReader reader = new BufferedReader(new FileReader(".\\data\\admin_data.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get(".\\data\\admin_data.txt")).get(i);
                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get(".\\data\\admin_data.txt")).get((i + 1));
                            if (line2.equals(passwordS)) {
                                JOptionPane.showMessageDialog(null, "Admin Login Successful.", "Cafe!",
                                        JOptionPane.WARNING_MESSAGE);

                                setVisible(false);
                                Admin frame = new Admin();
                                frame.setVisible(true);
                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {

        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
    }
}