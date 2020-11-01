package StartManager;

import gameControl.Turn;
import gameControl.TurnImpl;
import gameData.*;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPConnector;

import java.io.*;
import java.util.Scanner;

public class GameUI {

    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length < 1 || args.length > 3){
            System.err.println("False argument input!");
            System.err.println("For server: port dimX dimY");
            System.err.println("For client: hostname port");
            return;
        }
        //tcp relevant
        String hostname = null;
        int port = -1;
        int dimX = 4;
        int dimY = 4;
        Connection tcpConnection = null;

        //game relevant
        int player = 0;
        GameState gameState = null;

        //todo find better solution
        //server
        if(args.length == 3){
            port = Integer.parseInt(args[0]);
            dimX = Integer.parseInt(args[1]);
            dimY = Integer.parseInt(args[2]);
            if(dimX < 3) dimX = 3;
            if(dimX > 15) dimX = 15;
            if(dimY < 3) dimX = 3;
            if(dimX > 15) dimX = 15;
            player = 1;
            Server server = new TCPConnector();
            tcpConnection = server.acceptConnection(port);
            gameState = new GameStateImpl(dimX, dimY);
            GameDataSender gameDataSender = new GameDataExchanger();
            gameDataSender.sendGameLayout(gameState, tcpConnection.getOutputStream());

        }
        //client
        if(args.length == 2){
            hostname = args[0];
            port = Integer.parseInt(args[1]);
            player = 2;
            Client client = new TCPConnector();
            tcpConnection = client.connect(hostname, port);
            GameDataReceiver gameDataReceiver = new GameDataExchanger();
            gameState = gameDataReceiver.receiveGameLayout(tcpConnection.getInputStream());
        }


        //pre gameloop
        printArray(gameState.getGameState());
        Turn turn = new TurnImpl(gameState.getGameState());
        Scanner scanner = new Scanner(System.in);
        int currentPlayer = 1;
        int returnValue = 0;    //0 no winner and game continues, 1 game is won, 2 game over with draw, -1 for false input
        int round = 0;

        //gameloop
        while(returnValue == 0 || returnValue == -1){
            //for user
            if(currentPlayer == player){
                int input;
                do {
                    input = Integer.parseInt(scanner.nextLine());
                    returnValue = turn.setInput(input, currentPlayer);
                    if(returnValue == -1)System.out.println("Invalid input!");
                }while(returnValue == -1);
                GameData gameData = new GameDataImpl(input, round, player);
                GameDataSender gameDataSender = new GameDataExchanger();
                gameDataSender.sendGameData(gameData, tcpConnection.getOutputStream());
            //for opponent
            } else if(currentPlayer != player){
                GameDataReceiver gameDataReceiver = new GameDataExchanger();
                GameData gameData = gameDataReceiver.receiveGameData(tcpConnection.getInputStream());
                returnValue = turn.setInput(gameData.getInputIndex(), currentPlayer);
            }

            printArray(gameState.getGameState());

            if(returnValue == 1) System.out.println("Player " + currentPlayer + " winns the game!");
            if(returnValue == 2) System.out.println("Game over without winner O_o...");

            currentPlayer = changePlayer(currentPlayer);
        }

        scanner.close();
        tcpConnection.getSocket().close();
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

    private static int changePlayer(int player){
        if(player == 1){
            return 2;
        } else{
            return 1;
        }
    }
}
