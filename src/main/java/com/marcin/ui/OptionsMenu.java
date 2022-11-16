package com.marcin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.marcin.utils.NewGameListener;
import com.marcin.utils.QuitGameListener;

public class OptionsMenu extends JMenuBar implements ActionListener {
    private JMenu options;
    private JMenu results;
    private JMenuItem newGame;
    private JMenuItem resetGame;
    private JMenuItem quit;
    private JMenuItem showResults;
    private JMenuItem exportResults;
    private NewGameListener newGameListener;
    private QuitGameListener quitGameListener;

    public OptionsMenu() {
        init();
    }

    private void init() {
        results = new JMenu("Wyniki");
        options = new JMenu("Opcje");
        newGame = new JMenuItem("Nowa Gra");
        resetGame = new JMenuItem("Resetuj grę");
        showResults = new JMenuItem("Pokaż");
        exportResults = new JMenuItem("Eksportuj");
        quit = new JMenuItem("Wyjdź");

        quit.addActionListener(this);
        newGame.addActionListener(this);

        options.add(newGame);
        options.add(resetGame);
        options.add(quit);
        results.add(showResults);
        results.add(exportResults);

        add(options);
        add(results);


    }

    public void setNegGameListener(NewGameListener negGameListener) {
        this.newGameListener = negGameListener;
    }

    public void setQuitGameListener(QuitGameListener quitGameListener) {
        this.quitGameListener = quitGameListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
         quitGameListener.quitGame();
        }

        if (e.getSource() == newGame) {
            newGameListener.startNewGame();
            //            turn = 1;
//            playersDialog.displayDialog();
//            buttonsPanel.enableButtons();
        }
    }
}
