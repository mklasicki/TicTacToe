package com.marcin.utils.buttons;

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

}
