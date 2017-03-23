import java.util.*;
public class Quick{

    public Quick(){
    }
    
    public int[] part(int[] a, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start) + start;
	int value = a[pivot];
	//System.out.println(pivot);
	//System.out.println(value);
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
	int[] temp = new int[2];
	temp[0] = lt;
	temp[1] = gt;
	//System.out.println(Arrays.toString(temp));
	//System.out.println(Arrays.toString(a));
	return temp;
    }

    public void quicksort(int[] a){
	quickHelp(a, 0, a.length - 1);
    }

    public void quickHelp(int[] a, int start, int end){
	if(start >= end){
	    return;
	}
	int[] temp = part(a, start, end);
	int low = temp[0];
	int high = temp[1];
	quickHelp(a, start, low - 1);
	quickHelp(a, high + 1, end);	
    }

    public int quickSelect(int[] a, int k){
	quicksort(a);
	return a[k];
    }

    public void swap(int[] a, int b, int c){
        int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
    }

    public static void main(String[] args){
	Quick q = new Quick();
	int[] test = new int[]{999, 999, 999, 0, 5, 5, 5, 4, 3, 7, 9, 6, 999, 999, 999, 3, 1, 10, 234123, 23};
	q.quicksort(test);
	//System.out.println(Arrays.toString(test));
    }
}
	


	    
