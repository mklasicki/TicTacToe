package com.marcin.ui.labels;

import javax.swing.*;
import java.awt.*;

public class LabelPanel extends JPanel {

    private JLabel p1Name;
    private JLabel p2Name;
    private JLabel p1NameText;
    private JLabel p2NameText;

    public LabelPanel(JFrame frame){
        init(frame);
    }

    private void init(JFrame frame){
        this.setLayout(new GridLayout(2,3,5,10));
        p1Name = new JLabel("Gracz 1:");
        p2Name = new JLabel("Gracz 2:");
        p1NameText = new JLabel();
        p2NameText = new JLabel();
        JLabel timer = new JLabel("00:00:00");

        this.add(p1Name);
        this.add(p1NameText);
        this.add(timer);
        this.add(p2Name);
        this.add(p2NameText);

        frame.add(this, BorderLayout.NORTH);
    }

    public JLabel getP1NameText() {
        return p1NameText;
    }

    public void setP1NameText(String p1Name) {
        this.p1NameText.setText(p1Name);
    }

    public JLabel getP2NameText() {
        return p2NameText;
    }

    public void setP2NameText(String p2Name) {
        this.p2NameText.setText(p2Name);
    }
}
