import java.util.*;
import java.io.*;

public class Maze{
    
    private char[][] maze;
    private boolean animate;
	private int HoldSr;
	private int HoldSc;
	
	public Maze(String filename, boolean b){
		animate = b;
		try{
			int numE = 0;
			int numS = 0;
			File text = new File(filename);
			Scanner inf1 = new Scanner(text);
			int r1 = 0;
			int c1 = 0;
			while(inf1.hasNextLine()){
				String line = inf1.nextLine();
				c1 = line.length();
				r1 += 1;
			}
			maze = new char[r1][c1];
			int r = 0;
			Scanner inf = new Scanner(text);
			while(inf.hasNextLine()){
				String line = inf.nextLine();
				for(int c = 0; c < line.length(); c++){
					maze[r][c] = line.charAt(c);
					if(line.charAt(c) == 'E'){
						numE += 1;
					}
					if(line.charAt(c) == 'S'){
						numS += 1;
						HoldSr = r;
						HoldSc = c;
					}
				}
				r += 1;
			}
			if(numS != 1 || numE != 1){
				System.out.println("Missing/Too many E/S");
				System.exit(1);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Missing File");
			System.exit(0);
		}
	}		

    public void setAnimate(boolean b){
		animate = b;
    }

    public void clearTerminal(){
		System.out.println("\033[2J\033[1;1H");
    }
	
	public String toString(){
		String temp = "";
		for(int r = 0; r < maze.length; r++){
			for(int c = 0; c < maze[0].length; c++){
				temp += maze[r][c];
			}
			temp += "\n";
		}
		return temp;
	}
	
	private void wait(int millis){
		try{
			Thread.sleep(millis);
		}
		catch(InterruptedException e){
		}
    }
	
	public boolean solve(){
		maze[HoldSr][HoldSc] = ' ';
		return solve(HoldSr, HoldSc);
	}
	
	private boolean solve(int r, int c){
		if(animate){
            System.out.println("\033[2J\033[1;1H"+ toString());
            wait(100);
        }
		if(maze[r][c] == 'E'){
			return true;
		}
		maze[r][c] = '&';
		if(maze[r + 1][c] == ' ' || maze[r + 1][c] == 'E'){
			if(solve(r + 1, c)){
				return true;
			}
		}
		if(maze[r - 1][c] == ' ' || maze[r - 1][c] == 'E'){
			if(solve(r - 1, c)){
				return true;
			}
		}
		if(maze[r][c + 1] == ' ' || maze[r][c + 1] == 'E'){
			if(solve(r, c + 1)){
				return true;
			}
		}
		if(maze[r][c - 1] == ' ' || maze[r][c - 1] == 'E'){
			if(solve(r, c - 1)){
				return true;
			}
		}
		maze[r][c] = '.';
		return false;
		
	}
	
	public static void main(String[] args){
		Maze a = new Maze("maze5.txt", true);
		a.solve();
		System.out.println(a);
	}
	
	
	
}






















