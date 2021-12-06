package Day2;
import java.util.*;
import java.io.*;

public class two1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day2/smallInput.txt");
        File inputFile = new File("src/Day2/input.txt");
        Scanner kB = new Scanner(inputFile);
        int depth = 0;
        int width = 0;
        while(kB.hasNextLine()) {
          String[] nextLine = kB.nextLine().split(" ");
          switch(nextLine[0]) {
            case("forward"):
              width += Integer.parseInt(nextLine[1]);
            break;
            case("down"):
              depth += Integer.parseInt(nextLine[1]);
            break;
            case("up"):
              depth -= Integer.parseInt(nextLine[1]);
            break;
          }
        }
        System.out.println(width*depth);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}