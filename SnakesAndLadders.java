package SnakeAndLadder;
import java.util.*;
public class SnakesAndLadders {
        public static void main(String[] args){
            Scanner ob = new Scanner(System.in);
            System.out.print("Enter No of Dice : ");
            int noOfDice = ob.nextInt();
            Dice dice = new Dice(noOfDice);
            System.out.print("Enter No of Players : ");
            int playerSize=ob.nextInt();
            String[] playersList = new String[playerSize];
            int[] idList = new int[playerSize];
            Queue<Players> totalplayers = new LinkedList<>();
            List<JumpPosition> snakes = new ArrayList<>();
            List<JumpPosition> ladders = new ArrayList<>();
            for (int i=0;i<playerSize;i++){
                System.out.print("Enter Player id :");
                idList[i]=ob.nextInt();
                System.out.print("Enter Player Name :");
                playersList[i]=ob.next();
                Players x = new Players(playersList[i],idList[i]);
                totalplayers.offer(x);
            }
            System.out.print("Enter No of Snake jumps:");
            int noOfSnakes=ob.nextInt();
            int[] sstart = new int[noOfSnakes];
            int[] send = new int[noOfSnakes];
            for (int j=0;j<noOfSnakes;j++){
                System.out.print("snake head :");
                sstart[j]=ob.nextInt();
                System.out.print("snake tail:");
                send[j]=ob.nextInt();
                JumpPosition s = new JumpPosition( sstart[j],send[j]);
                snakes.add(s);
            }
            System.out.print("Enter No of Ladder jumps:");
            int noOfLadders=ob.nextInt();
            int[] lstart = new int[noOfLadders];
            int[] lend = new int[noOfLadders];
            for (int k=0;k<noOfLadders;k++){
                System.out.print("ladder tail :");
                lstart[k]=ob.nextInt();
                System.out.print("ladder head:");
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
