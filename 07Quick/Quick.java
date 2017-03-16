import java.util.*;
public class Quick{
    
    public static int part(int []data, int start, int end){
	int[] temp = new int[data.length];
	int range = end - start;
	int rand = data[(int)Math.round(Math.random() * range)];
	int holder = end;
	for(int i = start; i < end; i++){
	    if(i == holder){
		temp[i] = rand;
	    }
	    if(data[i] <= rand){
		temp[i] = data[i];
	    }
	    if(data[i] > rand){
		temp[holder] = data[i];
		holder -= 1;
	    }
	}
	System.out.println(rand);
	System.out.println(Arrays.toString(temp));
	return holder;
    }

    public static void main(String[] args){
	int[] test = new int[]{5, 2, 3, 7, 9, 1, 4};
	part(test, 0, 6);
	System.out.println(Arrays.toString(test));
    }
}
	


	    
