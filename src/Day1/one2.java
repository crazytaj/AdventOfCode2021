package Day1;
import java.util.*;
import java.io.*;

public class one2 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day1/smallInput.txt");
        File inputFile = new File("src/Day1/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<Integer> input = new ArrayList<Integer>(0);
        input.add(0);
        input.add(0);
        input.add(0);
        while(kB.hasNextLine()) {
          input.add(kB.nextInt());
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int count = -3;
        int prevNum = 0;
        for(int i = 3; i < input.size(); i++) {
          int newNum = input.get(i);
          if(input.get(i-1) == a) b = newNum;
          else if(input.get(i-1) == b) c = newNum;
          else if(input.get(i-1) == c) a = newNum;
          
          if(a+b+c > prevNum) {
            count++;
          }
          prevNum = a+b+c;
          System.out.println(a+b+c+" "+count);
        }
        System.out.println(count);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}