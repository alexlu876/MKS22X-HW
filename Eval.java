import java.util.*;
public class Eval{
    
    public static double eval(String s){
	String[] str = new String[s.length];
	str = s.split(" ");
	Stack s = new Stack();
        for(int i = 0; i < str.length; i++){
	    if(!(str[i].equals("+") || str[i].equals("*") || str[i].equals("/") || str[i].equals("-") || str[i].equals("%"))){
		s.push(Double.parseDouble(str[i]));
	    }
	    else{
		double b = s.pop();
		double a = s.pop();
		s.push(operate(a, b, str[i]));
	    }
	}
	return s.pop();
    }

    public static double operate(double a, double b, String op){
	if(op.equals("*")){
	    return a * b;
	}
	if(op.equals("/")){
	    return a / b;
	}
	if(op.equals("%")){
	    return a % b;
	}
	if(op.equals("+")){
	    return a + b;
	}
	if(op.equals("-")){
	    return a - b;
	}
	return 0.0;
    }

    public static void main(String[] a){
	String s = "8 11 +";
	System.out.println(eval(s));
    }
}
		
