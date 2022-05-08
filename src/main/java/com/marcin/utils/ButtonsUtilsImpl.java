package com.marcin.utils;

import javax.swing.*;

public class ButtonsUtilsImpl implements ButtonsUtils {

    @Override
    public JPanel ButtonsPanel(JButton[] buttons) {

            int buttonHeight = 100;
            int buttonWidth = 100;

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(null);
            buttonsPanel.setBounds(0, 100, 300, 300);

            buttons[0].setBounds(0, 0, buttonWidth, buttonHeight);
            buttons[1].setBounds(100, 0, buttonWidth, buttonHeight);
            buttons[2].setBounds(200, 0, buttonWidth, buttonHeight);
            buttons[3].setBounds(0, 100, buttonWidth, buttonHeight);
            buttons[4].setBounds(100, 100, buttonWidth, buttonHeight);
            buttons[5].setBounds(200, 100, buttonWidth, buttonHeight);
            buttons[6].setBounds(0, 200, buttonWidth, buttonHeight);
            buttons[7].setBounds(100, 200, buttonWidth, buttonHeight);
            buttons[8].setBounds(200, 200, buttonWidth, buttonHeight);

            for(JButton button : buttons) {
                button.setEnabled(false);
                buttonsPanel.add(button);
            }

            return buttonsPanel;
    }

    @Override
    public void activateButtons(JButton[] buttons) {
        for(JButton button : buttons) {
            button.setEnabled(true);
        }
    }
}
