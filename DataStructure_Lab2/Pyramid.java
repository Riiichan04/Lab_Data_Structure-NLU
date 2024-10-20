package Lab2;

public class Pyramid {
	// Task 2.1
	public static void drawPyramid(int n) {
		if (n == 0) {
			System.out.println("X");
		} else
			drawRow(n, 0);
	}

	public static void drawRow(int n, int k) {
		for (int i = 0; i < n - k; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < 2 * k - 1; i++) {
			System.out.print("X");
		}
		if (n != k) {
			System.out.println();
		}
		if (n > k) {
			drawRow(n, k + 1);
		}
	}

	public static void printSpace(int n) {
		for (int i = 0; i < n - 1; i++) {
			System.out.print(" ");
		}
	}

	// Task 2.3
	public static void drawFoliage(int n, int space) {
		if (n == 0) {
			for (int i = 0; i < space - 1; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
		} else
			drawLeaf(n, 0, space);
	}

	public static void drawLeaf(int n, int k, int space) {
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < n - k; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < 2 * k - 1; i++) {
			System.out.print("*");
		}
		if (n != k) {
			System.out.println();
		}
		if (n > k) {
			drawLeaf(n, k + 1, space);
		}
	}

	public static void drawPineTree(int n) {
		drawTree(n, 1);
	}

	public static void drawTree(int n, int k) {
		drawFoliage(k, n - k);
		if (n > k) {
			drawTree(n, k + 1);
		} else {
			System.out.println();
			for (int j = 0; j < n - 1; j++) {
				for (int i = 0; i < k - 1; i++) {
					System.out.print(" ");
				}
				System.out.println("*");

			}
			for (int i = 0; i < 2 * k - 1; i++) {
				System.out.print("*");
			}
		}
	}

	public static void main(String[] args) {
		drawPyramid(3);
		System.out.println();
		drawPineTree(3);
	}
}
