package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;


import com.marcin.model.Player;
import com.marcin.ui.dialogs.ClosingGameDialog;
import com.marcin.ui.dialogs.PlayersDialog;
import com.marcin.utils.ResourcesUtil;

public class MainWindow extends JFrame implements ActionListener {
    OptionsMenu optionsMenu;
    PlayersPanel playersPanel;
    ButtonsPanel buttonsPanel;
    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    int turn;

    // mapa z graczami
    HashMap<Integer, Player> players = new HashMap<>();


    public MainWindow() {
        init();
    }

    /**
     * Function initializing main frame
     * */
    private void init() {
        initGraphics();
        initDialogs();
        optionsMenu = new OptionsMenu();
        playersPanel = new PlayersPanel(this);
        buttonsPanel = new ButtonsPanel(this);
        buttonsPanel.setButtonPressedListener(() -> {
            buttonsPanel.setPlayerMark(getActivePlayerMark(players, turn));
            checkGame();
            turn++;
        });

        setJMenuBar(optionsMenu);
        add(playersPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);

        players = generatePlayers();

        setVisible(true);
    }

    /**
     * Function initializing main frame graphics properties
     * */
    private void initGraphics() {
        setTitle(ResourcesUtil.getStringResource("main.window.title"));
        ImageIcon mainFrameIcon = new ImageIcon(ResourcesUtil.getStringResource("main.icon.path"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(ResourcesUtil.getIntResource("main.window.width"), ResourcesUtil.getIntResource("main.window.height")));
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(mainFrameIcon.getImage());
        setLayout(new BorderLayout());
    }

    public ClosingGameDialog getClosingGameDialog() {
        return closingGameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void checkGame(){
            if (turn == 9) {
                getClosingGameDialog().displayDialog();
            }
//        checkRows();
//        checkColumns();
//        checkDiagonal();
    }

    private void initDialogs() {
        playersDialog = new PlayersDialog();
        closingGameDialog = new ClosingGameDialog();
        playersDialog.initPlayerNamesDialog(this);
        playersDialog.setStringListener((p1Name, p2Name) -> playersPanel.fillNameTextFields(p1Name, p2Name));
        closingGameDialog.initEndGameDialog();
    }


    private HashMap<Integer, Player> generatePlayers() {
        Player player1 = new Player("Marcin", "O");
        Player player2 = new Player("Stefix", "X");

        HashMap<Integer, Player> players = new HashMap<>();
        players.put(1, player1);
        players.put(2, player2);

        return  players;
    }

    private String getActivePlayerMark(HashMap<Integer, Player> players, int turn) {
        if (turn == 1) {
            return players.get(1).getMark();
        }

        if (turn % 2 == 0) {
            return players.get(2).getMark();
        }

        return players.get(1).getMark();
    }


//    private void endGameWithWinner(String winner) {
//        getClosingGameDialog().label.setText("Gratulacje!, wygrywa " + winner + " co chcesz zrobić?");
//        getClosingGameDialog().displayDialog();
//    }

//    private void endGameWithoutWinner() {
//        closingGameDialog.label.setText(UIConsts.MSG_WITHOUT_WINNER);
//        closingGameDialog.displayDialog();
//    }

//    private void checkRows(){
//        JButton[] winners = new JButton[3];
//
//        if ((buttons[0].getText().equals(buttons[1].getText()))
//            && (buttons[0].getText().equals(buttons[2].getText()))
//            && !buttons[0].getText().isEmpty()){
//            buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            for(int i = 0; i < 3; i++) {
//                winners[i] = buttons[i];
//            }
//            buttonsUtils.changeButtonsBorder(winners);
//            endGameWithWinner(winner);
//        }else if ((buttons[3].getText().equals(buttons[4].getText()))
//            && (buttons[3].getText().equals(buttons[5].getText()))
//            && !buttons[3].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[3].getText(), players);
//            winners[0] = buttons[3];
//            winners[1] = buttons[4];
//            winners[2] = buttons[5];
//            buttonsUtils.changeButtonsBorder(winners);
//            endGameWithWinner(winner);
//        }else if ((buttons[6].getText().equals(buttons[7].getText()))
//            && (buttons[6].getText().equals(buttons[8].getText()))
//            && !buttons[6].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[6].getText(), players);
//            winners[0] = buttons[6];
//            winners[1] = buttons[7];
//            winners[2] = buttons[8];
//            buttonsUtils.changeButtonsBorder(winners);
//            endGameWithWinner(winner);
//        }
//
//    }
//
//    private void checkColumns() {
//        if ((buttons[0].getText().equals(buttons[3].getText()))
//            && (buttons[0].getText().equals(buttons[6].getText()))
//            && !buttons[0].getText().isEmpty()){
//            buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[1].getText().equals(buttons[4].getText()))
//            && (buttons[1].getText().equals(buttons[7].getText()))
//            && !buttons[1].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[1].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[2].getText().equals(buttons[5].getText()))
//            && (buttons[2].getText().equals(buttons[8].getText()))
//            && !buttons[2].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
//            endGameWithWinner(winner);
//        }
//    }
//
//    private void checkDiagonal() {
//        if ((buttons[0].getText().equals(buttons[4].getText()))
//            && (buttons[0].getText().equals(buttons[8].getText()))
//            && !buttons[0].getText().isEmpty()) {
//            buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            endGameWithWinner(winner);
//        } else if ((buttons[2].getText().equals(buttons[4].getText()))
//            && (buttons[2].getText().equals(buttons[6].getText()))
//            && !buttons[2].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
//            endGameWithWinner(winner);
//        }
//    }

}





