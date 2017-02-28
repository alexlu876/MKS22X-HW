public class QueenBoard{
    private int[][] board;
    private int solutionCount;
	private int ran = 0;
    
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
	 
   
    public int numQueens(){
		int temp = 0;
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board.length; c++){
				if(board[r][c] == -1){
					temp++;
				}
			}
		}
		return temp;
	}
   	
    public void solve(){
		for(int x = 0; x < board.length; x++){
	    for(int y = 0; y < board.length; y++){
		board[x][y] = 0;
	    }
	}
        solveh(0);	    
    }
	
	public void countSolutions(){
		ran = 1;
		solutionCount = 0;
		for(int x = 0; x < board.length; x++){
			for(int y = 0; y < board.length; y++){
				board[x][y] = 0;
			}
		}
		solveh2(0);
		
	}
	
	public void solveh2(int r){
		if(r >= board.length){
			solutionCount++;
			//System.out.println(toString());
		}
		if(r < board.length){
		for(int c = 0; c < board.length; c++){
			if(addQueen(r, c)){
				solveh2(r + 1);
				remQueen(r, c);	
			}
		}
		}
    }
	
	private int locateQueen(int r){
		for(int c = 0; c < board.length; c++){
			if(board[r][c] == -1){
				return c;
			}
		}
		return -1;
	}
	
	private boolean avail(int r){
		for(int c = 0; c < board.length; c++){
			if(board[r][c] == 0){
				return true;
			}
		}
		return false;
	}

    public boolean solveh(int r){
		if(r >= board.length && r != 2){
			return true;
		}
		if(board.length == 2){
			return false;
		}
		for(int c = 0; c < board.length; c++){
			if(addQueen(r, c)){
				if(solveh(r + 1) == true){
					return true;
				}
				remQueen(r, c);	
			}
		}
		return false;
    }

    private boolean remQueen(int x, int y){
        if(board[x][y] != -1){
			return false;
		}
		if(x > board.length || y > board.length){
			return false;
		}
		board[x][y] = 0;
		for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if((r == x || c == y) && (board[r][c] != 0)){
		    if(!(r == x && c == y)){
			board[r][c] = board[r][c] - 1;
		    }
		}
	    }
		}
		for(int k = 1; k < board.length; k++){
	    if(x + k < board.length && y + k < board.length){
			if(board[x + k][y + k] == -1){
				return false;
			}
		board[x + k][y + k] = board[x + k][y + k] - 1;
	    }
	    if(x - k > -1 && y + k < board.length){
			if(board[x - k][y + k] == -1){
				return false;
			}
		board[x - k][y + k] = board[x - k][y + k] - 1;
	    }
	    if(x + k < board.length && y - k > -1){
			if(board[x + k][y - k] == -1){
				return false;
			}
		board[x + k][y - k] = board[x + k][y - k] - 1;
	    }
	    if(x - k > -1 && y - k > -1){
			if(board[x - k][y - k] == -1){
				return false;
			}
		board[x - k][y - k] = board[x - k][y - k] - 1;
	    }
	}
	return false;
	}
	
	    

    private boolean addQueen(int x, int y){
	if(board[x][y] != 0){
	    return false;
	}
	if(x > board.length || y > board.length){
	    return false;
	}
	board[x][y] = -1;
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if((r == x || c == y) && (board[r][c] != -1)){
		    if(!(r == x && c == y)){
			board[r][c] = board[r][c] + 1;
		    }
		}
	    }
	}
	for(int k = 1; k < board.length; k++){
	    if(x + k < board.length && y + k < board.length){
			if(board[x + k][y + k] == -1){
				return false;
			}
		board[x + k][y + k] = board[x + k][y + k] + 1;
	    }
	    if(x - k > -1 && y + k < board.length){
			if(board[x - k][y + k] == -1){
				return false;
			}
		board[x - k][y + k] = board[x - k][y + k] + 1;
	    }
	    if(x + k < board.length && y - k > -1){
			if(board[x + k][y - k] == -1){
				return false;
			}
		board[x + k][y - k] = board[x + k][y - k] + 1;
	    }
	    if(x - k > -1 && y - k > -1){
			if(board[x - k][y - k] == -1){
				return false;
			}
		board[x - k][y - k] = board[x - k][y - k] + 1;
	    }
	}
	return true;
    }

		
	

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
		if(ran == 0){
			return -1;
		}
    	return solutionCount;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String temp = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if(board[r][c] == -1){
		    temp += "*";
		    temp += " ";
		}
		else{
		    temp += "_";
		    temp += " ";
		}
	    }
	    temp += "\n";
	}
	return temp;
    }

    public static void main(String[] ARGS){
	QueenBoard q = new QueenBoard(10);
	/*
	q.addQueen(2, 2);
	System.out.println(q);
	q.addQueen(4, 3);
	System.out.println(q);
	//System.out.println(q.numQueens());
	q.remQueen(2, 2);
	System.out.println(q);
	*/
	q.solve();
	System.out.println(q);
	//q.countSolutions();
	System.out.println(q.getSolutionCount());
    }
}
