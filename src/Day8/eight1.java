package Day8;
import java.util.*;
import java.io.*;

public class eight1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day8/smallInput.txt");
        File inputFile = new File("src/Day8/input.txt");
        Scanner kB = new Scanner(inputFile);
        int count = 0;
        while(kB.hasNextLine()) {
            String[] nextLine = kB.nextLine().split(" \\| ")[1].split(" ");
            for(int i = 0; i < nextLine.length; i++) {
                //System.out.println(nextLine[i]);
                switch(nextLine[i].length()) {
                    case 2:
                        count += 1;
                    break;
                    case 3:
                        count += 1;
                    break;
                    case 4:
                        count += 1;
                    break;
                    case 7:
                        count += 1;
                    break;
                }
            }

        }

        System.out.println(count);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}