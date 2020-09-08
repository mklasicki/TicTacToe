package com.marcin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String[][] grid = new String[5][5];
    private Scanner scanner = new Scanner(System.in);
    private List<Integer> fields = new ArrayList<>();

    public  void run() {

        int count = 0;
        String mark = " ";


        printStartMessage();
        createGrid();
        printGrid();

        while(count < 9) {

            if (checkIfSomeoneWon(grid)) {
                System.out.println("End of the game, player with " + mark + " has won!");
                break;
            }

            if (count % 2 == 0) {
                mark = "X";
            } else {
                mark = "O";
            }

            System.out.println("Enter field number from 1 - 9");
            int choice = scanner.nextInt();

            if (checkIfFieldIsTaken(choice)) {

                switch (choice) {
                    case 1:
                        grid[1][1] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 2:
                        grid[1][2] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 3:
                        grid[1][3] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 4:
                        grid[2][1] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 5:
                        grid[2][2] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 6:
                        grid[2][3] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 7:
                        grid[3][1] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 8:
                        grid[3][2] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                    case 9:
                        grid[3][3] = mark;
                        printGrid();
                        count++;
                        fields.add(choice);
                        break;
                }
            }

        }

    }

    public  void createGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (i == 0 || i == 4) {
                    grid[i][j] = "*";
                }
                if( j == 0 || j == 4) {
                    grid[i][j] = "*";
                }
            }
        }
    }

    public  void printGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public  void printStartMessage() {

        System.out.println("Starting new game");
        System.out.println("Creating new grid!");
        System.out.println();
    }

    public  boolean checkIfFieldIsTaken(int choice) {

        if (fields.contains(choice)) {
            System.out.println("That field is taken");
            return false;
        }
        return true;
    }

    public static boolean checkIfSomeoneWon(String[][] grid) {

        if ((grid[1][1].equals(grid[1][2]) && grid[1][1].equals(grid[1][3])) && !grid[1][1].equals(" ")) {
            return true;
        } else if ((grid[1][1].equals(grid[2][1]) && grid[2][1].equals(grid[3][1])) && !grid[1][2].equals(" ")) {
            return true;
        } else if ((grid[3][1].equals(grid[3][2]) && grid[3][2].equals(grid[3][3])) && !grid[3][1].equals(" ")) {
            return true;
        } else if ((grid[1][1].equals(grid[2][2]) && grid[2][2].equals(grid[3][3])) && !grid[1][1].equals(" ")) {
            return true;
        }

        return false;
    }


}
