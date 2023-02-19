package com.mycomany.xogame;
import java.util.Scanner;

public class Player {
    private final String name;
    private final char symbol;


    Player(int order, char symbol){
        System.out.print("Welcome player");
        if (order > 0) {
            System.out.println(" " + order);
        }
        System.out.print("Please enter your name: ");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();

        while(true){
            if(order == 2){
                System.out.println("Player 2 has symbol "+ symbol +"\n");
                this.symbol = symbol;
                break;
            }
            System.out.print("Please enter your symbol (small x or o):\n");
            Scanner in_symbol = new Scanner(System.in);
            symbol = in_symbol.next().charAt(0);
            if(symbol == 'x' || symbol == 'o'){
                this.symbol = symbol;
                break;
            }
        }
    }

    public String get_name() {
        return name;
    }

    public char get_symbol() {
        return symbol;
    }
}
