import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f1 = new JFrame();
        f1.setSize(370, 330);
        f1.setTitle("Calculator lel");
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1.getContentPane().setBackground(new Color(45, 45, 45));


        JTextField t1 = new JTextField();
        t1.setBounds(100, 90, 100, 40);
        t1.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        t1.setBackground(new Color(80, 80, 80)); 
        t1.setForeground(Color.WHITE);
        t1.setCaretColor(Color.WHITE);
        f1.add(t1);

        JTextField t2 = new JTextField();
        t2.setBounds(100, 140, 100, 40);
        t2.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        t2.setBackground(new Color(80, 80, 80)); 
        t2.setForeground(Color.WHITE);
        t2.setCaretColor(Color.white);
        f1.add(t2);


        JButton b1 = new JButton("Add");
        b1.setBounds(250, 90, 100, 20);
        b1.setBackground(new Color(0, 153, 76)); 
        b1.setForeground(Color.WHITE);
        b1.setMnemonic('A');
        b1.setToolTipText("(Alt + A)");
         f1.add(b1);



        JButton b2 = new JButton("Subtract");
        b2.setBounds(250, 115, 100, 20);
        b2.setBackground(new Color(0, 153, 76)); 
        b2.setForeground(Color.WHITE);
        b2.setMnemonic('S');
        b2.setToolTipText("(Alt + S)");
        f1.add(b2);




        JButton b3 = new JButton("Multiply");
        b3.setBounds(250, 140, 100, 20);
        b3.setBackground(new Color(0, 153, 76)); 
        b3.setForeground(Color.WHITE);
        b3.setMnemonic('M');
        b3.setToolTipText("(Alt + M)");
        f1.add(b3);


        
        JButton b4 = new JButton("Division");
        b4.setBounds(250, 165, 100, 20);
        b4.setBackground(new Color(0, 153, 76)); 
        b4.setForeground(Color.WHITE);
        b4.setMnemonic('D');
        b4.setToolTipText("(Alt + D");
        f1.add(b4);

        JButton b5 = new JButton("Factorial");
        b5.setBounds(250, 190, 100, 20);
        b5.setBackground(new Color(0, 153, 76)); 
        b5.setForeground(Color.WHITE);
        b5.setMnemonic('F');
        b5.setToolTipText("(Alt + F)");
        f1.add(b5);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(10, 190, 150, 50);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));
        resultLabel.setForeground(Color.ORANGE);
        f1.add(resultLabel);

        JLabel l2 = new JLabel("Calculator");
        l2.setBounds(125, 30, 100, 30);
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        l2.setForeground(Color.white);
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t1.setText("");
                t2.setText("");
                resultLabel.setText("Result:");
            }
        
            @Override
            public void mouseEntered(MouseEvent e) {
                l2.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
                l2.setForeground(new Color(255, 153, 0)); 
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                l2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                l2.setForeground(Color.WHITE); 
            }
        });
        
        f1.add(l2);

        
        b1.addActionListener((ActionEvent e) -> {
            try {
                double result = Double.parseDouble(t1.getText()) + Double.parseDouble(t2.getText());
                resultLabel.setText("Result: " + (result == Math.floor(result) ? String.format("%.0f", result) : result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input!!!!!!");
            }
        });

        b2.addActionListener((ActionEvent e) -> {
            try {
                double result = Double.parseDouble(t1.getText()) - Double.parseDouble(t2.getText());
                resultLabel.setText("Result: " + (result == Math.floor(result) ? String.format("%.0f", result) : result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input!!!!!!");
            }
        });

        b3.addActionListener((ActionEvent e) -> {
            try {
                double result = Double.parseDouble(t1.getText()) * Double.parseDouble(t2.getText());
                resultLabel.setText("Result: " + (result == Math.floor(result) ? String.format("%.0f", result) : result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input!!!!!!");
            }
        });

        b4.addActionListener((ActionEvent e) -> {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                
                if (num2 == 0) {
                    resultLabel.setText("Result: Infinite");
                } else {
                    double division = num1 / num2;
                    resultLabel.setText("Result: " + (division == Math.floor(division) ? String.format("%.0f", division) : division));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input!!!!!!");
            }
        });

        b5.addActionListener((ActionEvent e) -> {
            try {
                int num = Integer.parseInt(t1.getText().trim());
                if (num < 0 || num > 20) {
                    resultLabel.setText("Result:Invalid Input");
                } else {
                    long fact = 1;
                    for (int i = 1; i <= num; i++) {
                        fact *= i;
                    }
                    resultLabel.setText("Factorial: " + fact);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid Input!!!!!!");
            }
        });

        // To change the color of buttons when hovering
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                b1.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b1.setBackground(new Color(0, 153, 76));
            }
        });

        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                b2.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b2.setBackground(new Color(0, 153, 76));
            }
        });

        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                b3.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b3.setBackground(new Color(0, 153, 76));
            }
        });

        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                b4.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b4.setBackground(new Color(0, 153, 76));
            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                b5.setBackground(new Color(0, 204, 102));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                b5.setBackground(new Color(0, 153, 76));
            }
        });

        f1.setVisible(true);
    }
}
