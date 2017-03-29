import java.util.*;
public class Merge{

    public Merge(){
    }

    public void mergesort(int[] a){
		if(a.length == 1){
			return;
		}
		int var = a.length / 2;
		int[] left = new int[var];
		int[] right = new int[a.length - var];
		for(int i = 0; i < var; i++){
			left[i] = a[i];
		}
		for(int i = 0; i < a.length - var; i++){
			right[i] = a[i + var];
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		mergesort(left);
		mergesort(right);
		mergeTheTwoHalvesIntoTheOriginalArray(left, right, a);
    }

    public void mergeTheTwoHalvesIntoTheOriginalArray(int[] a, int[] b, int[] c){
        int i = 0;
		int j = 0;
		while(i + j < a.length + b.length){
			if(i >= a.length){
				c[i + j] = b[j];
				j++;
			}
			else if(j >= b.length){
				c[i + j] = a[i];
				i++;
			}
			else if(a[i] <= b[j]){
				c[i + j] = a[i];
				i++;
			}
			else if(b[j] < a[i]){
				c[i + j] = b[j];
				j++;
			}
		}
    }
		
		

    public static void main(String[] a){
		Merge m = new Merge();
		int[] b = new int[1000000];
		for(int i = 0; i < 1000000; i++){
			b[i] = 1000000 - i;
		}
		m.mergesort(b);
		System.out.println(Arrays.toString(b));
    }


}