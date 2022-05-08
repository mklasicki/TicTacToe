package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.model.Player;
import com.marcin.utils.ButtonsFactory;
import com.marcin.utils.ButtonsFactoryImpl;
import com.marcin.utils.PlayerUtil;

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
    ButtonsFactory buttonsFactory = new ButtonsFactoryImpl();
    PlayerUtil playerUtil = new PlayerUtil();

    public void init() {

        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 316, 462);
        setLayout(null);
        players = playerUtil.createPlayers();
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

    //TODO: add button factory, make interface and implementation for it
    private void addButtonsPanel(JFrame frame){
         int buttonHeight = 100;
         int buttonWidth = 100;

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setBounds(0, 100, 300, 300);

        buttons = buttonsFactory.generateButtons();

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

    public JButton[] getButtons() {
        return buttons;
    }

    public ClosingGameDialog getClosingGameDialog() {
        return closingGameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            this.dispose();
        }

        if (e.getSource() == newGame) {
           playersDialog.displayDialog();
           p1NameText.setText(playerUtil.getPlayerNames(playersDialog)[0]);
           p2NameText.setText(playerUtil.getPlayerNames(playersDialog)[1]);
           setPlayers(p1NameText.getName(), p2NameText.getName());
           buttonsFactory.activateButtons(getButtons());
        }

        if (e.getSource().getClass() == JButton.class) {
            JButton button = (JButton)e.getSource();
            int playerId =  playerUtil.getCurrentPlayerIndex(turn);
            button.setText(players[playerId].getMark());
            checkGame(getButtons(), playerUtil.getPlayers());
            if (turn == 9) {
                closingGameDialog.label.setText("Remis!, nikt nie wygrywa, co chcesz zrobić?");
                closingGameDialog.displayDialog();
            }
            turn++;
        }
    }


    private void setPlayers(String playerOneName, String playerTwoName){
        players[0].setName(p1NameText.getText());
        players[0].setMark("X");
        players[1].setName(p2NameText.getText());
        players[1].setMark("O");
    }

    //TODO: add more conditions to game engine
    private void checkGame(JButton[] buttons, Player[] players){
        if ((buttons[0].getText().equals(buttons[1].getText())) && (buttons[0].getText().equals(buttons[2].getText()))){
            for(JButton button: buttons) {
                button.setEnabled(false);
            }
            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
            getClosingGameDialog().label.setText("Gratulacje!, wygrywa " + winner + " co chcesz zrobić?");
            getClosingGameDialog().displayDialog();
        }
    }

}





