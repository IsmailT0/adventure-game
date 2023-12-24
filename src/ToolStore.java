import java.util.ArrayList;

public class ToolStore extends NormalLoc{
    private ArrayList<Weapon> weapons;

    private ArrayList<Armor> armors;


    ToolStore(Player player){
        super(player,"Market");
        weapons = new ArrayList<>();
        armors = new ArrayList<>();


    }
    ToolStore(){}


    @Override
    public boolean getLocation() {
        menu();
        System.out.println();
        return true;
    }



    public void menu(){
        System.out.println("Welcome to store " + player.getName());
        System.out.println("Money you have: " +player.getMoney());
        System.out.println("What would you like to buy? ");
        System.out.println("1- Weapons\n2-Armors\n0- To exit");
        System.out.print("Your answer: ");
        int choice= scLoc.nextInt();
        while (choice<0 || choice>3){
            System.out.println("You enter a wrong decision. Be careful 0, 1 or 2");
            System.out.print("Your answer: ");
            choice= scLoc.nextInt();
        }
        switch (choice) {
            case 1 -> {
                int weaponId = weaponMenu();
                createWeaponList(weapons);
                if (weapons.get(weaponId-1).getCost()>player.getMoney())
                    System.out.println("you do not have enough money");
                else
                    buyWeapon(weaponId-1);


            }
            case 2 -> {
                int armorId = armorMenu();
                createArmorList(armors);
                if (armors.get(armorId-1).getCost()>player.getMoney())
                    System.out.println("you do not have enough money");
                else
                    buyArmor(armorId-1);
            }
        }


    }


    public void buyWeapon(int id){

        player.getInventory().addWeaponList(weapons.get(id));
        player.setDamage(getPlayer().getDamage()+weapons.get(id).getWeaponDamage());
        player.setMoney(getPlayer().getMoney()-weapons.get(id).getCost());
        System.out.println("Added your inventory and set as your current armor.");
    }

    public void buyArmor(int id){
        player.getInventory().addArmorList(armors.get(id));
        player.setHealth(getPlayer().getHealth()+armors.get(id).getArmorProtection());
        player.setMoney(getPlayer().getMoney()-armors.get(id).getCost());
        System.out.println("Added your inventory and set as your current weapon.");
    }

    public int armorMenu(){
        System.out.println("Choose your Armor:");
        System.out.println("ID      NAME    Protection   MONEY");
        System.out.println("1-     Light        1          15 ");
        System.out.println("2-     Middle       3          25 ");
        System.out.println("3-     Heavy        5          40 ");

        System.out.println("Enter armor id:");
        int ArmorId = scLoc.nextInt();

        while (ArmorId<1 || ArmorId>3){
            System.out.print("Enter a correct id: ");
            ArmorId=scLoc.nextInt();
        }
        return ArmorId;
    }
    public int weaponMenu(){
        System.out.println("Choose your weapon:");
        System.out.println("ID     NAME    DAMAGE   MONEY");
        System.out.println("1-    Pistol     2       25 ");
        System.out.println("2-    Sword      3       35 ");
        System.out.println("3-    Riffle     7       45 ");

        System.out.println("Enter weapon id:");
        int weaponId = scLoc.nextInt();

        while (weaponId<1 || weaponId>3){
            System.out.print("Enter a correct id: ");
            weaponId=scLoc.nextInt();
        }
        return weaponId;
    }
    public void createArmorList(ArrayList<Armor> ar){
        ar.add(new Armor(1,"Light",1,15));
        ar.add(new Armor(2,"Middle",3,25));
        ar.add(new Armor(3,"Heavy",5,40));
    }

    public void createWeaponList(ArrayList<Weapon> weapons){
        weapons.add(new Weapon(1,"Pistol",2,25));
        weapons.add(new Weapon(2,"Sword",3,35));
        weapons.add(new Weapon(3,"Riffle",7,45));
    }








}


class Weapon extends ToolStore{
    private String weaponName;
    private int weaponId;

    private int weaponDamage;
    private int cost;


    Weapon(int weaponId,String weaponName,int weaponDamage,int cost){
        this.weaponName=weaponName;
        this.weaponId=weaponId;
        this.weaponDamage=weaponDamage;
        this.cost=cost;

    }


    public String getWeaponName() {return weaponName;}
    public void setWeaponName(String weaponName) {this.weaponName = weaponName;}


    public int getWeaponId() {
        return weaponId;
    }
    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }


    public int getWeaponDamage() {return weaponDamage;}
    public void setWeaponDamage(int weaponDamage) {this.weaponDamage = weaponDamage;}


    public int getCost() {return cost;}
    public void setCost(int cost) {this.cost = cost;}


    @Override
    public String toString(){
        String st="";
        st+=getWeaponName();
        st+="\t";
        st+=getWeaponDamage();
        return st;
    }

}
class Armor extends ToolStore{
    private String armorName;
    private int armorId;
    private int armorProtection;
    private int cost;

    Armor(int armorId,String armorName,int armorProtection,int cost){
        this.armorName=armorName;
        this.armorId=armorId;
        this.armorProtection=armorProtection;
        this.cost=cost;
    }


    public String getArmorName() {return armorName;}
    public void setArmorName(String armorName) {this.armorName = armorName;}

    public int getArmorId() {return armorId;}
    public void setArmorId(int armorId) {this.armorId = armorId;}


    public int getArmorProtection() {return armorProtection;}
    public void setArmorProtection(int armorProtection) {this.armorProtection = armorProtection;}


    public int getCost() {return cost;}
    public void setCost(int cost) {this.cost = cost;}


    @Override
    public String toString(){
        return  getArmorName() + "\t" + getArmorProtection();
    }

}




