import java.util.*;
public class Deque{
    
    private String[] DeckOfString;
    private int head;
	private int tail;
	private int size;
	
    public Deque(){
		DeckOfString = new String[16];
		head = 0;
		tail = 0;
		size = 0;
    }

    private void resize(){
		String[] deq = new String[DeckOfString.length * 2];
		for(int i = 0; i < tail + 1; i++){
			deq[i] = DeckOfString[i];
		}
		for(int k = 0; k < size - tail - 1; k++){
			deq[deq.length - 1 - k] = DeckOfString[k + tail + 1];
		}
		DeckOfString = deq;
		head = 0;
		tail = size - 1;
    }

    public void addFirst(String str) throws NullPointerException{
		if (size == DeckOfString.length){
			resize();
		}
		if (size != 0){
			if(head == 0){
				head = DeckOfString.length - 1;
			}
			else{
				head -=1;
			}
		}
		DeckOfString[head] = str;
		size += 1;
    }

    public void addLast (String str) throws NullPointerException{
		if (size == DeckOfString.length){
			resize();
		}
		if (size!= 0){
			tail = (tail + 1) % (DeckOfString.length);
		}
        DeckOfString[tail] = str;
		size +=1;
    }

    public String removeFirst() throws NoSuchElementException{
		String popped = "";
		if(head == DeckOfString.length - 1){
			popped = getFirst();
			head = 0;
			DeckOfString[DeckOfString.length - 1] = null;
			size--;
		}
		else{popped = getFirst();
			DeckOfString[head] = null;
			head++;
			size--;
		}
		return popped;
    }
    
    public String removeLast() throws NoSuchElementException{
		String popped = "";
		if(tail == 0){
			popped = getLast();
			tail = DeckOfString.length - 1;
			DeckOfString[0] = null;
			size--;
		}
		else{
			popped = getLast();
			DeckOfString[tail] = null;
			tail -= 1;
			size--;
		}
		return popped;
    }

    public String getFirst() throws NoSuchElementException{
		String temp = "";
		temp = DeckOfString[head];
		return temp;
    }
    
    public String getLast() throws NoSuchElementException{
		String temp = "";
		temp = DeckOfString[tail];
		return temp;
    }

    public String toString(){
		String temp = "[";
		for(int i = 0; i < DeckOfString.length; i++){
			if(i + 1 == DeckOfString.length){
				if(DeckOfString[i] == null){		    
					temp +=  "null]";
					break;
				}
				else{
					temp += DeckOfString[i] + "]";
					break;
				}
			}
			if(DeckOfString[i] == null){
				temp += "null, ";
			}
			else{
				temp += DeckOfString[i] + ", ";
			}
		}
		return temp;
    }
}