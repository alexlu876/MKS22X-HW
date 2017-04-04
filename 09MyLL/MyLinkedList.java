public class MyLinkedList{

    class LNode{
	
	int value;
	LNode prev;
	LNode next;

	public LNode(int val){
	    prev = null;
	    value = val;
	    next = null;
	}

	public LNode(int val, LNode nod){
	    value = val;
	    next = nod;
	}

	public LNode(int val, LNode nod){
	    value = val;
	    prev = nod;
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

    public void add(int i, int n){
	LNode a = new LNode(n);
	if (i > size || i < 0){
	    throw new IndexOutOfBoundsException("Bad");
	}
	if(size == 0){
	    start = a;
	    end = a;
	}
	else if(i == 0){
	    a.next = start;
	    start.prev = a;
	    start = a;
	}
	else if(i == size){
	    tail.next = a;
	    a.prev = tail;
	    tail = a;
	}
	else{
	    getNode(i - 1).next = n;
	    n.next = getNode(i);
	    n.prev = getNode(i - 1);
	    n.next.prev = n;
	}
	size++;
    }

    public boolean add(int n){
	add(size, n);
    }

    public LNode getNode(int i){
	LNode n = start;
	for(int a = 0; a < i; a++){
	    n = n.next;
	}
	return n;
    }
}
	    

