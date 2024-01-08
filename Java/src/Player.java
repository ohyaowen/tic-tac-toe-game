public class Player {
    String playerName;
    String playerSymbol;
    Boolean playerTurn;

    // Constructor
    public Player(String playerName, String playerSymbol, Boolean playerTurn){
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.playerTurn = playerTurn;
    }

    public Boolean getPlayerTurn() {
        return playerTurn;
    }
    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }
    public String getPlayerSymbol() {
        return playerSymbol;
    }
    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    
}
