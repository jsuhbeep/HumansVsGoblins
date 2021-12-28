package com.company;

import java.util.ArrayList;

public class Goblin extends Humanoid{

    ArrayList<String> loot;
    ArrayList<String> inventory;
    public static String emoji = "\uD83D\uDC7A";

    public Goblin(String name){
        try{
            setName(name);
            setHealth(200);
            setAttack(5);

            loot = new ArrayList<>();
            inventory = new ArrayList<>();

            loot.add("Health potion");
            loot.add("Empty");

            int num = Random.random(0, (loot.size() - 1));

            inventory.add(loot.get(num));
        }catch (Exception e){
            System.out.println("Error constructing goblin.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        try{
            return "Goblin: {" +
                    " Name: " + this.getName() +
                    ", Level: " + this.getLevel() +
                    ", Health: " + this.getHealth() +
                    ", Attack: " + this.getAttack() +
                    "}";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Failed to print goblin stats.";

        }
    }
}