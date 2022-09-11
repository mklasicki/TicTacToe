package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



import com.marcin.model.Player;
import com.marcin.ui.dialogs.ClosingGameDialog;
import com.marcin.ui.dialogs.PlayersDialog;
import com.marcin.utils.ResourcesUtil;
import com.marcin.utils.buttons.ButtonsFactory;
import com.marcin.utils.buttons.ButtonsFactoryImpl;
import com.marcin.utils.buttons.ButtonsUtils;
import com.marcin.utils.buttons.ButtonsUtilsImpl;
import com.marcin.utils.player.PlayerUtil;

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
    PlayersPanel playersPanel;
    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    JButton[] buttons;
    Player[] players;
    int turn;

    ButtonsFactory buttonsFactory = new ButtonsFactoryImpl();
    ButtonsUtils buttonsUtils = new ButtonsUtilsImpl();
    PlayerUtil playerUtil = new PlayerUtil();


    public MainWindow() {
        init();
    }


    /**
     * Function initializing main frame
     * */
    private void init() {
        initGraphics();
        initDialogs();
        initMenu();
        //initLabels();
        playersPanel = new PlayersPanel();
        buttons = buttonsFactory.generateButtons();
        players = playerUtil.createPlayers();
        add(playersPanel, BorderLayout.NORTH);
        add(buttonsUtils.ButtonsPanel(buttons), BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Function initializing main frame graphics properties
     * */
    private void initGraphics() {
        setTitle(ResourcesUtil.getResource("main.window.title"));
        ImageIcon mainFrameIcon = new ImageIcon(ResourcesUtil.getResource("main.icon.path"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(316, 462));
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(mainFrameIcon.getImage());
        setLayout(null);
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
           p1NameText.setText(playerUtil.getPlayerNames(playersDialog)[0]);
           p2NameText.setText(playerUtil.getPlayerNames(playersDialog)[1]);
           setPlayers(p1NameText.getName(), p2NameText.getName());
           initButtons(getButtons());
        }

        if (e.getSource().getClass() == JButton.class) {
            JButton button = (JButton)e.getSource();
            int playerId =  playerUtil.getCurrentPlayerIndex(turn);
            button.setText(players[playerId].getMark());
            checkGame();
            if (turn == 9) {
                //endGameWithoutWinner();
            }
            turn++;
        }

    }

    public JButton[] getButtons() {
        return buttons;
    }

    private void setPlayers(String playerOneName, String playerTwoName){
        players[0].setName(p1NameText.getText());
        players[0].setMark("X");
        players[1].setName(p2NameText.getText());
        players[1].setMark("O");

    }

    private void checkGame(){
//        checkRows();
//        checkColumns();
//        checkDiagonal();
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

    private void initLabels() {
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
    }

    private void initButtons(JButton[] buttons) {
        buttonsUtils.activateButtons(buttons);

        for (JButton button : buttons) {
            button.addActionListener(this);
        }
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





