package Day8;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class eight2 {
    public static void main(String args[]) {
      try {
        //File inputFile = new File("src/Day8/smallInput.txt");
        File inputFile = new File("src/Day8/input.txt");
        Scanner kB = new Scanner(inputFile);
        List<Integer> crabList = new ArrayList<Integer>(0);
        int count = 0;
        int sum = 0;
        while(kB.hasNextLine()) {
            String[] nextLine2 = kB.nextLine().split(" \\| ");
            String[] nextLine = nextLine2[0].split(" ");
            String[] answerLine = nextLine2[1].split(" ");
            Arrays.sort(nextLine, Comparator.comparingInt(String::length));
            char[][] displayOrder = new char[7][2];
            char[] trueDisplayOrder = new char[7];
            for(int i = 0; i < nextLine.length; i++) {
                //System.out.println(nextLine[i]);zd
                switch(nextLine[i].length()) {
                    case 2: //1
                        displayOrder[2][0] = nextLine[i].charAt(0);
                        displayOrder[2][1] = nextLine[i].charAt(1);
                        displayOrder[5][0] = nextLine[i].charAt(0);
                        displayOrder[5][1] = nextLine[i].charAt(1);
                    break;
                    case 3: //7
                        for(int j = 0; j < nextLine[i].length(); j++) {
                            if(nextLine[i].charAt(j) != displayOrder[2][0] && nextLine[i].charAt(j) != displayOrder[2][1]) trueDisplayOrder[0] = nextLine[i].charAt(j);
                        }
                    break;
                    case 4: //4
                        count = 0;
                        for(int j = 0; j < nextLine[i].length(); j++) {
                            if(nextLine[i].charAt(j) != displayOrder[2][0] && nextLine[i].charAt(j) != displayOrder[2][1]) {
                                displayOrder[1][count] = nextLine[i].charAt(j);
                                displayOrder[3][count] = nextLine[i].charAt(j);
                                count++;
                            }
                        }
                    break;
                    case 7: //8
                        count = 0;
                        for(int j = 0; j < nextLine[i].length(); j++) {
                            if(nextLine[i].charAt(j) != displayOrder[2][0] && nextLine[i].charAt(j) != displayOrder[2][1] && nextLine[i].charAt(j) != displayOrder[1][0] && nextLine[i].charAt(j) != displayOrder[1][1] && nextLine[i].charAt(j) != trueDisplayOrder[0]) {
                                displayOrder[4][count] = nextLine[i].charAt(j);
                                displayOrder[6][count] = nextLine[i].charAt(j);
                                count++;
                            }
                        }
                    break;
                }
            }
            for(int i = 0; i < nextLine.length; i++) {
                //System.out.println(nextLine[i]);zd
                switch(nextLine[i].length()) {
                    case 5:
                        if(nextLine[i].indexOf(displayOrder[1][0]) != -1 && nextLine[i].indexOf(displayOrder[1][1]) != -1) {
                            if(nextLine[i].indexOf(displayOrder[2][0]) != -1) {
                                trueDisplayOrder[5] = displayOrder[2][0];
                                trueDisplayOrder[2] = displayOrder[2][1];
                            }
                            else {
                                trueDisplayOrder[5] = displayOrder[2][1];
                                trueDisplayOrder[2] = displayOrder[2][0];
                            }
                            if(nextLine[i].indexOf(displayOrder[6][0]) != -1) {
                                trueDisplayOrder[6] = displayOrder[6][0];
                                trueDisplayOrder[4] = displayOrder[6][1];
                            }
                            else {
                                trueDisplayOrder[6] = displayOrder[6][1];
                                trueDisplayOrder[4] = displayOrder[6][0];
                            }
                        }
                        if(nextLine[i].indexOf(displayOrder[4][0]) != -1 && nextLine[i].indexOf(displayOrder[4][1]) != -1) {
                            if(nextLine[i].indexOf(displayOrder[3][0]) != -1) {
                                trueDisplayOrder[3] = displayOrder[3][0];
                                trueDisplayOrder[1] = displayOrder[3][1];
                            }
                            else {
                                trueDisplayOrder[3] = displayOrder[3][1];
                                trueDisplayOrder[1] = displayOrder[3][0];
                            }
                        }
                    break;
                }
            }
            char[] number = new char[4];
            for(int i = 0; i < answerLine.length; i++) {
                if(answerLine[i].indexOf(trueDisplayOrder[3]) == -1 && answerLine[i].indexOf(trueDisplayOrder[6]) != -1) number[i] = '0';
                else if(answerLine[i].length() == 2) number[i] = '1';
                else if(answerLine[i].indexOf(trueDisplayOrder[1]) == -1 && answerLine[i].indexOf(trueDisplayOrder[5]) == -1) number[i] = '2';
                else if(answerLine[i].indexOf(trueDisplayOrder[1]) == -1 && answerLine[i].indexOf(trueDisplayOrder[6]) != -1) number[i] = '3';
                else if(answerLine[i].length() == 4) number[i] = '4';
                else if(answerLine[i].indexOf(trueDisplayOrder[2]) == -1 && answerLine[i].indexOf(trueDisplayOrder[4]) == -1) number[i] = '5';
                else if(answerLine[i].indexOf(trueDisplayOrder[2]) == -1) number[i] = '6';
                else if(answerLine[i].indexOf(trueDisplayOrder[1]) == -1) number[i] = '7';
                else if(answerLine[i].indexOf(trueDisplayOrder[4]) == -1) number[i] = '9';
                else number[i] = '8';
            }
            String sNum = new String(number);
            int actualNum = Integer.parseInt(sNum);
            sum += actualNum;
        }

        System.out.println(sum);
        kB.close();
      } catch (FileNotFoundException e) {

      }
    }

}