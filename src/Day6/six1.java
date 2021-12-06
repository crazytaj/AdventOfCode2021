package Day6;
import java.util.*;
import java.io.*;

public class six1 {
    public static void main(String args[]) {
      try {
        File inputFile = new File("src/Day6/smallInput.txt");
        //File inputFile = new File("src/Day6/input.txt");
        Scanner kB = new Scanner(inputFile);
        while(kB.hasNextLine()) {
        }
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}