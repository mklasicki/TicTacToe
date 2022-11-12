package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.ButtonPressedListener;

public class ButtonsPanel  extends JPanel implements ActionListener {

    JPanel buttons = new JPanel();
    JButton[] buttonsTab;
    JFrame parent;
    private ButtonPressedListener buttonPressedListener;
    private String playerMark;


    public String getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(String playerMark) {
        this.playerMark = playerMark;
    }

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

    public void setButtonPressedListener(ButtonPressedListener buttonPressedListener) {
        this.buttonPressedListener = buttonPressedListener;
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

//    public JButton getButtonByIndex(int index) {
//        return this.buttonsTab[index];
//    }
//
//
//    public JButton[] getButtonsTab() {
//        return buttonsTab;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonPressedListener != null) {
            JButton button = (JButton) e.getSource();
            buttonPressedListener.buttonPressed();
            button.setText(getPlayerMark());
            button.setEnabled(false);
        }

    }

}
