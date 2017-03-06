import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mazeTest{

    private char[][]maze;
    private boolean animate;
    private int rowStart;
    private int colStart;

    public mazeTest(String filename){
	animate = false;
	try{
	    int y = 0;
	    int E = 0;
	    int S = 0;
	    File text = new File(filename);    
	    Scanner sc = new Scanner(text);
	    while(sc.hasNextLine()){
	    String a = sc.nextLine();
	    for(int x = 0; x < a.length(); x++){
		maze[x][y] = a.charAt(x);
		if(a.charAt(x) == 'E'){
		    E += 1;
		}
		if(a.charAt(x) == 'S'){
		    S += 1;
		    rowStart = x;
		    colStart = y;
		}
	    }
	    y = y + 1;
	    }
	if(E != 1 || S != 1){
	    System.out.println("Missin E or S");
	    System.exit(0);
	}
	}
	catch(FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(0);
	}
    }
	

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int sRow = rowStart;
	int sCol = colStart;
	maze[sRow][sCol] = ' ';
	return solve(sRow, sCol);
    }

    private boolean solve(int row, int col){
	if(animate){
	    System.out.println("\033[2J\033[1;1H" + this);
	    wait(20);
	}

	maze[row][col] = '@';

	if(maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row + 1][col] == ' '){
	    solve(row + 1, col);
	}
	if(maze[row  - 1][col] == ' '){
	     solve(row - 1, col);
	}
	if(maze[row][col + 1] == ' '){
	     solve(row, col + 1);
	}
	if(maze[row][col - 1] == ' '){
	     solve(row, col - 1);
	}
	else{maze[row][col] = '.';
	}
	return false;
    }

    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }
	
	public static void main(String[]ARGS){
		mazeTest a = new mazeTest("maze1.txt");
		a.clearTerminal();
		a.solve();
	}
}









