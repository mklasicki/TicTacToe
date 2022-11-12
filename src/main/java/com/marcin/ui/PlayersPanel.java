package com.marcin.ui;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PlayersPanel extends JPanel {
    private JLabel player1;
    private JLabel player2;
    private JLabel p1NameText;
    private JLabel p2NameText;


    public PlayersPanel(JFrame parent) {
        init();
    }

    private void init() {
        player1 = new JLabel("Gracz 1:");
        player2 = new JLabel("Gracz 2:");
        p1NameText = new JLabel();
        p2NameText = new JLabel();

        setLayout(new MigLayout());
        setBorder(BorderFactory.createTitledBorder("Gracze:"));

        add(player1);
        add(p1NameText, "wrap");
        add(player2);
        add(p2NameText);
    }

    public void  fillNameTextFields(String p1Name, String p2Name) {
        p1NameText.setText(p1Name);
        p2NameText.setText(p2Name);
    }

}
