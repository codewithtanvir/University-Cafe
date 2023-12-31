import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Breakfast extends JFrame implements ActionListener {

	JLabel l1, l10, l11, l12, l13, l14;

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, backButton, backButto, con;

	JPanel P1, P2;
	JComboBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

	public Breakfast() {
		super("Breakfast");
		this.setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		P1 = new JPanel();
		P1.setBounds(0, 0, 1000, 700);
		P1.setBackground(new Color(216, 228, 250));
		P1.setLayout(null);

		P2 = new JPanel();
		P2.setBounds(0, 0, 1000, 700);
		P2.setBackground(new Color(216, 228, 250));
		P2.setLayout(null);

		b1 = new JButton("Noodles:120tk");
		b1.setBounds(370, 185, 150, 50);
		b1.setBorder(null);
		b1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b1.setOpaque(false);
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(0, 0, 155, 10));
		b1.addActionListener(this);
		b1.setFocusable(false);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b1);

		String s1[] = { "01", "02", "03", "04" };
		c1 = new JComboBox(s1);
		c1.addActionListener(this);
		c1.setBounds(525, 200, 40, 20);
		P1.add(c1);

		b2 = new JButton("Dim Vaji:25tk");
		b2.setBounds(560, 185, 150, 50);
		b2.setBorder(null);
		b2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b2.setOpaque(false);
		b2.setForeground(new Color(0, 0, 0));// yallow rgb(146,208,80)
		b2.setBackground(new Color(146, 208, 80));//
		b2.addActionListener(this);
		b2.setFocusable(false);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b2);

		String s2[] = { "01", "02", "03", "04" };
		c2 = new JComboBox(s2);
		c2.addActionListener(this);
		c2.setBounds(705, 200, 40, 20);
		P1.add(c2);

		b3 = new JButton("Pasta:140tk");
		b3.setBounds(400, 410, 135, 50);
		b3.setBorder(null);
		b3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b3.setOpaque(false);
		b3.setForeground(new Color(0, 0, 0));
		b3.setBackground(new Color(0, 0, 155, 10));
		b3.addActionListener(this);
		b3.setFocusable(false);
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b3);

		String s3[] = { "01", "02", "03", "04" };
		c3 = new JComboBox(s3);
		c3.addActionListener(this);
		c3.setBounds(540, 425, 40, 20);
		P1.add(c3);

		b4 = new JButton("Dim Poch:20tk");
		b4.setBounds(600, 410, 150, 50);
		b4.setBorder(null);
		b4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b4.setOpaque(false);
		b4.setForeground(new Color(0, 0, 0));
		b4.setBackground(new Color(0, 0, 155, 10));
		b4.addActionListener(this);
		b4.setFocusable(false);
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b4);

		String s4[] = { "01", "02", "03", "04" };
		c4 = new JComboBox(s4);
		c4.addActionListener(this);
		c4.setBounds(760, 425, 40, 20);
		P1.add(c4);

		b5 = new JButton("Sandwich:70tk");
		b5.setBounds(795, 408, 150, 50);
		b5.setBorder(null);
		b5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b5.setOpaque(false);
		b5.setForeground(new Color(0, 0, 0));
		b5.setBackground(new Color(0, 0, 155, 10));
		b5.addActionListener(this);
		b5.setFocusable(false);
		b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b5);

		String s5[] = { "01", "02", "03", "04" };
		c5 = new JComboBox(s5);
		c5.addActionListener(this);
		c5.setBounds(952, 420, 20, 20);
		P1.add(c5);

		b6 = new JButton("Porota:15tk");
		b6.setBounds(775, 185, 130, 50);
		b6.setBorder(null);
		b6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b6.setOpaque(false);
		b6.setForeground(new Color(0, 0, 0));
		b6.setBackground(new Color(0, 0, 155, 10));
		b6.addActionListener(this);
		b6.setFocusable(false);
		b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b6);

		String s6[] = { "01", "02", "03", "04" };
		c6 = new JComboBox(s6);
		c6.addActionListener(this);
		c6.setBounds(899, 202, 40, 20);
		P1.add(c6);

		b7 = new JButton("Singara/Somocha:10tk");
		b7.setBounds(290, 600, 250, 50);
		b7.setBorder(null);
		b7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b7.setOpaque(false);
		b7.setForeground(new Color(0, 0, 0));
		b7.setBackground(new Color(0, 0, 155, 10));
		b7.addActionListener(this);
		b7.setFocusable(false);
		b7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b7);

		String s7[] = { "01", "02", "03", "04" };
		c7 = new JComboBox(s7);
		c7.addActionListener(this);
		c7.setBounds(540, 615, 40, 20);
		P1.add(c7);

		b8 = new JButton("Donuts:80tk");
		b8.setBounds(565, 600, 150, 50);
		b8.setBorder(null);
		b8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b8.setOpaque(false);
		b8.setForeground(new Color(0, 0, 0));
		b8.setBackground(new Color(0, 0, 155, 10));
		b8.addActionListener(this);
		b8.setFocusable(false);
		b8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b8);

		String s8[] = { "01", "02", "03", "04" };
		c8 = new JComboBox(s8);
		c8.addActionListener(this);
		c8.setBounds(715, 615, 40, 20);
		P1.add(c8);

		b9 = new JButton("Daal:25tk");
		b9.setBounds(795, 600, 150, 50);
		b9.setBorder(null);
		b9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		b9.setOpaque(false);
		b9.setForeground(new Color(0, 0, 0));
		b9.setBackground(new Color(0, 0, 155, 10));
		b9.addActionListener(this);
		b9.setFocusable(false);
		b9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P1.add(b9);

		String s9[] = { "01", "02", "03", "04" };
		c9 = new JComboBox(s9);
		c9.addActionListener(this);
		c9.setBounds(952, 615, 40, 20);
		P1.add(c9);

		l10 = new JLabel("Total cost     :");
		l10.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		l10.setForeground(Color.white);
		l10.setBounds(600, 300, 190, 28);
		P2.add(l10);

		l11 = new JLabel();
		l11.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		l11.setOpaque(true);
		l11.setBackground(Color.white);
		l11.setForeground(Color.black);
		l11.setBounds(800, 300, 110, 38);
		P2.add(l11);

		l12 = new JLabel();
		l12.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		l12.setForeground(Color.white);
		l12.setBounds(600, 200, 350, 30);//
		P2.add(l12);

		l13 = new JLabel();
		l13.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		l13.setForeground(Color.white);
		l13.setBounds(600, 250, 350, 30);
		P2.add(l13);

		con = new JButton("Confirm");
		con.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		con.setForeground(Color.white);
		con.setBackground(Color.DARK_GRAY);// green rgb(146,208,80)
		//grey color rgb(146,208,80)
		con.setBounds(650, 400, 200, 40);
		con.addActionListener(this);
		con.setFocusable(false);
		con.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		P2.add(con);

		ImageIcon bac = new ImageIcon("images/Back.png");
		backButto = new JButton(bac);
		backButto.setBounds(30, 605, bac.getIconWidth(), bac.getIconHeight());
		backButto.setBackground(Color.black);
		backButto.setOpaque(false);
		backButto.setBorder(BorderFactory.createEmptyBorder());
		P2.add(backButto);

		l14 = new JLabel(new ImageIcon(getClass().getResource("/images/order.png")));
		l14.setBounds(0, 0, 1000, 700);
		P2.add(l14);

		ImageIcon back = new ImageIcon("images/Back.png");
		backButton = new JButton(back);
		backButton.setBounds(20, 10, back.getIconWidth(), back.getIconHeight());
		backButton.setBackground(Color.black);
		backButton.setOpaque(false);
		backButton.setBorder(BorderFactory.createEmptyBorder());
		P1.add(backButton);

		l1 = new JLabel(new ImageIcon(getClass().getResource("/images/BreakFast (1).png")));
		l1.setBounds(0, 0, 1000, 679);
		l1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		P1.add(l1);

		setVisible(true);
		this.add(P1);
		backButton.addActionListener(this);
		backButto.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == backButton) {
			Home h = new Home();
			this.setVisible(false);
			h.setVisible(true);
		}

		else if (ae.getSource() == con) {
			Payment pa = new Payment();
			this.setVisible(false);
			pa.setVisible(true);
		}

		else if (ae.getSource() == backButto) {
			P2.setVisible(false);
			P1.setVisible(true);

		}

		else if (ae.getSource() == b1) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 120;
			int b = c1.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Noodles");

			l13.setText("Quantity          : " + c1.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
			//

		}

		else if (ae.getSource() == b2) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 25;
			int b = c2.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Dim Vaji");

			l13.setText("Quantity           : " + c2.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
			//
		}

		else if (ae.getSource() == b3) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 140;
			int b = c3.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Pasta");

			l13.setText("Quantity           : " + c3.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
			//
		}

		else if (ae.getSource() == b4) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 20;
			int b = c4.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item  : Dim Poch");

			l13.setText("Quantity            : " + c4.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
			
		}

		else if (ae.getSource() == b5) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 70;
			int b = c5.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Sandwich");

			l13.setText("Quantity           : " + c5.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
			//
		}

		else if (ae.getSource() == b6) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 15;
			int b = c6.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Porota");

			l13.setText("Quantity           : " + c6.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
		}

		else if (ae.getSource() == b7) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 10;
			int b = c7.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Singara/Somocha");

			l13.setText("Quantity           : " + c7.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
		}

		else if (ae.getSource() == b8) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 80;
			int b = c8.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Donuts");

			l13.setText("Quantity           : " + c8.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
		}

		else if (ae.getSource() == b9) {

			this.add(P2);
			P1.setVisible(false);
			P2.setVisible(true);

			int a = 25;
			int b = c9.getSelectedIndex();
			int sum = a * (b + 1);

			l12.setText("Selected Item : Daal");

			l13.setText("Quantity           : " + c9.getSelectedItem());

			l11.setText(String.valueOf(sum) + " Tk");
		}

	}

	public static void main(String[] args) {
		Breakfast m = new Breakfast();

	}
}