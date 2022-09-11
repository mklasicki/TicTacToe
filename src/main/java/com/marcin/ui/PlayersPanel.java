package com.marcin.ui;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PlayersPanel extends JPanel {
    private JLabel player1;
    private JLabel player2;
    private JLabel p1NameText;
    private JLabel p2NameText;


    public PlayersPanel() {
        init();
    }

    private void init() {
        player1 = new JLabel("Gracz 1:");
        player2 = new JLabel("Gracz 2:");
        p1NameText = new JLabel("Imie 1");
        p2NameText = new JLabel("Imie 2");

        setLayout(new MigLayout());
        setBorder(BorderFactory.createTitledBorder("Gracze:"));

        add(player1);
        add(p1NameText, "wrap");
        add(player2);
        add(p2NameText);
    }

}
