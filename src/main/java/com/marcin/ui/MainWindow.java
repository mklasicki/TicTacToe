package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.model.Player;

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
    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    JButton[] buttons;
    Player[] players;
    int turn;
    boolean isGameActive;

    public void init() {

        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 316, 462);
        setLayout(null);

        players = createPlayers();
        turn = 1;
        isGameActive = false;
        playersDialog = new PlayersDialog();
        closingGameDialog = new ClosingGameDialog();
        playersDialog.initPlayerNamesDialog();
        closingGameDialog.initEndGameDialog();
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
         int buttonHeight = 100;
         int buttonWidth = 100;

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setBounds(0, 100, 300, 300);

        buttons = generateButtons();

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
            button.setEnabled(false);
            buttonsPanel.add(button);
            button.addActionListener(this);
        }

        frame.add(buttonsPanel);

    }

    private JButton[] generateButtons() {
        buttons = new JButton[9];

        for(int i = 0; i< buttons.length; i++) {
            buttons[i] = new JButton();
        }

        return buttons;
    }

    private void activateButtons(JButton[] buttons) {
            for(JButton button : buttons) {
                button.setEnabled(true);
            }
    }

    public JButton[] getButtons() {
        return buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            this.dispose();
        }

        if (e.getSource() == newGame) {
           playersDialog.displayDialog();
           p1NameText.setText(getPlayerNames()[0]);
           p2NameText.setText(getPlayerNames()[1]);
           setPlayers(p1NameText.getName(), p2NameText.getName());
           activateButtons(getButtons());
        }

        if (e.getSource().getClass() == JButton.class) {
            JButton button = (JButton)e.getSource();
            int playerId =  getCurrentPlayerIndex(turn);
            button.setText(players[playerId].getMark());
            button.setEnabled(false);
            if (turn == 9) {
                closingGameDialog.displayDialog();
            }
            turn++;
        }
    }

    private String[] getPlayerNames(){
        return playersDialog.getPlayerNames();
        }


    private Player[] createPlayers() {
        players = new Player[2];
        players[0] = new Player(1,null);
        players[1] = new Player(2,null);
        return players;
    }

    private void setPlayers(String playerOneName, String playerTwoName){
        players[0].setName(p1NameText.getText());
        players[0].setMark("X");
        players[1].setName(p2NameText.getText());
        players[1].setMark("O");
    }

    private int getCurrentPlayerIndex(int turn) {
        if (turn == 1) {
            return 0;
        }

        if (turn % 2 == 0) {
            return 1;
        }

        return 0;
    }

}





