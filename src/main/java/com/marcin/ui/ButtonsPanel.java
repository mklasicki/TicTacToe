package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonsPanel  extends JPanel implements ActionListener {

    JPanel buttons = new JPanel();
    JButton[] buttonsTab;
    JFrame parent;


    public ButtonsPanel(JFrame parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        generateButtons();
        disableButtons();
        add(buttons, BorderLayout.CENTER);

    }

    private void generateButtons() {
        buttons.setLayout(new GridLayout(3,3));
        buttonsTab = new JButton[9];

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.addActionListener(this);
            button.setFont(new Font("Arial,", Font.PLAIN, 35));
            buttons.add(button);
            buttonsTab[i] = button;
        }
    }

    public void disableButtons() {
        for(JButton b : buttonsTab) {
            b.setEnabled(false);
        }
    }

    public void enableButtons() {
        for(JButton b : buttonsTab) {
            b.setEnabled(true);
        }
    }

    public JButton[] getButtonsTab() {
        return buttonsTab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setText("X");
        button.setEnabled(false);
    }
}
