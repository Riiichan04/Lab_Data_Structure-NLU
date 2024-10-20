package Lab2;

public class Task1_1 {
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return (int) Math.pow(-1, n+1) * n + getSn1(n-1);
		}
	}
	
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return factorial(n) + getSn2(n-1);
		}
	}
	
	public static int factorial (int n) {
		if (n==0) {
			return 1;
		}
		else {
			return factorial(n - 1) * n;
		}
	}
	
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n*n + getSn3(n-1);
		}
	}
	
	public static double getSn4(int n) {
		if (n == 0) {
			return 1.0;
		}
		else {
			return (double)1/(2*factorial(n)) + (double) 1/(2*factorial(n-1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getSn1(3));
		System.out.println(getSn2(3));
		System.out.println(getSn3(3));
		System.out.println(getSn4(3));
		
	}
}
