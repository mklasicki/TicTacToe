package com.marcin.ui.dialogs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.PlayersNamesListener;
import net.miginfocom.swing.MigLayout;

public class PlayersDialog extends JDialog implements ActionListener {


    JButton submitPlayers;
    JButton resetData;
    JButton quit;
    JTextField p1TextField;
    JTextField p2TextField;

    private PlayersNamesListener namesListener;

    public PlayersDialog(JFrame owner, String title) {
        super(owner, title);
        init();
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

    private void  init() {
        setModal(true);
        setSize(new Dimension(300, 150));
        setLayout(new BorderLayout());
        setLocationRelativeTo(getOwner());

        add(playersForm(), BorderLayout.CENTER);
        add(buttonsPanel(), BorderLayout.SOUTH);
    }

    private JPanel playersForm() {
        JPanel nameFormPanel = new JPanel();
        nameFormPanel.setLayout(new MigLayout("wrap 2", "[][grow, fill]"));

        JLabel p1Name = new JLabel("Imię pierwszego gracza: ");
        JLabel p2Name = new JLabel("Imie drugiego gracza: ");
        JTextField p1TextField = new JTextField();
        JTextField p2TextField = new JTextField();

        nameFormPanel.add(p1Name);
        nameFormPanel.add(p1TextField);
        nameFormPanel.add(p2Name);
        nameFormPanel.add(p2TextField);

        return nameFormPanel;
    }

    private JPanel buttonsPanel() {
        JPanel buttonsPanel = new JPanel();
        JButton submit = new JButton("Zatwierdź");
        JButton reset = new JButton("Resetuj");
        JButton quit = new JButton("Wyjdź");

        buttonsPanel.setLayout(new MigLayout("","[grow, fill] [grow, fill] [grow, fill]"));
        buttonsPanel.add(submit);
        buttonsPanel.add(reset);
        buttonsPanel.add(quit);

        return buttonsPanel;
    }


    public void setPlayersNamesListener(PlayersNamesListener stringListener){
        this.namesListener = stringListener;
    }

    public void displayDialog() {
        this.setVisible(true);
    }

    public void closeDialog() {
        this.setVisible(false);
    }

}
