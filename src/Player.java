import java.util.Scanner;

public class Player {

    private int rHealth;
    private int id;
    private int damage;
    private int health;
    private int money;
    private String name;
    private Inventory inventory;
    Scanner sc = new Scanner(System.in);

    Player(){}

    Player(String name){
        this.name=name;
        this.inventory= new Inventory();
    }

    public void selectCha(){
        int id = chaMenu();
        switch (id) {
            case 1 -> initPlayer("Samurai",5,21,15);
            case 2 -> initPlayer("Archer",7,18,20);
            case 3 -> initPlayer("Knight",8,24,5);
        }
        System.out.println("Your character is ready to fight.");

    }

    public int chaMenu(){
        System.out.println("Choose your character:");
        System.out.println("ID   NAME    DAMAGE     HEALTH   MONEY");
        System.out.println("1-  Samurai    5          21       15 ");
        System.out.println("2-  Archer     7          18       20 ");
        System.out.println("3-  Knight     8          24        5 ");

        System.out.print("Enter your characters id: ");
        int id =sc.nextInt();

        while (id<1 || id>3){
            System.out.print("Enter a correct id: ");
            id=sc.nextInt();
        }
        return id;
    }

    private void initPlayer(String name,int damage,int health,int money){
        setName(name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setrHealth(getHealth());
    }



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {return id;}


    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}


    public int getHealth() {return health;}
    public void setHealth(int health) {
        this.health = health;
    }


    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name + " " +this.name;}

    public int getrHealth() {return rHealth;}

    public void setrHealth(int rHealth) {this.rHealth = rHealth;}

    public Inventory getInventory() {return inventory;}

    public void setInventory(Inventory inventory) {this.inventory = inventory;}

    @Override
    public String toString(){
        return getName()+ " "+getDamage()+" "+getHealth()+" "+getMoney();
    }


}