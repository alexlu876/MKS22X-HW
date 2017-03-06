import java.io.*;
import java.util.*;

public class LakeMaking{

    private int row;
    private int col;
    private int depth;
    private int numCommands;
    private int[][] pasture;
    
    public LakeMaking(String filename){
	try{
	    File file = new File(filename);
	    Scanner scan = new Scanner(file);
	    int line = 1;
	    while(scan.hasNextLine()){
		String woah = scan.nextLine();
		if(line == 1){
		    String hold1 = woah.substring(0, woah.indexOf(" "));
		    row = Integer.parseInt(hold1);
		    woah = woah.substring(hold1.length() + 1);
		    String hold2 = woah.substring(0, woah.indexOf(" "));
		    col = Integer.parseInt(hold2);
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("rip");
	    System.exit(1);
	}
    }

    public void printRow(){
	System.out.println(row);
    }

    public void printCol(){
	System.out.println(col);
    }

    public static void main(String[] a){
	LakeMaking l = new LakeMaking("lake.txt");
	l.printRow();
	l.printCol();
    }
}

	
		
