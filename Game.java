package SnakeAndLadder;
import java.util.*;
public class Game {
    private Dice dice;
    private Queue<Players> nextTurn;
    private List<JumpPosition> snakes;
    private List<JumpPosition> ladders;
    private Map<String,Integer> playerPosition;
    int boardSize;
    public Game(Dice dice,Queue<Players> nextTurn,List<JumpPosition> snakes,List<JumpPosition> ladders, Map<String,Integer> playerPosition,
    int boardSize){
        this.dice=dice;
        this.nextTurn=nextTurn;
        this.snakes=snakes;
        this.ladders=ladders;
        this.playerPosition=playerPosition;
        this.boardSize=boardSize;
    }
    void startGame()
    {
        for (Map.Entry<String,Integer> initialplayerPosition : playerPosition.entrySet() ){
            System.out.println(initialplayerPosition.getKey()+" is at "+initialplayerPosition.getValue());
        }
    
    while(nextTurn.size()>1){
        Players player = nextTurn.poll();
        int currentPosition = playerPosition.get(player.getPlayerName());
        int diceValue = dice.randomValue();
        int nextPosition=currentPosition + diceValue;
        if(nextPosition>boardSize){
            nextTurn.offer(player);

        }
        else if (nextPosition==boardSize){
            System.out.println(player.getPlayerName()+" won the game");
        }
  
        else{
                int[] nextposition = new int[1];
                boolean[] snakeOrLadder = new boolean[1];
                nextposition[0]=nextPosition;
                snakes.forEach(s->{
                    if(s.currentPosition==nextPosition){
                        nextposition[0]=s.jumpPosition;
                        
                   }
                 });
                if(nextposition[0]!=nextPosition){
                    System.out.println(player.getPlayerName()+" bitten by snake ");
                }
                ladders.forEach(l->{
                    if(l.currentPosition==nextPosition){
                        nextposition[0]=l.jumpPosition;
                        snakeOrLadder[0]=true;
                    }
                });
                if(nextposition[0]!=nextPosition && snakeOrLadder[0]){
                    System.out.println(player.getPlayerName()+" climbed on ladder ");
                    }
                
                if(nextposition[0]==boardSize){
                    System.out.println(player.getPlayerName()+" won the game");

                }
                else{
                    playerPosition.put(player.getPlayerName(),nextposition[0]);
                    System.out.println(player.getPlayerName()+" is at position "+playerPosition.get(player.getPlayerName()));
                    nextTurn.offer(player);

                }
            }
        }
    }
}

