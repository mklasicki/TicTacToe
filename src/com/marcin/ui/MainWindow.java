package com.marcin.ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenuItem resetGame;
    JMenuItem quit;

    public void init() {

        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        optionsMenu = new JMenu("Opcje");
        mainMenuBar = new JMenuBar();
        resetGame = new JMenuItem("Resetuj grę");
        quit = new JMenuItem("Wyjdź");
        optionsMenu.add(resetGame);
        optionsMenu.add(quit);
        mainMenuBar.add(optionsMenu);

        setJMenuBar(mainMenuBar);


        setVisible(true);
    }







}
