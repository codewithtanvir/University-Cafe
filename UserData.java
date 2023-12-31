import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserData extends JFrame {

    private Container container;
    private ImageIcon icon;
    private JLabel titleLabel;
    private Font titleFont, buttonFont, tableFont;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton refreshButton, deleteButton, addButton, exitButton, backButton, newButton,printButton;
    private Cursor cursor;

    private String[] column = { "Name", "Password", "Mobile", "Email", "Gender","Occupation" };
    private String[] rows = new String[7];

    UserData() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.decode("#F2F2F2"));

        
        titleFont = new Font("Segoe UI Black", Font.BOLD, 40);
        buttonFont = new Font("Segoe UI Black", Font.PLAIN, 20);
        tableFont = new Font("Segoe UI", Font.PLAIN, 15);

        
        cursor = new Cursor(Cursor.HAND_CURSOR);

      
        titleLabel = new JLabel();
        titleLabel.setText("User Data");
        titleLabel.setBounds(400, 30, 400, 80);
        titleLabel.setFont(titleFont);
        container.add(titleLabel);

      
        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(154, 468, 184, 50);
        refreshButton.setFont(buttonFont);
        refreshButton.setCursor(cursor);
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setBackground(Color.decode("#2E75B6"));
        container.add(refreshButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(348, 468, 184, 50);
        deleteButton.setFont(buttonFont);
        deleteButton.setCursor(cursor);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.decode("#2E75B6"));
        container.add(deleteButton);

        addButton = new JButton("Add");
        addButton.setBounds(542, 468, 184, 50);
        addButton.setFont(buttonFont);
        addButton.setCursor(cursor);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.decode("#2E75B6"));
        container.add(addButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(154, 530, 278, 50);
        exitButton.setFont(buttonFont);
        exitButton.setCursor(cursor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.decode("#C00000"));
        container.add(exitButton);

        backButton = new JButton("Back");
        backButton.setBounds(442, 530, 284, 50);
        backButton.setFont(buttonFont);
        backButton.setCursor(cursor);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.decode("#2E75B6"));
        container.add(backButton);

        printButton = new JButton("Print");
        printButton.setBounds(154, 590, 278, 50);
        printButton.setFont(buttonFont);
        printButton.setCursor(cursor);
        printButton.setForeground(Color.WHITE);
        printButton.setBackground(Color.decode("#2E75B6"));
        container.add(printButton);



      
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(tableFont);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(40);
        table.setBounds(50, 50, 900, 600);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		

		

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 146, 578, 300);
        scrollPane.setBackground(Color.WHITE);
        container.add(scrollPane);

        String file = "data\\data.txt";
        String temp = "data\\temp.txt";

     
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("Name")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(19); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(17); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(17); 
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(17); 
					rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(17);
					rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(17);
					rows[6] = Files.readAllLines(Paths.get(file)).get((i + 6)).substring(17);

					
  
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }


        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);

            }
        });

   
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file)).get(i);
                            String x = line.substring(0, 4);
                            if (x.equals("Name")) {
                                String userName = Files.readAllLines(Paths.get(file)).get(i);
                                if (userName.substring(19).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file)).get(j);
                            String x = line.substring(0, 4);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5) || j == (q + 6) )) {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    setVisible(false);
                    UserData frame = new UserData();
                    frame.setVisible(true);
                }

            }
        });

 
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

     
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

     
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin frame = new Admin();
                frame.setVisible(true);
            }
        });
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    table.print();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
    }

    public static void main(String[] args) {

        UserData frame = new UserData();
        frame.setVisible(true);
    }
}