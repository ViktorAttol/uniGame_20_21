package StartManager;

import gameControl.Turn;
import gameControl.TurnImpl;

import java.io.*;
import java.util.Scanner;

public class GameUI {

    public static void main(String[] args) throws IOException, InterruptedException {
        int[][] array = new int[4][4];
        printArray(array);
        Turn turn = new TurnImpl(array);
        Scanner scanner = new Scanner(System.in);
        while(true){
            int po = turn.setInput(Integer.parseInt(scanner.nextLine()), 1);
            printArray(array);
        }
        // start as server or client

        // send layout to client || receive layout from server

        // start game
        /*
        loop while no winner
            player/oponent
        game end close sockets
         */
        /*
        boolean startOptionFound = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the wonderfull game of tic-tac-toe!");

        while(!startOptionFound) {
            System.out.println("Please choose if you want to start the game as host or client");
            System.out.println("For host input: h");
            System.out.println("For client input: c");


            String startOptions = scanner.nextLine();
            System.out.println("input was: " + startOptions);
            if (startOptions.equals("h") || startOptions.equals("H")) {
                startOptionFound = true;
                System.out.println("start as host");
            } else if (startOptions.equals("c") || startOptions.equals("C")) {
                startOptionFound = true;
                System.out.println("start as client");
            } else {
                System.out.println("Wrong input");
            }
        }
         */


       // scanner.close();

    }

    private static void printArray(int[][] array){
        for (int[] i: array) {
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
