import java.util.List;
import java.util.Scanner;

public class GamePlay {

    static String [][] cellValue = new String[3][3];
    static int moveCounter = 0; 

    public static void startGame(List<Player> playerList){
        initCell();
        printMap();
        while(moveCounter<9){
            promptMove(playerList);
            printMap();
            moveCounter ++;
            if(moveCounter > 4){
                // After more than 5 moves, check if there is any winner
                System.out.println("Checking if there is a winner");
                if(checkForWinner()){
                    // If winner is found, print the winner name
                    System.out.println("Congratulations " + playerTurn(playerList) + ", you have won the game!");
                    break;
                }
            }
            changeTurn(playerList);
        }
        System.out.println("Game Ended");
    }
    // Initialize the cells
    public static void initCell(){
        for(int x=0; x<cellValue.length; x++){
            for(int y=0; y<cellValue.length; y++){
                cellValue[x][y] = " ";
            }
        }
    }

    // Determine which player's turn
    public static String playerTurn(List<Player> playerList){
        if(playerList.get(0).playerTurn == true){
            return playerList.get(0).playerName;
        }else{
            return playerList.get(1).playerName;
        }
    }

    // Determine the player's symbol
    public static String getPlayerSymbol(List<Player> playerList, String playerName){
        for(int x=0; x<playerList.size(); x++){
            if(playerList.get(x).playerName.equals(playerName)){
                return playerList.get(x).playerSymbol;
            }
        }
        return "null";
    }

    // Change player turn after each move
    public static void changeTurn(List<Player> playerList){
        for(int x=0; x<playerList.size(); x++){
            playerList.get(x).setPlayerTurn(!playerList.get(x).getPlayerTurn());
        }
    }
    
    // Prompting the player for their moves
    public static void promptMove(List<Player> playerList){
        Scanner userInput = new Scanner(System.in); 
        String playerName = playerTurn(playerList);
        String playerSymbol = getPlayerSymbol(playerList, playerName);
        System.out.println("Hi " + playerName + ". Please indicate where you would like to place in this format x,y: ");
        System.out.println("Note: The valid range will be between 0 to 2.");

        String move = userInput.nextLine();
        if(validateMoveInput(move, playerSymbol) == false){
            do{
                System.out.println("You have entered an invalid coordinate, please try again.");
                move = userInput.nextLine();
            }while(!validateMoveInput(move, playerSymbol));
        }else{
            
            
        }

    }

    // Validating their move input is not occupied, if it is not insert their move
    public static Boolean validateMove(int x, int y, String playerSymbol){
        if(cellValue[x][y] != " "){
            System.out.println("The cell " + x + "," + y + " is taken.");
            return false;
        }else{
            cellValue[x][y] = playerSymbol;
            return true;
        }
    }
    // Validating their move input
    public static Boolean validateMoveInput(String move, String playerSymbol){
        move = move.replaceAll("\\s", ""); 
        String[] values = move.split(",");

        if(values.length != 2){
            return false;
        }else{
            if(values[0].matches(".*\\D.*") || values[1].matches(".*\\D.*") ){
                return false;
            }
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            if((x < 3 && x >= 0) && (y < 3 && y >= 0)){
                return validateMove(x,y, playerSymbol);
            }
            else return false;
        }
    }

    // Check for winners
    public static Boolean checkForWinner(){
        String holdingSymbol = null;
        
        // Check Horizontal Row 
        for(int x=0; x<3; x++){
            if(cellValue[x][0] == " "){
                // no point checking that particular row
            }else{
                // Get the symbol
                holdingSymbol = cellValue[x][0];
                // Iterate through y 
                for(int y=0; y<3; y++){
                    if(holdingSymbol != cellValue[x][y]){break;}
                    else{if(y==2) return true;}
                }
            }
        }
        // Check Vertical Row
        for(int y=0; y<3; y++){
            if(cellValue[0][y]== " "){
                // no point checking that particular column
            }else{
                // Get the symbol
                holdingSymbol = cellValue[0][y];
                // Iterate through x
                for(int x=0; x<3; x++){
                    if(holdingSymbol != cellValue[x][y]){break;}
                    else{if(x==2) return true;}
                }
            }
        }
        // Check for Horizontal Matches
        if(cellValue[0][0].equals(cellValue[1][1]) && cellValue[1][1].equals(cellValue[2][2])){
            return true;
        }
        if(cellValue[0][2].equals(cellValue[1][1]) && cellValue[1][1].equals(cellValue[2][0])){
            return true;
        }
        return false;
    }

    // Printing the map
    private static void printMap(){
        System.out.println("=== Tic Tac Toe ===");
        System.out.println("     |     |     ");
        System.out.println("  " + cellValue[0][0] + "  |  " + cellValue[0][1] + "  |  " + cellValue[0][2] + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + cellValue[1][0] + "  |  " + cellValue[1][1] + "  |  " + cellValue[1][2] + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + cellValue[2][0] + "  |  " + cellValue[2][1] + "  |  " + cellValue[2][2] + "  ");
        System.out.println("     |     |     ");
        System.out.println("=== Tic Tac Toe ===");

    }
}
