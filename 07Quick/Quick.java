import java.util.*;
public class Quick{
    
    public static int[] part(int []data, int start, int end){
	int[] temp = new int[data.length];
	int rand = 3; //data[(int)Math.floor(Math.random() * data.length)];
	int holder = data.length - 1;
	int numDups = 0;
	for(int i = 0; i < data.length; i++){
	    if(i == holder){
		temp[i] = rand;
	    }
	    if(data[i] == rand){
		numDups += 1;
		data[i] = rand;
	    }
	    if(data[i] < rand){
		temp[i] = data[i];
	    }
	    if(data[i] > rand){
		temp[holder] = data[i];
		holder -= 1;
	    }
	}
	data = temp;
	return data;
	//if(temp.indexOf(
    }

    public static void main(String[] args){
	int[] test = new int[]{5, 2, 3, 7, 9, 1, 4};
	part(test, 0, 0);
	System.out.println(Arrays.toString(test));
    }
}
	


	    
