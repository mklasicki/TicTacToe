package com.marcin.utils;

import javax.swing.*;

public interface ButtonsFactory {

    JButton[] generateButtons();

//    void addButtonsPanel(JFrame frame);
//
    void activateButtons(JButton[] buttons);
}
