package com.marcin.utils.buttons;

import javax.swing.*;

public interface ButtonsUtils {

    JPanel ButtonsPanel(JButton[] buttons);

    void activateButtons(JButton[] buttons);

    void disableButtons(JButton[] buttons);

    void changeButtonsBorder(JButton[] buttons);
}
