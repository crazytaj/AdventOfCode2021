package Day3;
import java.util.*;
import java.io.*;

public class three2 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day3/smallInput.txt");
        //int binarySize = 5;
        File inputFile = new File("src/Day3/input.txt");
        int binarySize = 12;
        Scanner kB = new Scanner(inputFile);
        List<char[]> input = new ArrayList<char[]>(0);
        while(kB.hasNextLine()) {
          input.add(kB.nextLine().toCharArray());
        }
        List<char[]> secondInput = input;
        boolean cont = true;
        for(int k = 0; k < binarySize && cont; k++) {
            int[] ones = new int[binarySize];
            int[] zeroes = new int[binarySize];
            for(int j = 0; j < input.size(); j++) {
                char[] nextLine = input.get(j);
                for(int i = 0; i < nextLine.length; i++) {
                    if(nextLine[i] == '0') zeroes[i] += 1;
                    else ones[i] += 1;
                }
            }
            List<char[]> tempInput = input;
            input = new ArrayList<char[]>(0);
            char common = (ones[k] >= zeroes[k]) ? '1' : '0';
            for(int j = 0; j < tempInput.size(); j++) {
                char[] nextLine = tempInput.get(j);
                if(nextLine[k] == common) input.add(nextLine);
            }
            if(input.size() < 2) {
                cont = false;
            }
        }
        char[] oxygenRating = input.get(0);
        System.out.println(String.valueOf(oxygenRating));
        cont = true;
        for(int k = 0; k < binarySize && cont; k++) {
            int[] ones = new int[binarySize];
            int[] zeroes = new int[binarySize];
            for(int j = 0; j < secondInput.size(); j++) {
                char[] nextLine = secondInput.get(j);
                for(int i = 0; i < nextLine.length; i++) {
                    if(nextLine[i] == '0') zeroes[i] += 1;
                    else ones[i] += 1;
                }
            }
            List<char[]> tempInput = secondInput;
            secondInput = new ArrayList<char[]>(0);
            char common = (ones[k] >= zeroes[k]) ? '0' : '1';
            for(int j = 0; j < tempInput.size(); j++) {
                char[] nextLine = tempInput.get(j);
                if(nextLine[k] == common) secondInput.add(nextLine);
            }
            if(secondInput.size() < 2) {
                cont = false;
            }
        }
        char[] co2Rating = secondInput.get(0);
        System.out.println(String.valueOf(co2Rating));
        System.out.println(Integer.parseInt(String.valueOf(oxygenRating),2) * Integer.parseInt(String.valueOf(co2Rating),2));
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}