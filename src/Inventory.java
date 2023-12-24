import java.util.ArrayList;

public class Inventory {
    private String cWeaponName;//current weapon
    private String cArmorName;//current armor
    private boolean water,food,firewood;
    private int damage,protection;
    private int itemCount=0;
    private  ArrayList<Weapon> weaponList;
    private  ArrayList<Armor> armorList;

    Inventory(){
        cWeaponName="stick";
        cArmorName="nothing";
        damage=0;
        protection=0;
        water=false;
        firewood=false;
        food=false;
        armorList=new ArrayList<>();
        weaponList= new ArrayList<>();
    }





    public void addArmorList(Armor newArmor){
        armorList.add(newArmor);
        setProtection(newArmor.getArmorProtection());
        setcArmorName(newArmor.getArmorName());
    }
    public void addWeaponList(Weapon newWeapon){
        weaponList.add(newWeapon);
        setDamage(newWeapon.getWeaponDamage());
        setcWeaponName(newWeapon.getWeaponName());
    }



    public ArrayList<Armor> getArmorList() {return armorList;}

    public ArrayList<Weapon> getWeaponList() {return weaponList;}

    //Items

    public boolean isFirewood() {return firewood;}
    public void setFirewood(boolean firewood) {this.firewood = firewood;}

    public boolean isFood() {return food;}
    public void setFood(boolean food) {this.food = food; itemCount++; }

    public boolean isWater() {return water;}
    public void setWater(boolean water) {this.water = water;itemCount++;}
    // Armor and weapon buff
    public int getProtection() {return protection;}

    public void setProtection(int protection) {this.protection = protection;itemCount++;}

    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage = damage;}


    //set and get armor name and weapon name
    public String getcArmorName() {return cArmorName;}
    public void setcArmorName(String cArmorName) {this.cArmorName = cArmorName;}

    public String getcWeaponName() {return cWeaponName;}
    public void setcWeaponName(String cWeaponName) {this.cWeaponName = cWeaponName;}


    //toString
    public String toString(){
        String st ="";
        st+="Your weapon list :\n" +
                "Name\tDamage\n";
        if (weaponList.size()==0)
            st+=("you did not buy any weapon from market\n");
        for (int i =0;i< weaponList.size();i++){
            st += i+1;
            st +="- ";
            st+=weaponList.get(i).toString();
            st+="\n";
        }
        st+="Your armor list :\n" +
                "   Name\tProtection";
        if (armorList.size()==0)
            st+=("\nyou did not buy any armor from market\n");
        for (int i =0;i< armorList.size();i++){
            st += i;
            st +="- ";
            st+=armorList.get(i).toString();
            st+="\n";
        }
        st+="Items you collect:\n";
        if (itemCount!=0) {
            if (isFood()) {
                st += "food";
                st+="\n";
            }
            if (isFirewood())
                st+="firewood\n";
            if (isWater())
                st+="water\n";
        }else
            st+="You got nothing\n";
        st+="Your current weapon: "+getcWeaponName()+" "+getDamage();
        st+="\nYour current armor: "+getcArmorName()+ " "+getProtection();

        return st;
    }



}
