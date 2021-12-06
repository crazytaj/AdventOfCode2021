package Day4;

public class bingoBoard {
    public int[][] board;
    //public int[][] markedBoard;
    public int score;
    public int stepsToWin;

    public bingoBoard(String b, int[] callOrder) {
        board = new int[5][5];
        String[] row = b.split("//");
        for(int i = 0; i < row.length; i++){
            String[] c = row[i].split("\\s+");
            int[] column = new int[5];
            int k = 0;
            for(int j = 0; j < c.length; j++) {
                try{
                    column[j-k] = Integer.parseInt(c[j]);
                } catch (NumberFormatException e) {
                    k += 1;
                }
            }
            board[i] = column;
        }
        printBoard();
        int j = 0;
        for(int i : callOrder) {
            j++;
            //System.out.println(i);
            if(updateBoard(i)) {
                score = calculateScore() * i;
                stepsToWin = j;
                break;
            }
            else{
                score = 0;
            }
        }
        /*
        markedBoard = new int[5][5];
        for(int i = 0; i < markedBoard.length; i++) {
            for(int j = 0; j < markedBoard[i].length; j++) {
                markedBoard[i][j] = 0;
            }
        }
        */
    }

    public boolean updateBoard(int number) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == number) {
                    board[i][j] = 1000;
                    break;
                }
            }
        }
        return checkWin();
    }

    public boolean checkWin() {
        for(int i = 0; i < board.length; i++) {
            int rowScore = 0;
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1000) rowScore += 1;
            }
            if(rowScore == 5) return true;
        }
        for(int i = 0; i < board.length; i++) {
            int columnScore = 0;
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i] == 1000) columnScore += 1;
            }
            if(columnScore == 5) return true;
        }
        return false;
    }

    public int calculateScore() {
        int score = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != 1000) score += board[i][j];
            }
        }
        return score;
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
