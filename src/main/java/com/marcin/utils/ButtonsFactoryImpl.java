package com.marcin.utils;

import javax.swing.*;

public class ButtonsFactoryImpl implements ButtonsFactory {

    @Override
    public JButton[] generateButtons() {
     JButton[] buttons = new JButton[9];

        for(int i = 0; i< buttons.length; i++) {
            buttons[i] = new JButton();
        }

        return buttons;
    }

//    @Override
//    public void addButtonsPanel(JFrame frame) {
//
//    }

    @Override
    public void activateButtons(JButton[] buttons) {

        for(JButton button : buttons) {
            button.setEnabled(true);
        }

    }
}
