package com.mycomany.xogame;
import java.util.Scanner;

public class Game {
    protected Board board;
    protected Player[] players;
    protected int turn = 0;

    Game(Board b,Player[] p) {
        this.board = b;
        this.players = p;
    }
    public void play_game(){
        while(true){
            turn = 0;
            while (turn < 2){
                Scanner in_x = new Scanner(System.in);
                Scanner in_y = new Scanner(System.in);
                System.out.println("Player "+ (turn + 1) + " Where would you like to play? ");
                board.display_board();

                System.out.println("-- From 1 to 3 --\n Choose row and column: ");
                int x = in_x.nextInt();
                int y = in_y.nextInt();

                if ( !board.update_board( (x-1), (y-1), players[turn].get_symbol() ) ) {
                    System.out.println("Wrong position!.. Please enter valid position: ");
                    continue;
                }

                if (board.is_winner( players[turn].get_symbol() ) ) {
                    System.out.println(players[turn].get_name() + " wins! Congratulations <3");
                    return;
                }

                if( board.is_draw() ){
                    System.out.println("Game is draw!");
                    return;
                }
                turn++;
            }

        }
    }

}
