import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;



    Scanner sc = new Scanner(System.in);
    public void start(){
        login();
        while (player.getHealth()>0){
            mainMenu();
            int locChoice= sc.nextInt();
            while(locChoice<0 || locChoice>5){
                System.out.println("Wrong entry. Please select a correct place to go.");
                locChoice=sc.nextInt();
            }
            switch (locChoice) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new ToolStore(player);
                default -> location = new SafeHouse(player);
            }
            if (!location.getLocation()){
                System.out.println("Game over.");
                break;
            }
        }
    }

    public void login(){
        System.out.println("---Welcome to Adventure Game---");
        System.out.print("Please enter your name warrior: ");
        String playerName=sc.next();
        player = new Player(playerName);
        player.selectCha();
    }
    
    public void mainMenu(){
        System.out.println("1- Safe House ---> Your health will be renewed");
        System.out.println("2- Cave ----> You may encounter zombies");
        System.out.println("3- Forest ---> You may encounter vampires");
        System.out.println("4- River ---> You may encounter bears");
        System.out.println("5- Market ---> You can buy weapon and armor");
        System.out.print("Where would you like to go:");
    }


}
