package com.marcin.utils.buttons;

import javax.swing.*;

import com.marcin.utils.buttons.ButtonsFactory;

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
