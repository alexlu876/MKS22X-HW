public class Recursion{
	
	public static final double epsilon = 0.0000000001;
	public static String name(){
		return "Lu,Alexander";
	}
	public static double sqrt(double n) throws IllegalArgumentException{
		if(n < 0){
			throw new IllegalArgumentException("No Negatives PLEASE! We don't deal with imaginary in Java");
		}
		if(n == 0.0){
		    return 0.0;
		}
		return sqrt(1, n);
	}
	public static double sqrt(double n, double a){
		if(n * n <= a + epsilon && n * n >= a - epsilon){
			return n;
		}
		return sqrt((((a / n) + n) / 2), a);
	}
	public static void main(String[] Args){
		System.out.println(sqrt(100));
		System.out.println(sqrt(4));
		System.out.println(sqrt(25));
		System.out.println(sqrt(-2));
	}
}
