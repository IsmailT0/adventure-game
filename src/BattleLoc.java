public abstract class BattleLoc extends Location{
    protected Monster monster;
    BattleLoc(Player player,String name, Monster monster){
        this.player=player;
        this.name=name;
        this.monster= monster;
    }
    BattleLoc(){}


    @Override
    public boolean getLocation(){
        int mCount= monster.getMaxNumber();
        System.out.println("Now you are in " + this.getName());
        System.out.println("Be careful.  you may encounter " + mCount+" "+ monster.getName());
        System.out.println("Will you <R>un or <F>ight");
        String choice = scLoc.next();
        choice = choice.toUpperCase();
        if (choice.equals("F")){
            getPlayerStatus();
            getMonsterStatus();
            combat(monster.monsterCount());

        }
        return true;
    }

    private void getPlayerStatus(){
        System.out.println("Player status are :\nDamage: " +player.getDamage()+ "\nHealth: "+ player.getHealth());
    }

    private void getMonsterStatus(){
        System.out.println("Monster status are :\nDamage: " +monster.getDamage()+ "\nHealth: "+ monster.getHealth()
        +"\n Reward: " +monster.getAward());
    }

    private void combat(int mCount){
        int a =0;

        while (mCount > 0 ){
            while (monster.getHealth()>0 && player.getHealth()>0){
                player.setHealth(player.getHealth()-monster.getDamage());
                monster.setHealth(monster.getHealth()- player.getDamage());
            }
            if (monster.getHealth()<=0){
                a++;
                player.setMoney(player.getMoney()+monster.getAward());
                System.out.printf("You killed %d %s\n",a,monster.getName());
                getPlayerStatus();
                getMonsterStatus();
                System.out.println("Will you <R>un or <F>ight");
                String choice = scLoc.next();
                choice = choice.toUpperCase();
                if (choice.equals("R"))
                    break;
                mCount--;
            }
            if (player.getHealth()<=0) {
                System.out.println("You died");
                break;
            }
        }

    }

}
class Cave extends BattleLoc{
    Cave(Player player){
        super(player,"Cave",new Zombie());
    }
}

class Forest extends BattleLoc{
    Forest(Player player){
        super(player,"Forest",new Vampire());
    }
}

class River extends BattleLoc{
    River(Player player){
        super(player,"River",new Bear());
    }
}