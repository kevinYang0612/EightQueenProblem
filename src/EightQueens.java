public class EightQueens
{
    public static int counter = 0;
    public static void main(String[] theArgs)
    {
        char[][] board = new char[8][8];
        fillBoard(board);
        queen8(board, 0);
        System.out.println(counter);
    }
    public static void displayBoard(char[][] theBoard)
    {
        System.out.println("________________________________________" + counter);
        for (int i = 0; i < theBoard.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < theBoard[i].length; j++)
            {
                System.out.print(" " + theBoard[i][j] + "  |");
            }
            System.out.print("\n|");
            for (int j = 0; j < theBoard[i].length; j++)
            {
                System.out.print("____|");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void fillBoard(char[][] theBoard)
    {
        for (int i = 0; i < theBoard.length; i++)
        {
            for (int j = 0; j < theBoard[i].length; j++)
            {
                theBoard[i][j] = ' ';
            }
        }
    }
    public static void queen8(char[][] theBoard, int theRow)
    {
        if (theRow > 7)
        {
            counter++;
            displayBoard(theBoard);
        }
        else
        {
            for (int col = 0; col < theBoard[theRow].length; col++)
            {
                if (safeToMove(theBoard, theRow, col))
                {
                    theBoard[theRow][col] = 'Q';
                    queen8(theBoard, theRow + 1);
                    theBoard[theRow][col] = ' ';
                }
            }
        }
    }
    public static boolean safeToMove(char[][] theBoard, int theRow, int theCol)
    {
        boolean isSafe = true;
        for (int i = 0; i < 8 && isSafe; i++)
        {
            isSafe = theBoard[theRow][i] == ' ' && theBoard[i][theCol] == ' ';
        }
        int col = 0;
        int row = 0;
        if (theCol > theRow)
        {
            col = theCol - theRow;
        }
        else
        {
            row = theRow - theCol;
        }
        for (;row < 8 && col < 8 && isSafe; row++, col++)
        {
            isSafe = theBoard[row][col] == ' ';
        }
        col = 7;
        row = 0;
        if (theCol + theRow > 7)
        {
            row = theCol + theRow - 7;
        }
        else
        {
            col = theRow + theCol;
        }
        for (;row < 8 && col >= 0 && isSafe; row++, col--)
        {
            isSafe = theBoard[row][col] == ' ';
        }
        return isSafe;
    }
//   public static boolean safeToMove(char[][] theBoard, int theRow, int theCol) {
//     boolean isSafe = true;
//     for (int i = 0; i < 8 && isSafe; i++) {
//       isSafe = theBoard[theRow][i] == ' ' && theBoard[i][theCol] == ' ';
//     }
//     int col = theCol;
//     int row = theRow;
//     while (row > 0 && col > 0) {
//       row--;
//       col--;
//     }
//
//     for (;row < theBoard.length && col < theBoard[0].length && isSafe; row++, col++) {
//       isSafe = theBoard[row][col] == ' ';
//     }
//     col = theCol;
//     row = theRow;
//     while (row > 0 && col < 7) {
//       row--;
//       col++;
//     }
//
//     for (;row < theBoard.length && col >= 0 && isSafe; row++, col--) {
//       isSafe = theBoard[row][col] == ' ';
//     }
//     return isSafe;
//   }
    
}
