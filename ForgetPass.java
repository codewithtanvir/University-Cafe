import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgetPass extends JFrame implements ActionListener {
    private JPanel P1;
    private JLabel l1, username;
    private JTextField t1;
    private JButton next;
    private JButton backButton;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;
    protected static int deleteLine;
    static JButton b1;

    public ForgetPass() {
        this.setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        P1 = new JPanel();
        P1.setBounds(0, 0, 1000, 700);
        P1.setLayout(null);

        username = new JLabel("Username");
        username.setBounds(490, 240, 230, 45);
        username.setFont(new Font("Serif", Font.PLAIN, 22));
        P1.add(username);
        t1 = new JTextField();
        t1.setBounds(490, 280, 230, 45);
        t1.setFont(new Font("Open Sans", Font.PLAIN, 22));
        P1.add(t1);

        ImageIcon fnext = new ImageIcon("images/CONTINUE.png");
        next = new JButton(fnext);
        next.setBounds(670, 340, 100, 40);
        next.setBackground(new Color(0, 0, 0, 0));
        next.setOpaque(false);
        next.setBorder(BorderFactory.createEmptyBorder());
        next.setCursor(cursor);
        next.setVisible(true);
        P1.add(next);

       // ImageIcon back = new ImageIcon("test/Back.png");
        backButton = new JButton("Back");
       // backButton.setBounds(15, 605, back.getIconWidth(), back.getIconHeight());
        backButton.setBounds(15, 605, 100, 40);
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        P1.add(backButton);

        l1 = new JLabel(new ImageIcon(getClass().getResource("/images/forgetpass.png")));
        l1.setBounds(0, 0, 1000, 700);
        P1.add(l1);

        JButton b1 = new JButton();
        P1.add(b1);
        b1.requestFocusInWindow();

        setVisible(true);
        this.add(P1);
        next.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String user = t1.getText().trim(); // Get the entered username
        boolean userEmpty = user.isEmpty();
        boolean userFound = false; // Add this flag

        if (e.getSource() == next) {
            try {
                File userfile = new File("data\\data.txt");
                
                if (userfile.exists()) {
                    BufferedReader readFile = new BufferedReader(new FileReader("data\\data.txt"));
                    String line;
                    while ((line = readFile.readLine()) != null) {
                        if (line.trim().equals("Name            :  " + user)) { // Check for exact match
                            userFound = true; // Set the flag to true
                            while ((line = readFile.readLine()) != null) {
                                if (line.startsWith("Password")) {
                                    String password = line.split(":")[1].trim(); // Get the password
                                    JOptionPane.showMessageDialog(null, "The password for " + user + " is " + password);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    readFile.close();
                }
                 if (userEmpty) {
                    // Your existing code...
                    JOptionPane.showMessageDialog(null, "Please enter your username");
                }

                if (!userFound) {
                    JOptionPane.showMessageDialog(null, "Username not found");
                }

               
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File not found");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file");
            }
        }
        backButton = (JButton) e.getSource();
        if (backButton == backButton) {
            this.setVisible(false);
            Homepage h = new Homepage();
            h.setVisible(true);

        }
    }

    public static void main(String[] args) {
        ForgetPass frame = new ForgetPass();
        frame.setVisible(true);
    }
}
