package com.company;

import java.util.ArrayList;

public class Human extends Humanoid{
    ArrayList<String> inventory;
    public static String emoji = "\uD83D\uDC68";

    public Human(String name){
        try {
            setName(name);
            setLevel(1);
            setHealth(100 + 10 * (this.getLevel()-1));
            setAttack(8 + 2 * (this.getLevel()-1));
            inventory = new ArrayList<>();
            inventory.add("Empty");
        }catch (Exception e){
            System.out.println("Error constructing human.");
        }
    }

    @Override
    public String toString(){
        try{
            return "Human: {" +
                    " Name: " + this.getName() +
                    ", Level: " + this.getLevel() +
                    ", Health: " + this.getHealth() +
                    ", Attack: " + this.getAttack() +
                    ", Inventory: " + this.inventory +
                    "}";
        }catch (Exception e){
            return "Error printing human stats.";
        }
    }
}