public class Parting{

    public void part(int[] a, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start) + start;
	int value = a[pivot];
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
    /*
while i <= gt:

    if a[i] == v:
    i++

    else if a[i] < v:
    swap(a, i, lt)
    lt++;
    i++;

    else if
    swap(a, i, gt)
    gt--;



    then
    swap(a, lo, gt)
    */
    public void swap(int[] a, int b, int c){
        int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
    }


    /*
      Quick.java
      public static void quicksort(int[] a){...}
      public static (int) quickselect(int[] a, int k){...}
