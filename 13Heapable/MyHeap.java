import java.util.*;

public class MyHeap{

    private boolean minMax;
    private ArrayList<String> heap = new ArrayList<String>;

    public MyHeap(){
	minMax = true;
    }

    public MyHeap(boolean boolAndGood){
	minMax = boolAndGood;
    }

