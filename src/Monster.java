import java.util.Random;

public class Monster {
    private String name;
    private int damage,health,award;
    int maxNumber;

    Monster(String name,int damage,int health,int award,int maxNumber){
        this.name=name;
        this.damage=damage;
        this.health=health;
        this.award=award;
        this.maxNumber=maxNumber;
    }
    Monster(){}

    public int MonsterNumber(int min ,int max){
        Random rd = new Random();
        return rd.nextInt(min,max);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}


    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}


    public int getAward() {return award;}
    public void setAward(int award) {this.award = award;}


    public int getMaxNumber() {return maxNumber;}
    public void setMaxNumber(int maxNumber) {this.maxNumber = maxNumber;}
    public int monsterCount(){
        Random rd = new Random();
        return rd.nextInt(this.maxNumber)+1;
    }
}
class Zombie extends Monster{
    Zombie(){
        super("Zombie",3,10,4,3);
    }

}
class Vampire extends Monster{
    Vampire(){
        super("Vampire",4,14,7,3);
    }

}
class Bear extends Monster{
    Bear(){
        super("Bear",7,20,12,3);
    }

}