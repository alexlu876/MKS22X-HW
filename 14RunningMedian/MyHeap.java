import java.util.*;

public class MyHeap{
	
    private int size;
    private ArrayList<Integer> heap;
    private int toggle;

    public MyHeap(boolean bool){
		size = 0;
		heap = new ArrayList<Integer>();
		heap.add(0);
		if(bool == true){
			toggle = 1;
		}
		if(bool == false){
			toggle = -1;
		}
    }

    public MyHeap(){
		size = 0;
		toggle = 1;
		heap = new ArrayList<Integer>();
		heap.add(0);
    }
    
    public Integer peek(){
		return heap.get(1);	
    }

	/*
	Private methods:
	1- Some are for retrieving some values (children and parents)
	2- pushUp and pushDown methods for fixing up heaps
	*/
	public Integer getSize(){
		return size;
	}
	
    private Integer LChild(int n){
		return heap.get(2 * n);
    }

    private Integer RChild(int n){
		return heap.get(2 * n + 1);
    }

    private Integer getParent(int n){
		return heap.get(n / 2);
    }

    private boolean hasParent(int n){
		return n != 1;
    }

    private boolean hasLChild(int n){
		return size >= 2 * n;
    }

    private boolean hasRChild(int n){
		return size >= 2 * n + 1;
    }

    private void pushUp(int n){
		if (hasParent(n) && getParent(n).compareTo(heap.get(n)) * toggle < 0){
			Integer str = getParent(n);
			heap.set(n / 2, heap.get(n));
			heap.set(n, str);
			pushUp(n / 2);
		}
    }

    private void pushDown(int n){
		if(n == 0){
			return;
		}
		int pos = 0; 
		Integer str = heap.get(n);
		if(hasLChild(n) && str.compareTo(LChild(n)) * toggle < 0){
			pos = -1;
			str = LChild(n);
		}
		if(hasRChild(n) && str.compareTo(RChild(n)) * toggle < 0){
			pos = 1;
			str = RChild(n);
		}
		if(pos == 0){
			return;
		}
		if(pos == -1){
			Integer stri = LChild(n);
			heap.set(n * 2, heap.get(n));
			heap.set(n, stri);
			pushDown(n * 2);
			return;
		}
		if(pos == 1){
			Integer stri = RChild(n);
			heap.set(n * 2 + 1, heap.get(n));
			heap.set(n, stri);
			pushDown(n * 2 + 1);
			return;
		}
    }

    public void add(Integer str){
		heap.add(str);
		size++;
		pushUp(size);
    }

    public Integer remove(){
		if(size == 1){
			Integer str = heap.get(1);
			size--;
			heap.remove(1);
			return str;
		}
		Integer str = heap.get(1);
		heap.set(1, heap.remove(size));
		size--;
		pushDown(1);
		return str;
    }

    public void display(){
		for(Integer str : heap){
			System.out.print(str + " ");
		}
    }

}

