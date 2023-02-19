package com.mycomany.xogame;

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
                System.out.println("Player "+ (turn + 1) + " Where would you like to play? ");
                board.display_board();
                Move move= players[turn].get_move();

                if ( !board.update_board(move, players[turn].get_symbol() ) ) {
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
