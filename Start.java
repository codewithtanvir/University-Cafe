import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JFrame implements ActionListener {

    private JButton getStartedButton;
    //private JLabel welcomeLabel;
    private JPanel panel;

    public Start() {
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Start");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1000, 700);
        add(panel);

        JLabel background = new JLabel(new ImageIcon("images/Welcome to aiub Cafeteria.png"));
        background.setBounds(0, 0, 1000, 700);
        panel.add(background);

       

        getStartedButton = new JButton("GetStarted");
      
        getStartedButton.setFont(new Font("Arial", Font.BOLD, 20));
       
        
        getStartedButtonsetBackground(Color.DARK_GRAY);
        getStartedButton.setBounds(200, 450, 150, 50);
        //getStartedButton.setOpaque(false);
        panel.add(getStartedButton);
        getStartedButton.addActionListener(this);
    }

    private void getStartedButtonsetBackground(Color black) {
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == getStartedButton) {
            Homepage h = new Homepage();
            this.setVisible(false);
            h.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Start s = new Start();
        s.setVisible(true);
    }
}
