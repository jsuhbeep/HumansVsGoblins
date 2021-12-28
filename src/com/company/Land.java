package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Land extends Main {

    int width;
    int height;
    int[][] board;
    static String fight = "\u2694";

    public Land(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void printBoard() {

        try{
            for (int y = 0; y < height; y++) {
                StringBuilder line = new StringBuilder("");
                for (int x = 0; x < width; x++) {
                    if (this.board[x][y] == 0) {
                        line.append("|     ");
                    } else if (this.board[x][y] == 2){
                        line.append("| " + Goblin.emoji + "  ");
                    } else if (this.board[x][y] == 3){
                        line.append("|  " + Land.fight + "  ");
                    } else {
                        line.append("| " + Human.emoji + "  ");
                    }
                }
                System.out.println(line);
            }
            System.out.println("\n");
        }catch (Exception e){
            System.out.println("Failed to print map.");
        }
    }

    public void setPlayer(int x, int y) {
        try{
            this.board[x][y] = 1;
        }catch (Exception e){
            System.out.println("Error setting player location.");
        }
    }

    public void setEnemy(int x, int y) {
        try{
            this.board[x][y] = 2;
        }catch (Exception e){
            System.out.println("Error setting goblin location.");
        }
    }

    public void setCombat(int x, int y){
        try{
            this.board[x][y] = 3;
        }catch (Exception e){
            System.out.println("Error setting combat location.");
        }
    }
}