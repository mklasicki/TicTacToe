package com.marcin.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class ButtonsFactory implements Buttons {

    @Override
    public JButton[] generateButtons(int buttonsNumber) {
        JButton[] buttons = new JButton[buttonsNumber];

        for(int i = 0; i < buttonsNumber; i++) {
            buttons[i] = new JButton();
        }
        return buttons;
    }

    @Override
    public void addButtons(JFrame frame, JButton[] buttons) {
        JPanel buttonsPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(3,0);
        buttonsPanel.setLayout(gridLayout);
        buttonsPanel.setSize(new Dimension(316, 300));
        for(JButton button: buttons) {
            addButton(buttonsPanel, button);
        }
        //frame.getContentPane().add(buttonsPanel);
        frame.add(buttonsPanel);
    }

    @Override
    public void addButton(JPanel panel, JButton button) {
        panel.add(button);
    }

}
