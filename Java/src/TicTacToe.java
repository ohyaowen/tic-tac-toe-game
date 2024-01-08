import java.util.List;

public class TicTacToe {

    public static void main (String[]args){
        System.out.println("Welcome to Tic Tac Toe Game");
        List<Player> playerList = InitGame.initPlayer();
        GamePlay.startGame(playerList);
    }

}
