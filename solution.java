class Solution {
    
    
    //array of chars to get the char representation of number   
    private char[] numm = {'0','1','2','3','4','5','6','7','8','9'};
    public boolean isValid(char[][]board, int row, int column, char insert){
         //iterate through the column
         for(int r=0;r<board.length;r++){
             if(board[r][column]==insert){
                 return false;
             }
         }
        //iterate through the row
        for(int c=0;c<board[0].length;c++){
             if(board[row][c]==insert){
                 return false;
             }
         }
        
        //now check for 3*3 grid   
        int grid_x = row/3*3;
        int grid_y = column/3*3;
        int max_x = grid_x+3;
        int max_y = grid_y+3;
        
        //iterate through the 3*3 grid
        //O(N^2)
        
 int startx = row/3*3;
        int starty = column/3*3; 
        for(int x = startx; x<startx+3; x++){
            for(int y = starty; y<starty+3; y++){
                if(board[x][y] == insert){
                    return false;
                }
            }
        }
        return true;
    }
    
    
   // backtracker
   private boolean backtrack(char[][] board) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.'){
                    for(int num = 1; num < 10; num++){
                        if(isValid(board, r, c, numm[num])){
                            board[r][c] = numm[num];
                            if(backtrack(board)){
                                return true;
                            }else{
                                board[r][c] = '.';
                                
                            }
                        }
                    }
                    return false;
                    
                }
            }
        }
        return true;
	}

    public void solveSudoku(char[][] board) {
       backtrack(board);
        
    }
}
