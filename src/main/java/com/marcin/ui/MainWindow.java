package com.marcin.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import com.marcin.ButtonPressedListener;
import com.marcin.StringListener;
import com.marcin.model.Player;
import com.marcin.ui.dialogs.ClosingGameDialog;
import com.marcin.ui.dialogs.PlayersDialog;
import com.marcin.utils.ResourcesUtil;

public class MainWindow extends JFrame implements ActionListener {
    JMenuBar mainMenuBar;
    JMenu optionsMenu;
    JMenu results;
    JMenuItem newGame;
    JMenuItem resetGame;
    JMenuItem quit;
    JMenuItem showResults;
    JMenuItem exportResults;
    PlayersPanel playersPanel;
    PlayersDialog playersDialog;
    ClosingGameDialog closingGameDialog;
    ButtonsPanel buttonsPanel;

    Player[] players;
    int turn;
    String mark = "M"; // do testów

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
        playersPanel = new PlayersPanel(this);
        buttonsPanel = new ButtonsPanel(this);
        buttonsPanel.setButtonPressedListener(new ButtonPressedListener() {
            @Override
            public void buttonPressed() {
                buttonsPanel.setPlayerMark(mark);
                checkGame();
                turn++;
            }
        });


        add(playersPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);
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
        if (e.getSource() == quit) {
            this.dispose();
        }

        if (e.getSource() == newGame) {
            turn = 1;
            playersDialog.displayDialog();
            buttonsPanel.enableButtons();
        }
    }

    private void checkGame(){
           System.out.println("Tura " + turn);
            if (turn == 9) {
                System.out.println("Koniec gry");
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
        playersDialog.setStringListener(new StringListener() {
            @Override
            public void getNames(String p1Name, String p2Name) {
                playersPanel.fillNameTextFields(p1Name, p2Name);
            }
        });

        closingGameDialog.initEndGameDialog();
    }

    private void initMenu(){
        mainMenuBar = new JMenuBar();
        results = new JMenu("Wyniki");
        optionsMenu = new JMenu("Opcje");
        newGame = new JMenuItem("Nowa Gra");
        resetGame = new JMenuItem("Resetuj grę");
        showResults = new JMenuItem("Pokaż");
        exportResults = new JMenuItem("Eksportuj");

        quit = new JMenuItem("Wyjdź");

        quit.addActionListener(this);
        newGame.addActionListener(this);

        optionsMenu.add(newGame);
        optionsMenu.add(resetGame);
        optionsMenu.add(quit);
        results.add(showResults);
        results.add(exportResults);
        mainMenuBar.add(optionsMenu);
        mainMenuBar.add(results);

        setJMenuBar(mainMenuBar);
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





