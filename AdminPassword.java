import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminPassword extends JFrame {

    private Container container;
    private ImageIcon icon;
    private JLabel titleLabel;
    private Font titleFont, labelFont, passwordFont;
    private JTextField nameTextField;
    private JButton closeButton, changeButton, hiddenButton;
    private JPasswordField passwordField;
    private Cursor cursor;

    AdminPassword() {

        this.setTitle("Admin Reset");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.decode("#F2F2F2"));

        titleFont = new Font("Segoe UI Black", Font.BOLD, 40);
        labelFont = new Font("Segoe UI Black", Font.PLAIN, 25);
        passwordFont = new Font("Segoe UI Black", Font.PLAIN, 35);

        titleLabel = new JLabel();
        titleLabel.setText("Change Admin Name");
        titleLabel.setBounds(50, 5, 500, 90);
        titleLabel.setFont(titleFont);
        container.add(titleLabel);

        titleLabel = new JLabel();
        titleLabel.setText("And Password");
        titleLabel.setBounds(50, 50, 500, 90);
        titleLabel.setFont(titleFont);
        container.add(titleLabel);

        titleLabel = new JLabel();
        titleLabel.setText("Name");
        titleLabel.setBounds(400, 180, 500, 50);
        titleLabel.setFont(labelFont);
        container.add(titleLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(400, 220, 250, 35);
        nameTextField.setFont(labelFont);
        container.add(nameTextField);

        titleLabel = new JLabel();
        titleLabel.setText("Password");
        titleLabel.setBounds(400, 250, 500, 50);
        titleLabel.setFont(labelFont);
        container.add(titleLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 290, 250, 35);
        passwordField.setFont(passwordFont);
        passwordField.setEchoChar('*');
        container.add(passwordField);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        closeButton = new JButton("Close");
        closeButton.setBounds(31, 580, 200, 35);
        closeButton.setFont(labelFont);
        closeButton.setCursor(cursor);
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.decode("#2E75B6"));
        container.add(closeButton);

        changeButton = new JButton("Change");
        changeButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        changeButton.setForeground(Color.white);
        changeButton.setBackground(new Color(102, 140, 208));
        changeButton.setBounds(400, 350, 200, 35);
        // changeButton.addActionListener(this);
        changeButton.setFocusable(false);
        changeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        container.add(changeButton);

        hiddenButton = new JButton("");
        hiddenButton.setBounds(0, 0, 0, 0);
        container.add(hiddenButton);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin fra = new Admin();
                fra.setVisible(true);
            }
        });

        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = nameTextField.getText().toLowerCase();
                String textField2 = passwordField.getText();

                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    String adminFile = "data\\admin_data.txt";
                    File oldFile = new File(adminFile);
                    oldFile.delete();
                    File dump = new File(adminFile);

                    try {

                        FileWriter fw = new FileWriter(adminFile, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        pw.println("==========================================");
                        pw.println("=== ###  Admin Data  ### ===");
                        pw.println("==========================================");
                        pw.println("Name : " + textField1);
                        pw.println("Password : " + textField2);
                        pw.println("==========================================");

                        pw.flush();
                        pw.close();
                        bw.close();
                        fw.close();

                        JOptionPane.showMessageDialog(null, "Admin Name and Password has been changed.",
                                "Admin Passowrd", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        Admin fram = new Admin();
                        fram.setVisible(true);

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                }

            }
        });
    }

    public static void main(String[] args) {

        AdminPassword frame = new AdminPassword();
        frame.setVisible(true);
    }
}