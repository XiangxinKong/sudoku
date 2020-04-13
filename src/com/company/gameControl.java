package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Entrance interface for user, select the difficulties
 *
 * @author Xiangxin Kong
 * @version 1.0
 */
public class gameControl extends JPanel implements ActionListener {
    ArrayList<JButton> level;
    String[] words;
    gameControl() {
        JFrame window = new JFrame();
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(1000, 500, 400, 500);
        window.setBackground(new Color(200, 200, 200));
        window.setVisible(true);
        window.setTitle("Sudoku");
        setLayout(null);
        setUpButtons();
    }

    /*
     *place 5 buttons on the panel
     */
    void setUpButtons() {
        level = new ArrayList<>();
        words = new String[]{"Beginner", "Easy", "Normal", "Hard", "Challege"};
        for (int i = 0; i < 5; i++) {
            JButton temp = new JButton(words[i]);
            temp.setFont(new Font("serif", Font.BOLD, 18));
            temp.addActionListener(this);
            temp.setBounds(100, 80 + 60 * i, 180, 45);
            add(temp);
            level.add(temp);
        }

    }

    /*
     *this method is invoked by clicking button
     *invoke the gameboard with disired difficulties
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int buttonIndex=level.indexOf(e.getSource());
        int numOfEmpties = 13 + 12 * buttonIndex;
        new gameBoard(sudokuGenerator.gnerate(numOfEmpties),words[buttonIndex]);
    }
}
