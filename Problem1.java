
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    int[] beeperStack = new int[8];
    int beepers;
    int i;
    int tempVar;
    public void sortBeepers() {
        startingPosition();
        calculateBeepers();
        restackBeepers();
    }
    public void startingPosition() {
        faceWest();
        while (frontIsClear()) {
            move();
        }
        faceSouth();
        while (frontIsClear()) {
            move();
        }
    }
    public void calculateBeepers() {
        faceNorth();
        while (nextToABeeper()) {
            pickBeeper();
            beepers++;
            move();
        }
        beeperStack[i] = beepers;
        rePosition();
    }
    public void rePosition() {
        faceSouth();
        beepers = 0;
        i++;
        while(frontIsClear()) {
            move();
        }
        if (!frontIsClear()) {
            turnLeft();
            move();
            if (!nextToABeeper()) {
                sortBeeper();
            }
            calculateBeepers();
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
    public void sortBeeper() {
        startingPosition();
        faceNorth();
        leastToGreatest();
     }
    public void leastToGreatest() {
        for(int i=0; i < beeperStack.length; i++) {
         System.out.print(beeperStack[i] + " ");
        }
       }
    public void restackBeepers() {
        for (int i = 0; i < beeperStack.length; i++) {
            beeperStack[i + 1] = tempVar;
            if (beeperStack[i] > tempVar) {
                beeperStack[i] = tempVar;
            }
            if (beeperStack[i] < tempVar) {
                tempVar = beeperStack[i + 2];
            }
        }
        
    }
    public void faceWest() {
        while (!facingWest()) {
            turnLeft();
        }
    }
         
   
}

