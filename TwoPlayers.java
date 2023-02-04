package com.SnakeAndLadder;
import java.util.Random;
import java.util.Scanner;


public class TwoPlayers {
    static int SNAKE = -1;
    static int LADDER = 1;
    static int NO_PLAY = 0;

    static int[] board = new int[101];

    static void initializeBoard() {

        // initialize all cells as NO_PLAY
        for (int i = 0; i <= 100; i++) {
            board[i] = NO_PLAY;
        }

        // add ladders
        board[3] = 22;
        board[5] = 8;
        board[11] = 26;
        board[20] = 29;

        // add snakes
        board[17] = -13;
        board[19] = -14;
        board[21] = -42;
        board[27] = -34;
    }

    static int play(int player, int dice) {
        int position = player + dice;
        if (position > 100) {
            return player;
        }

        int playType = board[position];
        if (playType == SNAKE) {
            position = position + playType;
        } else if (playType == LADDER) {
            position = position + playType;
        }

        return position;
    }

    public static void main(String[] args) {
        initializeBoard();

        int player1 = 0, player2 = 0;
        Random rand = new Random();
        Scanner roll_Dice = new Scanner(System.in);

        System.out.println("Game started!");
        while (player1 < 100 && player2 < 100) {
            System.out.println("Player 1 turn, press enter to play");
            roll_Dice.nextLine();
            int dice = rand.nextInt(6) + 1;
            player1 = play(player1, dice);
            System.out.println("Player 1 is Position is " + player1);

            if (player1 == 100) {
                System.out.println("Player 1 won The Game!");
                break;
            }

            System.out.println("Player 2 turn, press enter to play");
            roll_Dice.nextLine();
            dice = rand.nextInt(6) + 1;
            player2 = play(player2, dice);
            System.out.println("Player 2 Position is  " + player2);

            if (player2 == 100) {
                System.out.println("Player 2 won The Game!");
                break;
            }
        }
    }
}
