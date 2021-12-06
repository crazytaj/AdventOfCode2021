package Day3;
import java.util.*;
import java.io.*;

public class three1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day3/smallInput.txt");
        //int binarySize = 5;
        File inputFile = new File("src/Day3/input.txt");
        int binarySize = 12;
        Scanner kB = new Scanner(inputFile);
        int[] ones = new int[binarySize];
        int[] zeroes = new int[binarySize];
        while(kB.hasNextLine()) {
          char[] nextLine = kB.nextLine().toCharArray();
          for(int i = 0; i < nextLine.length; i++) {
              if(nextLine[i] == '0') zeroes[i] += 1;
              else ones[i] += 1;
          }
        }
        char[] gammaRate = new char[binarySize];
        for(int i = 0; i < ones.length; i++) {
            gammaRate[i] = (ones[i] > zeroes[i]) ? '1' : '0';
            //System.out.print(gammaRate[i]);
        }
        char[] epsilonRate = new char[binarySize];
        for(int i = 0; i < ones.length; i++) {
            epsilonRate[i] = (ones[i] < zeroes[i]) ? '1' : '0';
            //System.out.print(epsilonRate[i]);
        }
        System.out.println(Integer.parseInt(String.valueOf(gammaRate),2) * Integer.parseInt(String.valueOf(epsilonRate),2));
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}