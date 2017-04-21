import java.util.*;
public class Eval{
    
    public static double eval(String s){
	String[] str = s.split(" ");
	Stack st = new Stack();
        for(int i = 0; i < str.length; i++){
	    if(!(str[i].equals("+") || str[i].equals("*") || str[i].equals("/") || str[i].equals("-") || str[i].equals("%"))){
		Double x = new Double(Double.parseDouble(str[i]));
		st.push(x);
	    }
	    else{
		Double b = (Double)st.pop();
		Double a = (Double)st.pop();
		st.push(operate(a, b, str[i]));
	    }
	}
	return ((Double)st.pop()).doubleValue();
    }

    public static double operate(Double c, Double d, String op){
	double a = c.doubleValue();
	double b = d.doubleValue();
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
	String s = "16 8 % 11 +";
	System.out.println(eval(s));
    }
}
		
