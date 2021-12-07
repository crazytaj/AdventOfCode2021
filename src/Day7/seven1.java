package Day7;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class seven1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day7/smallInput.txt");
        File inputFile = new File("src/Day7/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<Integer> crabList = new ArrayList<Integer>(0);
        crabList = Arrays.stream(kB.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int lowestCost = 1000000;
        for(Integer crab : crabList) {
          int cost = 0;
          for(int i = 0; i < crabList.size(); i++) {
            //System.out.println(Math.abs(crabList.get(i)-crab));
            cost += Math.abs(crabList.get(i)-crab);
          }
          if(cost < lowestCost) lowestCost = cost;
        }
        System.out.println(lowestCost);

        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}