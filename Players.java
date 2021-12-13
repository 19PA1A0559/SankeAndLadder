package SnakeAndLadder;
public  class Players {
    private String playerName; 
    private int id ;
    Players(String playerName,int id){
        this.playerName=playerName;
        this.id =id;
    }
    public String getPlayerName(){
        return playerName;
    }
}
