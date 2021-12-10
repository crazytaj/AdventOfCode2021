package Day9;
import java.util.*;
import java.io.*;

public class nine2 {
    public static void main(String args[]) {
      try {
        File inputFile = new File("src/Day9/smallInput.txt");
        //File inputFile = new File("src/Day9/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<int[]> map = new ArrayList<int[]>(0);
        while(kB.hasNextLine()) {
            String nextLine = kB.nextLine();
            int[] nextInput = new int[nextLine.length()];
            for(int i = 0; i < nextLine.length(); i++) {
                nextInput[i] = Integer.parseInt(nextLine.substring(i, i+1));
                //System.out.print(nextInput[i]);
            }
            //System.out.println();
            map.add(nextInput);
        }
        int sum = 0;
        for(int i = 0; i < map.size(); i++) {
            int[] subline = map.get(i);
            int count = 0;
            for(int j = 0; j < subline.length; j++) {
                count = 0;
                if(i > 0) {
                    if(map.get(i-1)[j] > subline[j]) count += 1;
                } else count += 1;
                if(j > 0) {
                    if(map.get(i)[j-1] > subline[j]) count += 1;
                } else count += 1;
                if(j < subline.length-1) {
                    if(map.get(i)[j+1] > subline[j]) count += 1;
                } else count += 1;
                if(i < map.size()-1) {
                    if(map.get(i+1)[j] > subline[j]) {
                        count += 1;
                    }
                } else count += 1;
                if(count == 4) {
                    sum += subline[j] +1;
                    
                } else {
                    //System.out.println("add to sum"+count);
                }
            }
        }
        System.out.println(sum);
        //System.out.println(count);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}