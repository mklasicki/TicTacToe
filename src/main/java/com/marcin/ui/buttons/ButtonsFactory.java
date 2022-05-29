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
        GridLayout gridLayout = new GridLayout(3,3);
        buttonsPanel.setLayout(gridLayout);
        for(JButton button: buttons) {
            addButton(buttonsPanel, button);
        }
        frame.add(buttonsPanel, BorderLayout.CENTER);
    }

    @Override
    public void addButton(JPanel panel, JButton button) {
        panel.add(button);
    }

}
