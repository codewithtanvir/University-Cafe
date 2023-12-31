import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contribution extends JFrame implements ActionListener {
	JPanel P1;
	JLabel l1;
	JButton backButton;

	public Contribution() {

		this.setSize(1000, 709);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		P1 = new JPanel();
		P1.setBounds(0, 0, 1000, 700);
		P1.setLayout(null);

		ImageIcon back = new ImageIcon("images/Back.png");
		backButton = new JButton(back);
		backButton.setBounds(20, 20, back.getIconWidth(), back.getIconHeight());
		backButton.setBackground(Color.black);
		backButton.setOpaque(false);
		backButton.setBorder(BorderFactory.createEmptyBorder());
		P1.add(backButton);

		l1 = new JLabel(new ImageIcon(getClass().getResource("/images/contribution.png")));
		l1.setBounds(0, 0, 1000, 674);
		P1.add(l1);
		this.add(P1);
		setVisible(true);
		backButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == backButton) {
			Homepage h = new Homepage();
			this.setVisible(false);
			h.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Contribution m = new Contribution();
		m.setVisible(true);
	}
}