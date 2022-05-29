package com.marcin.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class ButtonsFactory implements Buttons {

    private JButton[] buttons;

    public ButtonsFactory() {
        generateButtons();
    }

    public JButton[] getButtons() {
        return buttons;
    }

    @Override
    public void generateButtons() {
        buttons = new JButton[9];

        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
        }

    }

    @Override
    public void addButtons(JFrame frame) {
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

    @Override
    public void activateButtons() {
        for(JButton button : buttons) {
            button.setEnabled(true);
        }
    }

    @Override
    public void disableButtons() {
        for(JButton button : buttons) {
            button.setEnabled(false);
        }
    }

}
