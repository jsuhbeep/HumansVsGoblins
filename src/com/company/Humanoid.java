package com.company;

public class Humanoid {

    private String name;
    private int health, attack, level;

    public Humanoid() {

    }

    public String getName() {
        try{
            return name;
        }catch (Exception e){
            System.out.println("Error getting name.");
            return name;
        }
    }

    public void setName(String name) {
        try{
            this.name = name;
        }catch (Exception e){
            System.out.println("Error setting name.");
        }
    }

    public int getHealth() {
        try{
            return health;
        }catch (Exception e){
            System.out.println("Error getting health.");
            return -1;
        }
    }

    public void setHealth(int health) {
        try{
            this.health = health;
        }catch (Exception e){
            System.out.println("Error setting health.");
        }
    }

    public int getAttack() {
        try{
            return attack;
        }catch (Exception e){
            System.out.println("Error getting attack.");
            return -1;
        }
    }

    public void setAttack(int attack) {
        try{
            this.attack = attack;
        }catch (Exception e){
            System.out.println("Error setting attack.");
        }
    }

    public int getLevel(){
        try{
            return level;
        }catch (Exception e){
            System.out.println("Error getting level.");
            return -1;
        }
    }

    public void setLevel(int level){
        try{
            this.level = level;
        }catch (Exception e){
            System.out.println("Error setting level.");
        }
    }

    public void combat(Humanoid humanoid) {

        try{
            System.out.println(this.getName() + " and " + humanoid.getName() + " are now fighting!");
            System.out.println(this.getName() + " starts with " + this.getHealth() + " health.");
            System.out.println(humanoid.getName() + " starts with " + humanoid.getHealth() + " health.");

            while (humanoid.getHealth() > 0 && this.getHealth() > 0) {

                int thisAttack = (Random.random(2, 5) * (this.getAttack()));
                int defAttack = (Random.random(1, 3) * (humanoid.getAttack()));

                if(this.getHealth() > 0){
                    humanoid.setHealth(humanoid.getHealth() - thisAttack);
                    if (humanoid.getHealth() > 0) {
                        System.out.println(this.getName() + " attacked " + humanoid.getName() + " for " + thisAttack + " damage. "
                                + humanoid.getName()
                                + " now has " + humanoid.getHealth() + " health");
                    } else {
                        System.out.println(this.getName() + " attacked " + humanoid.getName() + " for " + thisAttack + " damage.");
                        System.out.println(humanoid.getName() + " has been slain.");
                        System.out.println(this.getName() + " has defeated " + humanoid.getName() + " in combat.");
                    }
                }
                if(humanoid.getHealth() > 0){
                    this.setHealth(this.getHealth() - defAttack);

                    if (humanoid.getHealth() > 0) {
                        System.out.println(humanoid.getName() + " attacked " + this.getName() + " for " + defAttack + " damage. "
                                + this.getName()
                                + " now has " + this.getHealth() + " health");
                    } else {
                        System.out.println(humanoid.getName() + " attacked " + this.getName() + " for " + defAttack + " damage.");
                        System.out.println(this.getName() + " has been slain.");
                        System.out.println(humanoid.getName() + " has defeated " + this.getName() + " in combat.");
                    }
                }
            }
            if (humanoid.getHealth() <= 0 || this.getHealth() <= 0) {
                if (humanoid.getHealth() <= 0) {
                    System.out.println(humanoid.getName() + " has been slain by " + this.getName() + ".");
                } else {
                    System.out.println(this.getName() + " has been slain by " + humanoid.getName() + ".");
                }
            }
        }catch (Exception e){
            System.out.println("Error with combat method.");
            System.out.println(e.getMessage());
        }
    }
}