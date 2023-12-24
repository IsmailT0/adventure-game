public class SafeHouse extends NormalLoc{
    SafeHouse(Player player){
        super(player ,"Safe House");
    }

    @Override
    public boolean getLocation(){
        player.setHealth(player.getrHealth());
        System.out.println("You came to SAFE HOUSE. You are in safe now");
        System.out.println("Your wounds have been healed");
        System.out.println("Would you like to see your inventory? if you want enter 1");
        int choice= scLoc.nextInt();
        if (choice==1)
            System.out.println(player.getInventory().toString());
        System.out.println(player.getInventory().getWeaponList());

        return true;
    }

}