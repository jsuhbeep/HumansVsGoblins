package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean playAgain = true;

        Scanner nameInput = new Scanner(System.in);
        System.out.println("What is your name?");
        String setName = nameInput.nextLine().trim();

        Human player = new Human(setName);

        while (playAgain) {
            Land newLand = new Land(8, 8);

            ArrayList<String> goblins = new ArrayList<>();

            goblins.add("Mees");
            goblins.add("Vex");
            goblins.add("Zatgald");
            goblins.add("Ynel");
            goblins.add("Foxa");
            goblins.add("Bibelma");
            goblins.add("Groggo");

            if (player.getHealth() < 40) {
                if (player.inventory.contains("Health potion")) {
                    player.setHealth(player.getHealth() + 50);
                    player.inventory.remove("Health potion");
                    System.out.println("You use a health potion to restore 50 health. You now have " + player.getHealth() + " health.");
                }
            }
            player.setAttack(8 + 2 * (player.getLevel() -1 ));

            int random = Random.random(0, (goblins.size() - 1));

            Goblin goblin = new Goblin(goblins.get(random));
            goblin.setLevel(player.getLevel());
            goblin.setHealth(200 + (goblin.getLevel()-1) * 50);
            goblin.setAttack(5 + (goblin.getLevel()-1) * 1);

            System.out.println(goblin);
            System.out.println(player);

            int g1 = 6;
            int g2 = Random.random(0, 7);
            int h1 = 0;
            int h2 = Random.random(0, 7);

            System.out.println(goblin.getName() + " begins on 'x': " + (g1 + 1) + " 'y': " + (g2 + 1) + ".");
            System.out.println(player.getName() + " begins on 'x': " + (h1 + 1) + " 'y': " + (h2 + 1) + ".");

            newLand.setPlayer(h1, h2);
            newLand.setEnemy(g1, g2);
            newLand.printBoard();

            while ((!Objects.equals(g1, h1)) || (!Objects.equals(g2, h2))) {
                Land land = new Land(8, 8);
                Land combat = new Land(8, 8);

                if (player.getHealth() < (100 + (player.getLevel()-1) * 10)) {

                    player.setHealth((int) (player.getHealth() * 1.2));
                    if (player.getHealth() > 100 + (player.getLevel()-1) * 10){
                        player.setHealth(100+ (player.getLevel()-1) * 10);
                    }
                    if (player.getHealth() >= ((100 + player.getLevel()-1) * 10)) {
                        System.out.println(player.getName() + " is now at full health.");
                    } else if (player.getHealth() < (100 + (player.getLevel()-1) * 10)){
                        System.out.println(player.getName() + " regains " + ((int) (player.getHealth() * .2)) + " health, and now has "
                                + player.getHealth() + " health.");
                    } else {
                        System.out.println(player.getName() + " regains the rest of their health, and now has "
                                + player.getHealth() + " health.");
                    }
                }

                if (player.getHealth() > (100 + (player.getLevel()-1) * 10)) {
                    player.setHealth(100 + (player.getLevel()-1) * 10);
                }

                Scanner getInput = new Scanner(System.in);
                System.out.println("Enter 'f' if you are near an enemy to initiate combat.");
                System.out.println("Choose a direction: North (w), East (a), South (s), or West (d).");
                System.out.println("Tip: You regenerate health out of combat. Sometimes it is better to keep running.");
                String playerInput = getInput.nextLine();

                if (!Objects.equals(g1, h1)) {
                    if (g1 > h1) {
                        g1 = g1 - 1;
                    } else {
                        g1 = g1 + 1;
                    }
                } else {
                    if (g2 > h2) {
                        g2 = g2 - 1;
                    } else {
                        g2 = g2 + 1;
                    }
                }

                if (Objects.equals(playerInput, "a") || Objects.equals(playerInput, "d")) {
                    if (playerInput.equals("a")) {
                        h1 = h1 - 1;
                    } else {
                        h1 = h1 + 1;
                    }
                } else if (Objects.equals(playerInput, "w") || Objects.equals(playerInput, "s")) {
                    if (playerInput.equals("w")) {
                        h2 = h2 - 1;
                    } else {
                        h2 = h2 + 1;
                    }
                } else if (playerInput.equals("f")) {
                    System.out.println("There is no enemy nearby. The enemy moves closer.");
                } else {
                    System.out.println("Invalid choice. The enemy moves closer.");
                }

                System.out.println(goblin.getName() + " moves to 'x': " + (g1 + 1) + " 'y': " + (g2 + 1) + ".");
                System.out.println(player.getName() + " moves to 'x': " + (h1 + 1) + " 'y': " + (h2 + 1) + ".");

                if (!Objects.equals(h1, g1) || !Objects.equals(h2, g2)) {
                    land.setPlayer(h1, h2);
                    land.setEnemy(g1, g2);
                    land.printBoard();
                } else if (Objects.equals(h1, g1) && Objects.equals(h2, g2)) {
                    combat.setCombat(h1, h2);
                    combat.printBoard();
                }
            }
            player.combat(goblin);

            if (player.getHealth() <= 0) {
                System.out.println("Oh no! You have lost to the goblins.");
                break;
            }

            if (!goblin.inventory.contains("Empty")) {
                if (player.inventory.contains("Empty")) {
                    player.inventory.remove(0);
                    player.inventory.add(goblin.inventory.get(0));

                    System.out.println(goblin.getName() + " drops a " + goblin.inventory.get(0) + ".");
                    System.out.println("You pick it up and place it in your bag.");
                } else {
                    System.out.println(goblin.getName() + " drops nothing useful.");
                }
            }
                System.out.println("Congratulations! You gained a level.");
                player.setLevel(player.getLevel() + 1);
                System.out.println("You are now level " + player.getLevel() + "!");
                System.out.println("You feel stronger, gaining 2 attack and 10  max health.");

                Scanner keepPlaying = new Scanner(System.in);
                System.out.println("Would you like to continue playing? (y or n)");
                String again = keepPlaying.nextLine();

                if (Objects.equals(again, "n")) {
                    playAgain = false;
                } else if (!Objects.equals(again, "y")) {
                    System.out.println("That was not an option. The game will not continue.");
                    playAgain = false;
            }
        }
    }
}