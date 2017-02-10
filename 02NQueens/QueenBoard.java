public class QueenBoard{
    private int[][] board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		board[x][y] = 0;
	    }
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
   
    public int availability(){
	int temp = 0;
	for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		if(board[x][y] == 0){
		    temp++;
		}
	    }
	}
	return temp;
    }
		
    public boolean solve(){
        return solveh(0);
	    
    }

    public boolean solveh(row){
	for(int c = 0; c < board.length; c++){
	    if(addQueen(row, c)){
		solveh(row + 1);
	    }
	}
	    

    private void addQueen(int x, int y){
	if(board[x][y] != 0){
	    return false;
	}
	board[x][y] = -1;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if((r == x || c == y) && (board[r][c] != -1)){
		    if(!(r == x && c == y)){
			board[r][c] == board[r][c] + 1;
		    }
		}
	    }
	}
	for(int k = 0; k < board.length - 1; k++){
	    if(x + k < board.length && y + k < board.length){
		board[x + k][y + k] = board[x + k][y + k] + 1;
		
	

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}
    
