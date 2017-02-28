public class KnightBoard{
    int[][] board;
	
    public KnightBoard(int r, int c){
	board = new int[r][c];
	for(int x = 0; x < r; x++){
	    for(int y = 0; y < c; y++){
		board[x][y] = 0;
	    }
	}
    } 

    public void reset(){
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		board[r][c] = 0;
	    }
	}
    }

    public void solve(){
	reset();
	/*
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		reset();
		addK(r, c, 1);
		solveh(r, c, 1);
	    }
	}
	*/
	addK(0, 0, 1);
	solveh(0, 0, 2);
	
    }

    public boolean solveh(int r, int c, int level){
	if(level > board.length * board[0].length){
	    return true;
	}
	if(r + 2 < board.length && c + 1 < board[0].length){
	    if(checker(r + 2, c + 1)){
		addK(r + 2, c + 1, level);
	    if(solveh(r + 2, c + 1, level + 1) == true){
		return true;
	    }
	    }
	    remK(r + 2, c + 1, level);
	}
	if(r + 1 < board.length && c + 2 < board[0].length){
	    if(checker(r + 1, c + 2)){
		addK(r + 1, c + 2, level);
	    if(solveh(r + 1, c + 2, level + 1) == true){
		return true;
	    }
	    }
	    remK(r + 1, c + 2, level);
	}
	if(r + 2 < board.length && c - 1 > -1){
	    if(checker(r + 2, c - 1)){
		addK(r + 2, c - 1, level);
	    if(solveh(r + 2, c - 1, level + 1) == true){
		return true;
	    }
	    }
	    remK(r + 2, c - 1, level);
	}
	if(r + 1 < board.length && c - 2 > -1){
	    if(checker(r + 1, c - 2)){
		addK(r + 1, c - 2, level);
	    if(solveh(r + 1, c - 2, level + 1) == true){
		return true;
	    }
	    }
	    remK(r + 1, c - 2, level);
	}
	if(r - 2 > -1 && c + 1 < board[0].length){
	    if(checker(r - 2, c + 1)){
		addK(r - 2, c + 1, level);
	    if(solveh(r - 2, c + 1, level + 1) == true){
		return true;
	    }
	    }
	    remK(r - 2, c + 1, level);
	}
	if(r - 1 > -1 && c + 2 < board[0].length){
	    if(checker(r - 1, c + 2)){
		addK(r - 1, c + 2, level);
	    if(solveh(r - 1, c + 2, level + 1) == true){
		return true;
	    }
	    }
	    remK(r - 1, c + 2, level);
	}
        if(r - 2 > -1 && c - 1 > -1){
	    if(checker(r - 2, c - 1)){
		addK(r - 2, c - 1, level);
	    if(solveh(r - 2, c - 1, level + 1) == true){
		return true;
	    }
	    }
	    remK(r - 2, c - 1, level);
	}
	if(r - 1 > -1 && c - 2 > -1){
	    if(checker(r - 1, c - 2)){
		addK(r - 1, c - 2, level);
	    if(solveh(r - 1, c - 2, level + 1) == true){
		return true;
	    }
	    }
	    remK(r - 1, c - 2, level);
	}
	return false;
    }

    private void addK(int r, int c, int level){
	board[r][c] = level;
    }

    private void remK(int r, int c, int level){
		if(board[r][c] == level){
		board[r][c] = 0;
		}
    }
	
	private boolean checker(int r, int c){
		if(r > board.length || r < 0 || c < 0 || c > board[0].length){
			return false;
		}
		if(board[r][c] == 0){
			return true;
		}
		return false;
	}

    public String toString(){
	String temp = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] < 10){
		    temp += " " + board[r][c] + " ";
		}
		else{
		    temp += board[r][c] + " ";
		}
	    }
	    temp += "\n";
	}
	return temp;
    }

    public static void main(String[] ARG){
	KnightBoard k = new KnightBoard(5, 7);
	k.solve();
	System.out.println(k);
    }
		

}