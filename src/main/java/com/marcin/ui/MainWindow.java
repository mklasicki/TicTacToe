package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.consts.UIConsts;
import com.marcin.model.Player;
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
    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    JButton[] buttons;
    Player[] players;
    int turn;

    ButtonsFactory buttonsFactory = new ButtonsFactoryImpl();
    ButtonsUtils buttonsUtils = new ButtonsUtilsImpl();
    PlayerUtil playerUtil = new PlayerUtil();


    public void init() {

        setTitle("Kółko i krzyżyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(UIConsts.X_POS, UIConsts.Y_POS, UIConsts.APP_WIDTH, UIConsts.APP_HEIGHT);
        setLayout(null);

        initDialogs();
        initMenu();
        initLabels();
        buttons = buttonsFactory.generateButtons();
        players = playerUtil.createPlayers();
        add(buttonsUtils.ButtonsPanel(buttons));

        setVisible(true);
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

    public JButton[] getButtons() {
        return buttons;
    }

    private void initButtons(JButton[] buttons) {
        buttonsUtils.activateButtons(buttons);
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
    }

}





