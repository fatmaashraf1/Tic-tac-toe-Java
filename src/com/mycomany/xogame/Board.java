package com.mycomany.xogame;
import java.util.Arrays;

public class Board {
    protected int n;
    protected int moves = 0;
    protected char[][] grid;

    Board(int n){
        this.n = n;
        this.grid = new char[n][n];
        for (char[] chars : grid) {
            Arrays.fill(chars, ' ');
        }
    }
    public void display_board(){

        System.out.println("\n--1--2--3--");
        for (char[] chars : grid) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print("| " + chars[j]);
                if (j == chars.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("\n----------");
        }
    }

    public boolean update_board(int x,int y, char symbol){
        if (!(x < 0 || x > 2 || y < 0 || y > 2) && (grid[x][y] == ' ')) {
            grid[x][y] = symbol;
            moves++;
            return true;
        }
        return false;
    }

    public boolean is_winner(char symbol){
        // Check For rows
        for (int row = 0; row < 3; row++) {
            int count = 0;
            for (int col = 0; col < 3; col++) {
                if(grid[row][col] == symbol){
                    count++;
                }
                if(count == 3)
                    return true;
            }
        }

        // Check For Columns
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (grid[row][col] == symbol) {
                    count++;
                }
                if (count == 3)
                    return true;
            }
        }

        // For Diagonals
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
                (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    public boolean is_draw(){
        return ((moves == 8 && !is_winner('x')) ||(moves == 8 && !is_winner('o')));
    }

}
