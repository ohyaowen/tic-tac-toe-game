import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitGame {
    public static List<Player> initPlayer(){
        Scanner userInput = new Scanner(System.in);
        int numOfPlayers = 2;
        int counter = 1;
        List<Player> playerList = new ArrayList<>();
        while(counter <= numOfPlayers){
            System.out.print("Please enter player " + counter + " name: ");
            String userName = userInput.nextLine();
            if(userName.length() == 0){
                System.out.println("Invalid input... Please try again.");
            }else{
                Player player = new Player(userName, "O", false);
                player.setPlayerName(userName);
                if(playerList.size() == 0 ){
                    String symbol = null; 
                    System.out.println("Please indicate if your prefer O or X as your symbol.");
                    symbol = userInput.nextLine().toUpperCase();
                    if(!symbolValidator(symbol)){
                        do{ 
                        System.out.println("Invalid Input. Please indicate if your prefer O or X as your symbol.");
                        symbol = userInput.nextLine().toUpperCase();
                        }while(!symbolValidator(symbol));
                    }
                    player.setPlayerSymbol(symbol);
                    playerList.add(player);
                }else{
                  System.out.println(playerList.get(0).playerName + " chose the symbol: " + playerList.get(0).playerSymbol);
                  if(playerList.get(0).playerSymbol.equals("X")){
                    player.setPlayerSymbol("O");
                  }else{
                    player.setPlayerSymbol("X");
                  }
                  System.out.println("Therefore your symbol will be: " + player.playerSymbol); 
                  playerList.add(player);
                }
                counter ++;
            }
        }
        System.out.println("Which player will start first? " + playerList.get(0).getPlayerName() + " or " + playerList.get(1).getPlayerName() + " ?");
        String name = userInput.nextLine();
        if(!playerList.get(0).getPlayerName().toLowerCase().equals(name.toLowerCase()) && !playerList.get(1).getPlayerName().toLowerCase().equals(name.toLowerCase())){
            do{
                System.out.println("You have entered an invalid player name. Please try again.");
                System.out.println("Which player will start first? " + playerList.get(0).getPlayerName() + " or " + playerList.get(1).getPlayerName() + " ?");
                name = userInput.nextLine();
            }while(!(playerList.get(0).getPlayerName().toLowerCase().equals(name.toLowerCase()) || (playerList.get(1).getPlayerName().toLowerCase().equals(name.toLowerCase())))); 
        }
        for(int x=0; x<playerList.size(); x++){
            if(playerList.get(x).playerName.toLowerCase().equals(name.toLowerCase())){
                playerList.get(x).playerTurn = true;
            }
        }
        return playerList;
    }
    
    public static boolean symbolValidator(String symbol){
        return symbol.matches("[XO]");
    }
}
