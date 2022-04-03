package com.marcin.ui;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenuItem resetGame;
    JMenuItem quit;
    JLabel p1Name;
    JLabel p2Name;
    JLabel p1NameText;
    JLabel p2NameText;

    private final int buttonHeight = 100;
    private final int buttonWidth = 100;


    public void init() {


        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 316, 462);
        setLayout(null);

        optionsMenu = new JMenu("Opcje");
        mainMenuBar = new JMenuBar();
        resetGame = new JMenuItem("Resetuj grę");
        quit = new JMenuItem("Wyjdź");
        optionsMenu.add(resetGame);
        optionsMenu.add(quit);
        mainMenuBar.add(optionsMenu);
        setJMenuBar(mainMenuBar);

        p1Name = new JLabel("Gracz 1: ");
        p2Name = new JLabel("Gracz 2: ");
        p1NameText = new JLabel("Marcin");
        p2NameText = new JLabel("Marcin");

        p1Name.setBounds(10, 10, 50, 20);
        p2Name.setBounds(10, 40, 50, 20);
        p1NameText.setBounds(70, 10, 150, 20);
        p2NameText.setBounds(70, 40, 150, 20);

        add(p1Name);
        add(p2Name);
        add(p1NameText);
        add(p2NameText);

        addButtonsPanel(this);

        setVisible(true);
    }


    private void addButtonsPanel(JFrame frame){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setBounds(0, 100, 300, 300);

        JButton[] buttons = generateButtons();

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
            buttonsPanel.add(button);
        }

        frame.add(buttonsPanel);

    }

    private JButton[] generateButtons() {
        JButton[] buttons = new JButton[9];

        for(int i = 0; i< buttons.length; i++) {
            buttons[i] = new JButton("X");
        }

        return buttons;
    }


}
