package com.marcin.ui.buttons;

import javax.swing.*;

public interface Buttons {

    void generateButtons();

    void addButtons(JFrame frame);

    void addButton(JPanel panel, JButton button);

    void activateButtons();

    void disableButtons();

}
