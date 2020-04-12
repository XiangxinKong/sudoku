package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gameControl extends JPanel implements ActionListener {
    ArrayList<JButton> level;

    gameControl() {

        JFrame window = new JFrame();
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(1000, 500, 400, 600);
        window.setBackground(new Color(200, 200, 200));
        window.setVisible(true);
        setLayout(null);
        setUpButtons();
    }

    void setUpButtons() {
        level = new ArrayList<>();
        String[] words = {"Beginner", "Easy", "Normal", "Hard", "Challege"};
        for (int i = 0; i < 5; i++) {
            JButton temp = new JButton(words[i]);
            temp.setFont(new Font("serif", Font.BOLD, 18));
            temp.addActionListener(this);
            temp.setBounds(100,80+60*i,180,45);
            add(temp);
            level.add(temp);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numOfEmpties = 13 + 12*level.indexOf(e.getSource());
        new gameBoard(sudokuGenerator.gnerate(numOfEmpties));
    }
}
