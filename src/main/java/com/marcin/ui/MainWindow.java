package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.consts.UIConsts;
import com.marcin.model.Player;
import com.marcin.ui.buttons.Buttons;
import com.marcin.ui.buttons.ButtonsFactory;
import com.marcin.ui.labels.LabelPanel;
import com.marcin.utils.player.PlayerUtil;

public class MainWindow extends JFrame implements ActionListener {

    JLabel p1NameText;
    JLabel p2NameText;
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenuItem newGame;
    JMenuItem resetGame;
    JMenuItem quit;

    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    JButton[] buttons;
    Player[] players;
    int turn;

    Buttons buttonsFactory = new ButtonsFactory();
    PlayerUtil playerUtil = new PlayerUtil();

    LabelPanel labelPanel = new LabelPanel(this);

    public void init() {
        initDialogs();
        initMenu();
        initButtons();
        players = playerUtil.createPlayers();
        initGraphics();
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
            turn = 1;
           playersDialog.displayDialog();
           labelPanel.setP1NameText(playerUtil.getPlayerNames(playersDialog)[0]);
           labelPanel.setP2NameText(playerUtil.getPlayerNames(playersDialog)[1]);            setPlayers(p1NameText.getName(), p2NameText.getName());
           buttonsFactory.activateButtons();
        }

        if (e.getSource().getClass() == JButton.class) {
            JButton button = (JButton)e.getSource();
            int playerId =  playerUtil.getCurrentPlayerIndex(turn);
            button.setText(players[playerId].getMark());
            checkGame();
            if (turn == 9) {
                endGameWithoutWinner();
            }
            turn++;
        }
    }

    private void initGraphics(){
        setTitle(UIConsts.APP_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(UIConsts.X_POS, UIConsts.Y_POS, UIConsts.APP_WIDTH, UIConsts.APP_HEIGHT);
        setVisible(true);
    }

    private void setPlayers(String playerOneName, String playerTwoName){
        players[0].setName(p1NameText.getText());
        players[0].setMark("X");
        players[1].setName(p2NameText.getText());
        players[1].setMark("O");
    }

    private void checkGame(){
        checkRows();
        checkColumns();
        checkDiagonal();
    }

    private void initDialogs() {
        playersDialog = new PlayersDialog();
        closingGameDialog = new ClosingGameDialog();
        playersDialog.initPlayerNamesDialog();
        closingGameDialog.initEndGameDialog();
    }

    private void initMenu(){
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
    }

    private void initButtons(){
        buttonsFactory.addButtons(this);
    }


    //TODO: move all those methods to separate class
    private void endGameWithWinner(String winner) {
        getClosingGameDialog().label.setText("Gratulacje!, wygrywa " + winner + " co chcesz zrobić?");
        getClosingGameDialog().displayDialog();
    }

    private void endGameWithoutWinner() {
        closingGameDialog.label.setText(UIConsts.MSG_WITHOUT_WINNER);
        closingGameDialog.displayDialog();
    }

    private void checkRows(){
        if ((buttons[0].getText().equals(buttons[1].getText()))
            && (buttons[0].getText().equals(buttons[2].getText()))
            && !buttons[0].getText().isEmpty()){
            buttonsFactory.disableButtons();
            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
            endGameWithWinner(winner);
        }else if ((buttons[3].getText().equals(buttons[4].getText()))
            && (buttons[3].getText().equals(buttons[5].getText()))
            && !buttons[3].getText().isEmpty()) {
            String winner = playerUtil.getPlayerNameByMark(buttons[3].getText(), players);
            endGameWithWinner(winner);
        }else if ((buttons[6].getText().equals(buttons[7].getText()))
            && (buttons[6].getText().equals(buttons[8].getText()))
            && !buttons[6].getText().isEmpty()) {
            String winner = playerUtil.getPlayerNameByMark(buttons[6].getText(), players);
            endGameWithWinner(winner);
        }

    }

    private void checkColumns() {
        if ((buttons[0].getText().equals(buttons[3].getText()))
            && (buttons[0].getText().equals(buttons[6].getText()))
            && !buttons[0].getText().isEmpty()){
            buttonsFactory.disableButtons();
            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
            endGameWithWinner(winner);
        }else if ((buttons[1].getText().equals(buttons[4].getText()))
            && (buttons[1].getText().equals(buttons[7].getText()))
            && !buttons[1].getText().isEmpty()) {
            String winner = playerUtil.getPlayerNameByMark(buttons[1].getText(), players);
            endGameWithWinner(winner);
        }else if ((buttons[2].getText().equals(buttons[5].getText()))
            && (buttons[2].getText().equals(buttons[8].getText()))
            && !buttons[2].getText().isEmpty()) {
            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
            endGameWithWinner(winner);
        }
    }

    private void checkDiagonal() {
        if ((buttons[0].getText().equals(buttons[4].getText()))
            && (buttons[0].getText().equals(buttons[8].getText()))
            && !buttons[0].getText().isEmpty()) {
            buttonsFactory.disableButtons();
            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
            endGameWithWinner(winner);
        } else if ((buttons[2].getText().equals(buttons[4].getText()))
            && (buttons[2].getText().equals(buttons[6].getText()))
            && !buttons[2].getText().isEmpty()) {
            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
            endGameWithWinner(winner);
        }
    }

}





