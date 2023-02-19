package com.mycomany.xogame;
import java.lang.String;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to XO Game! Lets play..");
        Board board = new Board(3);
        Player[] players = new Player[2];

        players[0]= new Player(1,' ');


        if ( players[0].get_symbol() == 'x')
            players[1]=new Player(2,'o');
        else
            players[1]=new Player(2,'x');

        Game game = new Game(board,players);
        game.play_game();


    }
}