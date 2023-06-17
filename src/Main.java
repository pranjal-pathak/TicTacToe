import java.util.*;
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        char board[][] = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean game_over = false;
        boolean game_draw = false;

        Scanner sc = new Scanner(System.in);

        while (!game_over&&!game_draw) {
            print(board);
            System.out.println("Player " + player + " enter:");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row>=0&&row<3&&col>=0&&col<3&&board[row][col] == ' ') {
                board[row][col] = player;
                game_over = hasWon(board, player);
                game_draw = if_draw(board);
                if (game_over) {
                    System.out.println("Player " + player + " has won:D");
                }
                else if(game_draw)
                {
                    System.out.println("It's a tie :|");
                }
                else {
                    player = player == 'X' ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move.Try Again");
            }
        }
        print(board);
    }

    public static void print(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board, char player) {
//        check the rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
                return true;
        }
//        check for columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
                return true;
        }
//        check for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public static boolean if_draw(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==' ')
                    return false;
            }
        }
        return true;
    }
}