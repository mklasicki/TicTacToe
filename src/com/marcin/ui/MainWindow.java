package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenuItem newGame;
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

        mainMenuBar = new JMenuBar();
        optionsMenu = new JMenu("Opcje");
        newGame = new JMenuItem("Nowa Gra");
        resetGame = new JMenuItem("Resetuj grę");
        quit = new JMenuItem("Wyjdź");

        quit.addActionListener(this);
        newGame.addActionListener(this);


        optionsMenu.add(newGame);
        optionsMenu.add(resetGame);
        optionsMenu.add(quit);
        mainMenuBar.add(optionsMenu);
        setJMenuBar(mainMenuBar);

        p1Name = new JLabel("Gracz 1: ");
        p2Name = new JLabel("Gracz 2: ");
        p1NameText = new JLabel();
        p2NameText = new JLabel();

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
            buttons[i] = new JButton();
        }

        return buttons;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            this.dispose();
        } else if(e.getSource() == newGame) {
            JDialog dialog = new JDialog(this,"Nowa gra");
            JLabel p1Name = new JLabel("Imię pierwszego gracza: ");
            JLabel p2Name = new JLabel("Imie drugiego gracza: ");
            JButton submitPlayers = new JButton("Zatwierdź");
            JButton resetData = new JButton("Resetuj");
            JButton quit = new JButton("Wyjdź");
            JTextField p1TextField = new JTextField();
            JTextField p2TextField = new JTextField();

            p1Name.setBounds(10, 10, 200, 20);
            p2Name.setBounds(10, 40, 200, 20);

            p1TextField.setBounds(250, 10, 100, 20);
            p2TextField.setBounds(250, 40, 100, 20);

            submitPlayers.setBounds(10, 80, 100, 30);
            resetData.setBounds(130, 80, 100, 30);
            quit.setBounds(250, 80,100, 30);


            dialog.setLayout(null);
            dialog.setBounds(400, 400, 380, 160);
            dialog.add(p1Name);
            dialog.add(p2Name);
            dialog.add(p1TextField);
            dialog.add(p2TextField);
            dialog.add(submitPlayers);
            dialog.add(resetData);
            dialog.add(quit);
            dialog.setVisible(true);

            submitPlayers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name1 = p1TextField.getText();
                    String name2 = p2TextField.getText();
                    p1NameText.setText(name1);
                    p2NameText.setText(name2);
                    dialog.dispose();
                }
            });

           resetData.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   p1TextField.setText("");
                   p2TextField.setText("");
               }

           });


           quit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   dialog.dispose();
               }
           });

        }

    }

}
