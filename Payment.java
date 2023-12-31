import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Payment extends JFrame implements ActionListener {
    
    JLabel backButton, confirmButton, accountNumberLabel, passwordLabel, paymentBackgroundLabel;
	   
	JButton backBtn, confirmBtn;

    JRadioButton bkashRadioButton, nogodRadioButton;

    JPanel panel1, panel2;

    JTextField accountNumberTextField;

    JPasswordField passwordField;
    JCheckBox showPasswordCheckbox;


    public Payment()
    {
        super("Payment");
        this.setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        panel1 = new JPanel();
        panel1.setBounds(0,0,1000,700);
        panel1.setBackground(new Color(216,228,250));
        panel1.setLayout(null);

 
       backBtn = new JButton("Back");
	   backBtn.setFont(new Font("Segoe UI",Font.PLAIN,22));
	   backBtn.setForeground(Color.black);
	   backBtn.setBackground(new Color(255,230,153));
	   backBtn.setBounds(15,620,90,35);
	   backBtn.addActionListener(this);
	   backBtn.setFocusable(false);
       backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   panel1.add(backBtn);


       confirmBtn = new JButton("Confirm");
	   confirmBtn.setFont(new Font("Segoe UI",Font.PLAIN,24));
	   confirmBtn.setForeground(Color.GRAY);
	   confirmBtn.setBackground(Color.DARK_GRAY);// gray rgb(146,208,80)
	   confirmBtn.setBounds(350,465,200,40);
	   confirmBtn.addActionListener(this);
	   confirmBtn.setFocusable(false);
      // confirmBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   panel1.add(confirmBtn);

       bkashRadioButton = new JRadioButton();
       bkashRadioButton.setOpaque(false); 
       bkashRadioButton.setBounds(340, 210, 20, 20);
       bkashRadioButton.setBackground(new Color(218,227,243));
       bkashRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       bkashRadioButton.setFocusable(false);
       panel1.add(bkashRadioButton);

       backButton = new JLabel(new ImageIcon(getClass().getResource("/images/bkashlogo.png")));
       //backButton.setOpaque(false);
       backButton.setBounds(365, 190, 110, 70);
       panel1.add(backButton);

       nogodRadioButton = new JRadioButton();
       nogodRadioButton.setOpaque(false);
       nogodRadioButton.setBounds(490, 210,20,20);
       nogodRadioButton.setBackground(new Color(218,227,243));//color name 
       nogodRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       nogodRadioButton.setFocusable(false);
       panel1.add(nogodRadioButton);
      

       confirmButton = new JLabel(new ImageIcon(getClass().getResource("/images/nogod.png")));
       confirmButton.setOpaque(true);
       confirmButton.setBackground(Color.red);
       confirmButton.setBounds(515, 190, 110, 70);
       panel1.add(confirmButton);

       ButtonGroup group = new ButtonGroup();
       group.add(bkashRadioButton);
       group.add(nogodRadioButton);

       accountNumberLabel = new JLabel("Your account number:");
       accountNumberLabel.setFont(new Font("Segoe UI",Font.PLAIN,16));
       //accountNumberLabel.setOpaque(true);
       accountNumberLabel.setBackground(new Color(218,227,243));
       accountNumberLabel.setBounds(350,260,200,30);
       panel1.add(accountNumberLabel);

       accountNumberTextField = new JTextField();
       accountNumberTextField.setFont(new Font("Segoe UI",Font.PLAIN,21));
       accountNumberTextField.setBounds(350,295,220,28);
       panel1.add(accountNumberTextField);

       passwordLabel = new JLabel("PIN: ");
       passwordLabel.setFont(new Font("Segoe UI",Font.PLAIN,16));
      // passwordLabel.setOpaque(true);
       passwordLabel.setBackground(new Color(218,227,243));
       passwordLabel.setBounds(350,330,160,30);
       panel1.add(passwordLabel);

       passwordField = new JPasswordField();
       passwordField.setFont(new Font("Segoe UI",Font.PLAIN,17));
       passwordField.setEchoChar('*');
       passwordField.setBounds(350,365,220,28);
       panel1.add(passwordField);


       showPasswordCheckbox = new JCheckBox("Show Pin");
	   showPasswordCheckbox.setFont(new Font("Segoe UI",Font.PLAIN,16));
	   showPasswordCheckbox.setForeground(Color.black);
	   showPasswordCheckbox.setBackground(new Color(255,255,255));
	   showPasswordCheckbox.setBounds(350,405,100,38);
       showPasswordCheckbox.setOpaque(false);
	   showPasswordCheckbox.addActionListener(this); 
	   showPasswordCheckbox.setFocusable(false);
	   showPasswordCheckbox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   panel1.add(showPasswordCheckbox);
	      
	   paymentBackgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/images/payment_background.png")));
	   paymentBackgroundLabel.setBounds(0,0,1000,700);
	   panel1.add(paymentBackgroundLabel);
       
        this.add(panel1);
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
 
        if(ae.getSource()==backBtn)
		{
			Home h = new Home();
			this.setVisible(false);
		    h.setVisible(true);
		}


		else if(ae.getSource()==confirmBtn)
		{
            if(!(bkashRadioButton.isSelected() || nogodRadioButton.isSelected()))
            {

                JOptionPane.showMessageDialog(this," Please select a payment method");

            }

            else if(accountNumberTextField.getText().length() <=0 || passwordField.getText().length() <=0){
                JOptionPane.showMessageDialog(this,"Fill all information");
            }

            else{

                JOptionPane.showMessageDialog(this," PAYMENT COMPLETE !!");

                JOptionPane.showMessageDialog(this,"Collect your Food from the counter showing you phone number");

            Home s = new Home();
			this.setVisible(false);
		    s.setVisible(true);

            }
	
		}

		else if(showPasswordCheckbox.isSelected()){
			passwordField.setEchoChar((char)0);
		  }
		else{
			passwordField.setEchoChar('*');

		}

       
    }
    
    public static void main(String [] args)
	{
		Payment l = new Payment();
        l.setVisible(true);

		
	}

}