package com.marcin.ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenuItem resetGame;
    JMenuItem quit;
    JLabel p1Name;
    JLabel p2Name;



    public void init() {


        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
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

        p1Name.setBounds(10, 10, 100, 20);
        p2Name.setBounds(10, 40, 100, 20);


        add(p1Name);
        add(p2Name);



        setVisible(true);
    }







}
