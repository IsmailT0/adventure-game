public abstract class NormalLoc extends Location {
    NormalLoc(Player player,String name){
        this.player=player;
        this.name=name;
    }
    NormalLoc(){}

    @Override
    public boolean getLocation(){
        return true;
    }

}



