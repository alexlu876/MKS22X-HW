public class Parting{
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
