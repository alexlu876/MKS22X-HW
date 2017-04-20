import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
	
	private class Itor implements Iterator<Integer>{
		MyLinkedList ll;
		LNode node;
		
		public Itor(MyLinkedList mine){
			ll = mine;
			node = ll.head;
		}
		
		public boolean hasNext(){
			return(node != null);
		}
		
		public Integer next()throws NoSuchElementException{
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			int temp = node.value;
			node = node.next;
			return temp;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<Integer> iterator(){
		return new Itor(this);
    }

    class LNode{
	
		int value;
		LNode prev;
		LNode next;
		
		public String toString(){
			return value + " ";
		}

		public LNode(int val){
			prev = null;
			value = val;
			next = null;
		}
	
		public LNode(int val, LNode nod){
			value = val;
			next = nod;
		}

		public LNode(int val, LNode node, LNode nod){
			value = val;
			next = node;
			prev = nod;
		}
    }
  
    LNode head;
    LNode tail;
    int size;

    public MyLinkedList(){
		head = null;
		tail = null;
		size = 0;
    }
	
	public int size(){
		return size;
	}
	
	public boolean add(int val){
		if(size == 0){
			LNode node = new LNode(val);
			head = node;
			tail = node;
			size++;
			return true;
		}
		LNode node = new LNode(val, tail, null);
		tail.next = node;
		size++;
		tail = node;       
		return true;
    }

    public void add(int i, int n){
		LNode a = new LNode(n);
		if (i > size || i < 0){
			throw new IndexOutOfBoundsException("Bad");
		}
		if(size == 0){
			head = a;
			tail = a;
		}
		else if(i == 0){
			a.next = head;
			head.prev = a;
			head = a;
		}
		else if(i == size){
			tail.next = a;
			a.prev = tail;
			tail = a;
		}
		else{
			getNthNode(i - 1).next = a;
			a.next = getNthNode(i);
			a.prev = getNthNode(i - 1);
			a.next.prev = a;
		}
		size++;
    }
	
	private void addAfter(LNode location, LNode toBeAdded){
	    if (location.next != null){
			toBeAdded.next = location.next;
			toBeAdded.next.prev = toBeAdded;
			location.next = toBeAdded;
			location.next.prev = location;
	    }
	    else {
			location.next = toBeAdded;
			location.next.prev = toBeAdded;
			toBeAdded.next = null;
			tail = toBeAdded;
	    }
	}
	
	public int indexOf(int value){
		int i = 0;
		for (LNode node = head; node != tail; node = node.next){
			if(node.value == value){
				return i;
			}
			i++;
		}
		return -1;
    }

	public int get(int index)throws IndexOutOfBoundsException{
		LNode n = null;
		n = getNthNode(index);
		return n.value;
    }

    private LNode getNthNode(int n)throws IndexOutOfBoundsException{
		LNode node = head;
		while (n-- > 0) {
			node = node.next;
		}
		return node;
    }
	
	public int set(int index, int newValue)throws IndexOutOfBoundsException{
		int temp = getNthNode(index).value;
		getNthNode(index).value = newValue;
		return temp;
    }
	
	public int remove(int index)throws IndexOutOfBoundsException{
		if(size == 1){
			int temp = head.value;
			head = null;
			tail = null;
			return temp;
		}	
		if(index == size - 1){
			LNode node1 = this.getNthNode(index);
			LNode node2 = this.getNthNode(index - 1);
			node2.next = null;
			tail = node2;
			size--;
			return node1.value;
		}	
		if(index == 0){
			LNode node1 = this.getNthNode(index);
			LNode node2 = this.getNthNode(index + 1);
			node2.prev = null;
			head = node2;
			size--;
			return node1.value;
		}	
		LNode x = this.getNthNode(index);
		LNode y = this.getNthNode(index - 1);
		LNode z = this.getNthNode(index + 1);
		y.next = z;
		z.prev = y;
		size--;
		return x.value;
	}
	
	public String toString(){
		if(size == 0){
			return "[]";
		}
		String str = "[";
		for(int i = 0; i < size; i++){
			if(i == size - 1){
				str += getNthNode(i).value + "]";
			}
			else{
			str += getNthNode(i).value + ", ";
			}
		}
	return str;
    }
}
	    

