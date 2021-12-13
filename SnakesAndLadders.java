package SnakeAndLadder;
import java.util.*;
public class SnakesAndLadders {
        public static void main(String[] args){
        Dice dice = new Dice(1);
        Players A = new Players("Ram",1);
        Players B = new Players("Ravi",2);
        Players C = new Players("Siva",3);
        Players D = new Players("Kiran",4);
        Queue<Players> totalplayers = new LinkedList<>();
        totalplayers.offer(A);
        totalplayers.offer(B);
        totalplayers.offer(C);
        totalplayers.offer(D);
        JumpPosition s1 = new JumpPosition(27,2);
        JumpPosition s2 = new JumpPosition(99,18);
        List<JumpPosition> snakes = new ArrayList<>();
        snakes.add(s1);
        snakes.add(s2);
        JumpPosition l1 = new JumpPosition(21,92);
        JumpPosition l2 = new JumpPosition(54,86);
        List<JumpPosition> ladders = new ArrayList<>();
        ladders.add(l1);
        ladders.add(l2);
        Map<String,Integer> playerPosition =new HashMap();
        playerPosition.put("Ram",1);
        playerPosition.put("Ravi",1);
        playerPosition.put("Siva",1);
        playerPosition.put("Kiran",1);
        Game startPlay =new Game(dice,totalplayers,snakes,ladders,playerPosition,100);
      
        startPlay.startGame();
        




    }
    
}
