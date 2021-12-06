package Day4;
import java.util.*;
import java.io.*;

public class four1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day4/smallInput.txt");
        File inputFile = new File("src/Day4/input.txt");
        Scanner kB = new Scanner(inputFile);
        String[] cO = kB.nextLine().split(",");
        int[] callOrder = new int[cO.length];
        for(int i = 0; i < cO.length; i++) {
          callOrder[i] = Integer.parseInt(cO[i]);
        }
        kB.nextLine();
        List<bingoBoard> boardList = new ArrayList<bingoBoard>(0);
        String multiLine = "";
        while(kB.hasNextLine()) {
          String nextLine = kB.nextLine();
          if(nextLine.equals("")) {
            boardList.add(new bingoBoard(multiLine,callOrder));
            multiLine = "";
          } else {
            multiLine += nextLine + "//";
          }
        }
        int lowestStepCount = 10000;
        int score = 0;
        for(bingoBoard testBoard : boardList) {
          if(testBoard.stepsToWin < lowestStepCount) {
            lowestStepCount = testBoard.stepsToWin;
            score = testBoard.score;
            //System.out.println(lowestStepCount);
            //testBoard.printBoard();
          }
          
        }
        System.out.println(score);
        System.out.println(boardList.size());
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}