import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][] maze;
    private boolean animate;
    private String holdmaze;

    public Maze(String filename, boolean a) throws FileNotFoundException{
	animate = a;
	File infile = new File(filename);
	Scanner inf = new Scanner(infile);
	int lineNumber = 1;
	while(inf.hasNextLine()){
	    holdmaze += inf.nextLine();
	}
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J");
    }
}
