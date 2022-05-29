package com.marcin.ui.labels;

import javax.swing.*;
import java.awt.*;

public class LabelPanel extends JPanel {

    public LabelPanel(JFrame frame){
        init(frame);
    }

    private void init(JFrame frame){
        this.setLayout(new GridLayout(2,3,5,10));
        JLabel p1Name = new JLabel("Gracz 1:");
        JLabel p2Name = new JLabel("Gracz 2:");
        JLabel p1NameText = new JLabel();
        JLabel p2NameText = new JLabel();
        JLabel timer = new JLabel("00:00:00");

        this.add(p1Name);
        this.add(p1NameText);
        this.add(timer);
        this.add(p2Name);
        this.add(p2NameText);

        frame.add(this, BorderLayout.NORTH);
    }


}
