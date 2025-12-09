import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class app {
    public static void main(String[] args) {
        JFrame f1 = new JFrame();
        f1.setSize(370, 330);
        f1.setTitle("Zodiac Sign Finder");
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.getContentPane().setBackground(new Color(45, 45, 45));
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(30, 30, 150, 25);
        f1.add(nameLabel);

        JTextField name1 = new JTextField();
        name1.setBounds(180, 25, 150, 25);
        name1.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        name1.setBackground(new Color(80, 80, 80));
        name1.setForeground(Color.WHITE);
        name1.setCaretColor(Color.WHITE);
        f1.add(name1);

        JLabel dobday = new JLabel("Enter your Date (Day):");
        dobday.setForeground(Color.WHITE);
        dobday.setBounds(30, 60, 180, 25);
        f1.add(dobday);

        JLabel dobmonth = new JLabel("Enter your Date (Month):");
        dobmonth.setForeground(Color.WHITE);
        dobmonth.setBounds(30, 90, 180, 25);
        f1.add(dobmonth);

        JTextField dobdayField = new JTextField();
        dobdayField.setBounds(280, 55, 50, 25);
        dobdayField.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        dobdayField.setBackground(new Color(80, 80, 80));
        dobdayField.setForeground(Color.WHITE);
        dobdayField.setCaretColor(Color.WHITE);
        f1.add(dobdayField);

        JTextField dobmonthField = new JTextField();
        dobmonthField.setBounds(280, 85, 50, 25);
        dobmonthField.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        dobmonthField.setBackground(new Color(80, 80, 80));
        dobmonthField.setForeground(Color.WHITE);
        dobmonthField.setCaretColor(Color.WHITE);
        f1.add(dobmonthField);

        JButton submitBtn = new JButton("Find Zodiac");
        submitBtn.setBounds(120, 160, 120, 30);
        submitBtn.setMnemonic('F');
        submitBtn.setToolTipText("Alt + F");
        f1.add(submitBtn);

        submitBtn.addActionListener((ActionEvent e) -> {
            try {
                int day = Integer.parseInt(dobdayField.getText());
                int month = Integer.parseInt(dobmonthField.getText());

                if (day < 1 || day > 31) {
                    JOptionPane.showMessageDialog(f1, "Please enter a valid day (1-31).");
                    return;
                }

                if (month < 1 || month > 12) {
                    JOptionPane.showMessageDialog(f1, "Please enter a valid month (1-12).");
                    return;
                }

                String zodiacSign = getZodiacSign(day, month);
                JOptionPane.showMessageDialog(f1, "Your Zodiac Sign is: " + zodiacSign);

                try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/birthday", "root", "");
    System.out.println("Connected.");
    Statement st = con.createStatement();
    PreparedStatement pst =con.prepareStatement("INSERT INTO records (Name,Day, Month) VALUES(?, ?, ?)"); 
    pst.setString(1, name1.getText());
    pst.setString(2, dobdayField.getText());
    pst.setString(3, dobmonthField.getText());
    pst.executeUpdate();
    System.out.println("Data inserted successfully.");
    con.close();
                }
                catch(ClassNotFoundException | SQLException ex){
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(f1, "Invalid input. Please enter valid day and month.");
            }
        });

        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(120, 200, 120, 30);
        resetBtn.setMnemonic('K');
        resetBtn.setToolTipText("Alt + K");
        resetBtn.addActionListener((ActionEvent e) -> {
            name1.setText("");
            dobdayField.setText("");
            dobmonthField.setText("");
        });
        f1.add(resetBtn);

        f1.setVisible(true);
    }

    public static String getZodiacSign(int day, int month) {
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return "Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            return "Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            return "Gemini";
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            return "Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            return "Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            return "Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            return "Libra";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            return "Scorpio";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            return "Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            return "Capricorn";
        } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            return "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            return "Pisces";
        }
        return "Invalid Date";
    }

    }


    