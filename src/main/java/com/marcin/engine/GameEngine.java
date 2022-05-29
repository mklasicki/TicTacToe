package com.marcin.engine;

import com.marcin.consts.UIConsts;

import javax.swing.*;

public class GameEngine {
//    private void endGameWithWinner(String winner) {
//        getClosingGameDialog().label.setText("Gratulacje!, wygrywa " + winner + " co chcesz zrobić?");
//        getClosingGameDialog().displayDialog();
//    }
//
//    private void endGameWithoutWinner() {
//        closingGameDialog.label.setText(UIConsts.MSG_WITHOUT_WINNER);
//        closingGameDialog.displayDialog();
//    }
//
//    private void checkRows(JButton[] buttons){
//        if ((buttons[0].getText().equals(buttons[1].getText()))
//                && (buttons[0].getText().equals(buttons[2].getText()))
//                && !buttons[0].getText().isEmpty()){
//            //buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[3].getText().equals(buttons[4].getText()))
//                && (buttons[3].getText().equals(buttons[5].getText()))
//                && !buttons[3].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[3].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[6].getText().equals(buttons[7].getText()))
//                && (buttons[6].getText().equals(buttons[8].getText()))
//                && !buttons[6].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[6].getText(), players);
//            endGameWithWinner(winner);
//        }
//
//    }
//
//    private void checkColumns(JButton[] buttons) {
//        if ((buttons[0].getText().equals(buttons[3].getText()))
//                && (buttons[0].getText().equals(buttons[6].getText()))
//                && !buttons[0].getText().isEmpty()){
//           // buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[1].getText().equals(buttons[4].getText()))
//                && (buttons[1].getText().equals(buttons[7].getText()))
//                && !buttons[1].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[1].getText(), players);
//            endGameWithWinner(winner);
//        }else if ((buttons[2].getText().equals(buttons[5].getText()))
//                && (buttons[2].getText().equals(buttons[8].getText()))
//                && !buttons[2].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
//            endGameWithWinner(winner);
//        }
//    }
//
//    private void checkDiagonal(JButton[] buttons) {
//        if ((buttons[0].getText().equals(buttons[4].getText()))
//                && (buttons[0].getText().equals(buttons[8].getText()))
//                && !buttons[0].getText().isEmpty()) {
//            //buttonsUtils.disableButtons(getButtons());
//            String winner = playerUtil.getPlayerNameByMark(buttons[0].getText(), players);
//            endGameWithWinner(winner);
//        } else if ((buttons[2].getText().equals(buttons[4].getText()))
//                && (buttons[2].getText().equals(buttons[6].getText()))
//                && !buttons[2].getText().isEmpty()) {
//            String winner = playerUtil.getPlayerNameByMark(buttons[2].getText(), players);
//            endGameWithWinner(winner);
//        }
//    }

}
