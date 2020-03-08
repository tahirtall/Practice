class KnightTour {
    
    /* 
     * Knight's Tour is a game where you mimic the move the knight makes in Chess, but this time the player is given
     * N * N grid, and the objective is to visit every square in the grid only once to traverse through the whole grid.
     *
     * I will be using backtracking technique to accomplish this.
     * Wish me good luck :)
     */
    
    static int N = 8;
    
    // A utility function to check if i, j are valid
    // index for N*N chessboard.
    static boolean isSafe(int x, int y, int[][] board) {
        if(x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1) {
            return true;
        }
        return false;
    }
    
    // A utility function to print the solution matrix board[N][N]
    static void printSolution(int board[][]) {
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // Function that runs the utility function
    static boolean SolveKT() {
        int[][] board = new int[8][8];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                board[i][j] = -1;
            }
        }
        
        int xMove[] = {-1, 1, 2, -2, -1, -2, 2, 1};
        int yMove[] = {2, 2, 1, 1, -2, -1, -1, -2};

        board[0][0] = 0;

        if(!solveKTUtil(0,0,1, board, xMove, yMove)) {
            System.out.print("Solution is invalid");
            return false;
        }
        else {
            printSolution(board);
        }
        return true;
    }

    // The Utility function itself.
    static boolean solveKTUtil(int x, int y, int movei, int board[][], int xMove[], int yMove[]) {
        int next_x, next_y;
        if (movei == N*N) {
            return true;
        }
        for (int i=0; i<N; i++) {
            next_x = x + xMove[i];
            next_y = y + yMove[i];
            if(isSafe(next_x, next_y, board)) {
                board[next_x][next_y] = movei;
                if(solveKTUtil(next_x, next_y, movei+1, board, xMove, yMove)) {
                    return true;
                }
                else {
                    board[next_x][next_y] = -1;
                }
            }
    }
    return false;
    }

    public static void main(String[] args) {
        SolveKT();
    }
}
