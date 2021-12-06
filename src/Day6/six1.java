package Day6;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class six1 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day6/smallInput.txt");
        File inputFile = new File("src/Day6/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<Integer> fishList = new ArrayList<Integer>(0);
        fishList = Arrays.stream(kB.nextLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int days = 80;
        for(int i = 0; i < days; i++) {
          for(int j = 0; j < fishList.size(); j++) {
            int fish = fishList.get(j);
            if(fish - 1 < 0) {
              fishList.set(j, 6);
              fishList.add(9);
            } else {
              fishList.set(j, fish - 1);
            }
          }
        }
        System.out.println(fishList.size());
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}