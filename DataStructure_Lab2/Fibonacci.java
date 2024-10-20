package Lab2;

//Task 1.2
public class Fibonacci {
	public static int getFibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		else {
			return getFibonacci(n-1) + getFibonacci(n-2);
		}
	}
	
	public static void printFibonacci(int n) {
		if (n < 2) {
			System.out.print(getFibonacci(n) + " ");
		}
		else {
			System.out.print(getFibonacci(n) + " ");
			printFibonacci(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacci(4));
		printFibonacci(4);
	}
}
