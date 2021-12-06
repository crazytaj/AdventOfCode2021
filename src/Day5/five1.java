package Day5;
import java.util.*;
import java.io.*;

public class five1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day5/smallInput.txt");
        //int gridSize = 10;
        File inputFile = new File("src/Day5/input.txt");
        int gridSize = 1000;
        Scanner kB = new Scanner(inputFile);
        int[][] board = new int[gridSize][gridSize];
        for(int i = 0; i < gridSize; i++) {
          for(int j = 0; j < gridSize; j++) {
            board[i][j] = 0;
          }
        }
        while(kB.hasNextLine()) {
          String[] nextLine = kB.nextLine().split(" -> ");
          int[] sPoint = Arrays.stream(nextLine[0].split(",")).mapToInt(Integer::parseInt).toArray();
          int[] ePoint = Arrays.stream(nextLine[1].split(",")).mapToInt(Integer::parseInt).toArray();
          System.out.println(sPoint[0]+","+sPoint[1]+" -> "+ePoint[0]+","+ePoint[1]);
          if(sPoint[0] == ePoint[0]) {
            int scaleFactor = (ePoint[1]-sPoint[1] >= 0) ? 1 : -1;
            for(int i = sPoint[1]; i != ePoint[1]+scaleFactor;i += scaleFactor) {
              board[i][sPoint[0]] += 1;
            }
          } else if(sPoint[1] == ePoint[1]) {
            //System.out.println(sPoint[0]+ " " + ePoint[0]);
            int scaleFactor = (ePoint[0]-sPoint[0] >= 0) ? 1 : -1;
            for(int i = sPoint[0]; i != ePoint[0]+scaleFactor;i += scaleFactor) {
              board[sPoint[1]][i] += 1;
            }
          }
        }
        int pointTotal = 0;
        for(int i = 0; i < gridSize; i++) {
          for(int j = 0; j < gridSize; j++) {
            System.out.print(board[i][j]+" ");
            if(board[i][j] > 1) pointTotal += 1;
          }
          System.out.println();
        }
        System.out.print(pointTotal);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}