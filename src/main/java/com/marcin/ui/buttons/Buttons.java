package com.marcin.ui.buttons;

import javax.swing.*;

public interface Buttons {

    JButton[] generateButtons(int buttonsNumber);

    void addButtons(JFrame frame, JButton[] buttons);

    void addButton(JPanel panel, JButton button);

}
