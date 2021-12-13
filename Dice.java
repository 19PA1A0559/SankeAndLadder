package SnakeAndLadder;
public class Dice{
    private int dice;
    Dice(int dice){
        this.dice=dice;
    }
    int randomValue(){
        return ((int)(Math.random()*(dice*6 - dice)))+1;
        }
}
