package Day7;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class seven2 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day7/smallInput.txt");
        File inputFile = new File("src/Day7/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<Integer> crabList = new ArrayList<Integer>(0);
        crabList = Arrays.stream(kB.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int lowestCost = 100000000;
        int biggestNum = 0;
        for(int i = 0; i < crabList.size(); i++) {
            if(crabList.get(i) > biggestNum) biggestNum = crabList.get(i);
        }
        for(int j = 0; j < biggestNum; j++) {
          int cost = 0;
          for(int i = 0; i < crabList.size(); i++) {
            //System.out.println(Math.abs(j-crabList.get(i))*(1+Math.abs(j-crabList.get(i)))/2);
            cost += Math.abs(j-crabList.get(i))*(1+Math.abs(j-crabList.get(i)))/2;
          }
          //System.out.println(cost);
          if(cost < lowestCost) lowestCost = cost;
        }
        System.out.println(lowestCost);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}