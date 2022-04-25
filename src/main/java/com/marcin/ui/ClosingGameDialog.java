package com.marcin.ui;

import javax.swing.*;

public class ClosingGameDialog  extends JDialog {

    JLabel label;
    JButton newGame;
    JButton quit;

    public void initEndGameDialog() {

        this.setLayout(null);
        this.setTitle("Koniec gry");
        this.setBounds(400, 400, 380, 160);
        label = new JLabel();
        newGame = new JButton("Nowa gra");
        quit = new JButton("Wyjdź");

        label.setBounds(50, 10, 300, 20);
        newGame.setBounds(50, 50, 100, 30);
        quit.setBounds(180, 50, 100, 30);

        this.add(label);
        this.add(newGame);
        this.add(quit);

    }

    public void displayDialog() {
        this.setVisible(true);
    }

    public void closeDialog() {
        this.setVisible(false);
    }

}
