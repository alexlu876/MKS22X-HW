import java.util.*;
public class Quick{

    public Quick(){
    }
    
    public void part(int[] a, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start) + start;
	int value = a[pivot];
	System.out.println(pivot);
	System.out.println(value);
	int i = start;
	int lt = start;
	int gt = end;
	while(i <= gt){
	    if(a[i] == value){
		i++;
	    }
	    else if(a[i] < value){
		swap(a, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(a, i, gt);
		gt--;
	    }
	}
    }

    public void swap(int[] a, int b, int c){
        int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
    }

    public static void main(String[] args){
	Quick q = new Quick();
	int[] test = new int[]{5, 2, 3, 7, 9, 1, 4};
	q.part(test, 0, 6);
	System.out.println(Arrays.toString(test));
    }
}
	


	    
