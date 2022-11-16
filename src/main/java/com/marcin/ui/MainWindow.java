package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;


import com.marcin.model.GameEngine;
import com.marcin.model.Player;
import com.marcin.ui.dialogs.ClosingGameDialog;
import com.marcin.ui.dialogs.PlayersDialog;
import com.marcin.utils.NewGameListener;
import com.marcin.utils.QuitGameListener;
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

    // silnik gry
    GameEngine gameEngine = new GameEngine();


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
        optionsMenu.setNegGameListener(new NewGameListener() {
            @Override
            public void startNewGame() {
                playersDialog.displayDialog();
                buttonsPanel.enableButtons();
            }
        });

        optionsMenu.setQuitGameListener(new QuitGameListener() {
            @Override
            public void quitGame() {
                showConfirmDialog();
            }
        });

        playersPanel = new PlayersPanel(this);
        buttonsPanel = new ButtonsPanel(this);
        buttonsPanel.setButtonPressedListener(() -> {
            buttonsPanel.setPlayerMark(getActivePlayerMark(players, turn));
            checkGame();
            gameEngine.checkGame(turn);
            turn++;
            System.out.println("Tura: " + turn);
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
        playersDialog.setPlayersNamesListener((p1Name, p2Name) -> playersPanel.fillNameTextFields(p1Name, p2Name));
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

    public void showConfirmDialog() {
        if (JOptionPane.showConfirmDialog(this, "Czy na pewno chcesz opuscic gre?",
            "Ostrzeżenie,",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
         dispose();
        }
    }

}





