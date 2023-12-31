import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JFrame implements ActionListener {
    JLabel nameLabel, ageLabel, genderLabel, addressLabel, emailLabel, phoneLabel, infoLabel;
    JButton backButton, signOutButton;
    JPanel panel;
    String name, age, gender, address, email, phone;

    public Profile() {
        super("User Profile");
        this.setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBounds(0, 0, 1000, 700);
        panel.setLayout(null);

        ImageIcon back = new ImageIcon("images/Back.png");
        backButton = new JButton(back);
        backButton.setBounds(15, 15, back.getIconWidth(), back.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        panel.add(backButton);

        signOutButton = new JButton("Sign Out");
        signOutButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        signOutButton.setForeground(Color.black);
        signOutButton.setBackground(new Color(255, 230, 153));
        signOutButton.setBounds(15, 620, 120, 35);
        signOutButton.setOpaque(false);
        signOutButton.addActionListener(this);
        signOutButton.setFocusable(false);
        signOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(signOutButton);


        

        nameLabel = createLabel("UserName", 650, 200);

        ageLabel = createLabel("Age", 650, 250);

        genderLabel = createLabel("Gender", 650, 300);

        addressLabel = createLabel("Address", 650, 350);

        emailLabel = createLabel("Email", 650, 400);

        phoneLabel = createLabel("Phone", 650, 450);

        infoLabel = new JLabel(new ImageIcon(getClass().getResource("/images/profile (1).png")));
        infoLabel.setBounds(0, 0, 1000, 700);
        panel.add(infoLabel);

        try {
            File file = new File("data\\login data.txt");

            if (file.exists() && file.length() > 0) {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                name = reader.readLine();
                age = reader.readLine();
                gender = reader.readLine();
                address = reader.readLine();
                email = reader.readLine();
                phone = reader.readLine();

                reader.close();

                nameLabel.setText(name);
                ageLabel.setText(age);
                genderLabel.setText(gender);
                addressLabel.setText(address);
                emailLabel.setText(email);
                phoneLabel.setText(phone);
            } else {
                System.out.println("File doesn't exist or is empty.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.add(panel);
        backButton.addActionListener(this);
        setVisible(true);

        this.add(panel);
        signOutButton.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backButton) {
            Home h = new Home();
            this.setVisible(false);
            h.setVisible(true);
        }
            
            else if (ae.getSource() == signOutButton) {
                Homepage h = new Homepage();
                this.setVisible(false);
                h.setVisible(true);
            }
    }



    private JLabel createLabel(String labelText, int x, int y) {
        JLabel label = new JLabel();
        label.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        label.setForeground(Color.black);
        label.setBounds(x, y, 300, 40);
        label.setText(labelText);

        panel.add(label);
        return label;
    }
        public static void main(String[] args) {
        Profile u = new Profile();
        u.setVisible(true);
    }
}