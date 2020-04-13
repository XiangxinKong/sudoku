package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User interface of the game
 *
 * @author Xiangxin Kong
 * @version 1.0
 */
public class gameBoard extends JPanel implements ActionListener {
    JFrame window;
    final static int size = 9;
    sudoku su;
    JTextField[][] input = new JTextField[size][size];

    gameBoard(sudoku su,String title) {
        this.su = su;
        window = new JFrame();
        window.add(this);
        window.setBounds(1000, 500, size * 60 + 160, size * 60 + 200);
        window.setBackground(new Color(240, 240, 240));
        window.setVisible(true);
        window.setTitle(title);
        setLayout(null);
        placeInputField();
        repaint();
        window.setResizable(false);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setFont(new Font("serif", Font.BOLD, 30));
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                g2.drawRect(x * 60 + 60, y * 60 + 60, 60, 60);
                if (x % 3 == 0 && y % 3 == 0) {
                    g2.setStroke(new BasicStroke(4));
                    g2.drawRect(x * 60 + 60, y * 60 + 60, 180, 180);
                }
                g2.setStroke(new BasicStroke(2));
                if (su.state[x][y] != 0) {
                    g.drawString(String.valueOf(su.state[x][y]), x * 60 + 85, y * 60 + 100);
                }
            }
        }
    }

    private void placeInputField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (su.state[i][j] == 0) {
                    input[i][j] = new JTextField(1);
                    input[i][j].setFont(new Font("serif", Font.BOLD, 30));
                    input[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    input[i][j].setBounds(i * 60 + 72, j * 60 + 72, 40, 40);
                    input[i][j].setVisible(true);
                    this.add(input[i][j]);
                } else {
                    input[i][j] = null;
                }
            }
        }
        JButton checkButton = new JButton("CHECK");
        checkButton.setFont(new Font("serif", Font.PLAIN, 30));
        checkButton.setHorizontalAlignment(SwingConstants.CENTER);
        checkButton.setBounds(440, 640, 150, 40);
        checkButton.setVisible(true);
        checkButton.addActionListener(this);
        this.add(checkButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (input[i][j] != null) {
                    try {
                        int temp = Integer.parseInt(input[i][j].getText());
                        if (temp < 1 || temp > 9) {
                            throw new Exception();
                        }
                        su.state[i][j] = temp;
                    } catch (Exception e1) {
                        input[i][j].setText("");
                        su.state[i][j] = 0;
                    }
                }
            }
        }
        if (su.isCompleted()) {
            JOptionPane.showMessageDialog(this, "Congradulation!");
            window.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "It is incorrect.");
        }
    }
}
