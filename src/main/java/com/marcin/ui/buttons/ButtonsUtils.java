package com.marcin.ui.buttons;

import javax.swing.*;

public interface ButtonsUtils {

    JPanel ButtonsPanel(JButton[] buttons);

    void activateButtons(JButton[] buttons);

    void disableButtons(JButton[] buttons);
}
