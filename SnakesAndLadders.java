package SnakeAndLadder;
import java.util.*;
public class SnakesAndLadders {
        public static void main(String[] args){
            Scanner ob = new Scanner(System.in);
            int noOfDice = ob.nextInt();
            Dice dice = new Dice(noOfDice);
            int playerSize=ob.nextInt();
            String[] playersList = new String[playerSize];
            int[] idList = new int[playerSize];
            Queue<Players> totalplayers = new LinkedList<>();
            List<JumpPosition> snakes = new ArrayList<>();
            List<JumpPosition> ladders = new ArrayList<>();
            for (int i=0;i<playerSize;i++){
                idList[i]=ob.nextInt();
                playersList[i]=ob.next();
                Players x = new Players(playersList[i],idList[i]);
                totalplayers.offer(x);
            }
            int noOfSnakes=ob.nextInt();
            int[] sstart = new int[noOfSnakes];
            int[] send = new int[noOfSnakes];
            for (int j=0;j<noOfSnakes;j++){
                sstart[j]=ob.nextInt();
                send[j]=ob.nextInt();
                JumpPosition s = new JumpPosition( sstart[j],send[j]);
                snakes.add(s);
            }
            
            int noOfLadders=ob.nextInt();
            int[] lstart = new int[noOfLadders];
            int[] lend = new int[noOfLadders];
            for (int k=0;k<noOfLadders;k++){
                lstart[k]=ob.nextInt();
                lend[k]=ob.nextInt();
                JumpPosition jp = new JumpPosition(lstart[k],lend[k]);
                ladders.add(jp);
             }
            
            Map<String,Integer> playerPosition =new HashMap<>();
            for (int n=0;n<playerSize;n++){
                playerPosition.put(playersList[n],1);
                
        }
            Game startPlay =new Game(dice,totalplayers,snakes,ladders,playerPosition,100);
            ob.close();

        
            startPlay.startGame();
        }
    
}
