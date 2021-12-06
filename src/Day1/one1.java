package Day1;
import java.util.*;
import java.io.*;

public class one1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day1/smallInput.txt");
        File inputFile = new File("src/Day1/input.txt");
        Scanner kB = new Scanner(inputFile);
        int prevNum = 0;
        int count = -1;
        while(kB.hasNextLine()) {
          int newNum = kB.nextInt();
          if(newNum > prevNum) {
            count++;
          }
          prevNum = newNum;
        }
        System.out.println(count);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}