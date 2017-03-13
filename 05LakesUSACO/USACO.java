import java.io.*;
import java.util.*;    
public class USACO{

    private int[][] lake;
    private int row1;
    private int col1;
    private int dep;
	private int numRows;
    private int numCols;
    private int time;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private int[][]pasture;
    private int[][]pasture2;

    public USACO(){
    }

    public int bronze(String filename){
		Scanner scan = null;
		try{
			File file = new File(filename);
			scan = new Scanner(file);
		}
		catch(Exception e){
			System.out.println("File not found error");
			System.exit(0);
		}
		Scanner Line1 = new Scanner(scan.nextLine()); //give us data, scan through first line to give instance variables
		row1 = Integer.parseInt(Line1.next());
		col1 = Integer.parseInt(Line1.next());
		dep = Integer.parseInt(Line1.next());
		lake = new int[row1][col1]; //scans through rest of lines to fill up 2d array
		for(int r = 0; r < row1 ; r++){
			if(scan.hasNextLine()){
				Scanner nextLines = new Scanner(scan.nextLine());
				for(int c = 0; c < col1; c++){
					lake[r][c] = nextLines.nextInt();
				}
			}
		}
		while(scan.hasNextLine()){ //takes in instructions
			Scanner lastLine = new Scanner(scan.nextLine());
			int row = lastLine.nextInt() - 1;
			int col = lastLine.nextInt() - 1;
			int depth = lastLine.nextInt();
			int height = stomp(row, col, depth);
			for(int r = row; r < row + 3; r++){
				for(int c = col; c < col + 3; c++){
					if(lake[r][c] > height){
					lake[r][c] = height;
					}
				}
			}
		}
		return volume(dep);
	}
    private int stomp(int row, int col, int depth){
		int tempRow = row;
		int tempCol = col;
		int temp = lake[row][col]; //stops within designated 3x3 area, checking condition as well
		for(int r = row; r < row + 3; r++){
			for(int c = col; c < col + 3; c++){
				if (lake[r][c] > temp){ //condition checker
					temp = lake[r][c];
					tempRow = r;
					tempCol = c;
				}
			}
		}
		return temp - depth;
    }
    private int volume(int elevation){ //calculates volume by subtracting given value with local values, then multiplies by block size
		int total = 0;
		for(int r = 0; r < row1; r++){
			for(int c = 0; c < col1; c++){
				if(lake[r][c] < dep){
					total += dep - lake[r][c];
				}
			}
		}
		return total * 72 * 72;
    }
	
    public int silver(String filename){
		Scanner scan = null;
		try{
			File file = new File(filename);
			scan = new Scanner(file);
		}
		catch(Exception e){
			System.out.println("File not found");
			System.exit(0);
		}
		Scanner firstLine = new Scanner(scan.nextLine()); //give us data, goes through first line givens
		numRows = Integer.parseInt(firstLine.next());
		numCols = Integer.parseInt(firstLine.next());
		time = Integer.parseInt(firstLine.next());
		pasture = new int[numRows][numCols];
		pasture2 = new int[numRows][numCols]; //Idea is to trasnfer from one pasture to the next, using iterative method
		for(int r = 0; r < numRows; r++){
			String nextLines = scan.next();
			for(int c = 0; c < numCols; c++){
				if(nextLines.charAt(c) == '*'){ //putting trees where cows cannot go
					pasture[r][c] = -1;
					pasture2[r][c] = -1;
				}
				else{
				pasture[r][c] = 0;
				pasture2[r][c] = 0;
			}
			}
		}
		startRow = scan.nextInt() - 1; 
		startCol = scan.nextInt() - 1;
		endRow = scan.nextInt() - 1;
		endCol = scan.nextInt() - 1;
		return numberOfPaths();
    }
    private void updatePastures(){ //switches between pastures
		for(int r = 0; r < numRows; r++){
			for(int c = 0; c < numCols; c++){
				pasture[r][c] = pasture2[r][c];
			}
		}
    }
    private int numberOfPaths(){ 
		pasture[startRow][startCol] = 1;
		for(int z = 0; z < time; z++){ //only allows function to go so far
			for (int r = 0; r < numRows; r++){
				for(int c = 0; c < numCols; c++){
					int sum = 0;
					if(r + 1 < numRows && pasture[r + 1][c]!= -1){
						sum += pasture[r + 1][c];
					}
					if(r - 1 >= 0 && pasture[r - 1][c]!= -1){
						sum += pasture[r - 1][c];
					}		    
					if(c + 1 < numCols && pasture[r][c + 1]!= -1){
						sum += pasture[r][c + 1];
					}
					if(c - 1 >= 0 && pasture[r][c - 1]!= -1){
						sum += pasture[r][c - 1];
					}
					if(pasture[r][c]!=-1){
						pasture2[r][c] = sum; //stores value for transfer later
					}
				}
			}
	    updatePastures(); //updates for final return
		}
		return pasture[endRow][endCol];
    }
    public static void main(String[] args){
		USACO u = new USACO();
    }			   
}

	
		
