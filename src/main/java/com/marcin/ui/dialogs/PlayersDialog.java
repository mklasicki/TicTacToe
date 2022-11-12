package com.marcin.ui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.StringListener;

public class PlayersDialog extends JDialog implements ActionListener {

    JLabel p1Name;
    JLabel p2Name;
    JButton submitPlayers;
    JButton resetData;
    JButton quit;
    JTextField p1TextField;
    JTextField p2TextField;
    String[] playerNames;

    private StringListener namesListener;

    public void initPlayerNamesDialog(JFrame parent) {

        playerNames = new String[2];
        p1Name = new JLabel("Imię pierwszego gracza: ");
        p2Name = new JLabel("Imie drugiego gracza: ");
        submitPlayers = new JButton("Zatwierdź");
        resetData = new JButton("Resetuj");
        quit = new JButton("Wyjdź");
        p1TextField = new JTextField();
        p2TextField = new JTextField();

        p1Name.setBounds(10, 10, 200, 20);
        p2Name.setBounds(10, 40, 200, 20);

        p1TextField.setBounds(250, 10, 100, 20);
        p2TextField.setBounds(250, 40, 100, 20);

        submitPlayers.setBounds(10, 80, 100, 30);
        resetData.setBounds(130, 80, 100, 30);
        quit.setBounds(250, 80,100, 30);

        submitPlayers.addActionListener(this);
        resetData.addActionListener(this);
        quit.addActionListener(this);

        this.setModal(true);
        this.setLayout(null);
        this.setTitle("Imiona graczy");
        this.setBounds(400, 400, 380, 160);
        this.add(p1Name);
        this.add(p2Name);
        this.add(p1TextField);
        this.add(p2TextField);
        this.add(submitPlayers);
        this.add(resetData);
        this.add(quit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitPlayers) {
            if (namesListener != null){
                namesListener.getNames(p1TextField.getText(), p2TextField.getText());
            }
               this.closeDialog();
        } else if (e.getSource() == resetData) {
            p1TextField.setText("");
            p2TextField.setText("");
        } else if (e.getSource() == quit) {
            this.closeDialog();
        }
    }


     public void setStringListener(StringListener stringListener){
        this.namesListener = stringListener;
     }

    public void displayDialog() {
        this.setVisible(true);
    }

    public void closeDialog() {
        this.setVisible(false);
    }

}
