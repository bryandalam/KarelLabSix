
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        findBeepers();
        countBeepers();
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
        }
    public void findBeepers() {
        faceEast();
        while (!nextToABeeper()) {
            move();
        }
        faceNorth();
    }
    public void countBeepers() {
        while (nextToABeeper()) {
            pickBeeper();
            tempCount++;
            move();
            if (!nextToABeeper()) {
                returnToBottom();
            }
        }
    }
    public void returnToBottom() {
        faceSouth();
        while (frontIsClear()) {
            move();
        }
    }
    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }
    public void faceSouth() {
        while (!facingSouth()) {
            turnLeft();
        }
    }
    public void faceEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }
    
    
   
}

