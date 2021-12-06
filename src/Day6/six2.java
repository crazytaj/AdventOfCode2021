package Day6;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class six2 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day6/smallInput.txt");
        File inputFile = new File("src/Day6/input.txt");
        Scanner kB = new Scanner(inputFile);
        long[] fishList = Arrays.stream(kB.nextLine().split(",")).mapToLong(Long::parseLong).toArray();
        //System.out.println(Arrays.toString(fishList));
        int days = 256;
        long[] numberList = new long[9];
        for(int i = 0; i < numberList.length; i++) {
            numberList[i] = 0;
        }
        for(int j = 0; j < fishList.length; j++) {
            numberList[(int) fishList[j]] += 1;
        }
        //System.out.println(Arrays.toString(numberList));
        for(int i = 0; i < days; i++) {
            long[] tempNumberList = new long[9];
            for(int j = 0; j < numberList.length; j++) {
                tempNumberList[j] = 0;
            }
            for(int j = 0; j < numberList.length; j++) {
                if(j == 0) {
                    tempNumberList[8] += numberList[j];
                    tempNumberList[6] += numberList[j];
                } else {
                    tempNumberList[j-1] += numberList[j];
             
               }
            }
            //System.out.println(Arrays.toString(tempNumberList));
            numberList = tempNumberList;
        }
        long sum = 0;
        for(int i = 0; i < numberList.length; i++) {
            sum += numberList[i];
        }
        System.out.println(sum);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}