package com.marcin.model;


public class GameEngine {


    public void checkGame(int turn) {
        if (turn == 9) {
            //otworzyc dialog zamykajacy gre
            System.out.println("dialog zamykajacy gre");

        }

//        checkRows();
//        checkColumns();
//        checkDiagonal();
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
