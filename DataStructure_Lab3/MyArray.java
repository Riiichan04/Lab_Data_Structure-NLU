package lab3;

//Task1.1
public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}
	
	public int iterativeLinearSreach(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) return i;
		}
		return -1;
	}
	
	public int recursiveLinearSreach(int target) {
		return recursLinearSreach(target, array.length-1);
	}
	public int recursLinearSreach(int target, int index) {
		if (index < 0) {
			return -1;
		}
		else {
			if (array[array.length - index - 1] == target) return array.length - index - 1;
			else return recursLinearSreach(target, index-1);
		}
	}
	
//	Task 1.2
	public int iterativeBinarySreach(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (array[mid] == target) return mid;
			else if (array[mid] > target) {
				high = mid-1;
			}
			else low = mid+1;
		}
		return -1;
	}
	
	
	public int recursiveBinarySreach(int target) {
		return recursiveBinary(target, 0, array.length);
	}
	
	public int recursiveBinary(int target, int low, int high) {
		if (low > high) return -1;
		else {
			int mid = (low + high) /2;
			if (target == array[mid]) {
				return mid;
			}
			else if (target < array[mid]) {
				return recursiveBinary(target, low, mid-1);
			}
			else return recursiveBinary(target, mid+1, high);
		}
	}
	
//	Task 1.3
	public int descendingBinarySreach(int target) {
		return desBinarySreach(target, 0, array.length);
	}
	
	public int desBinarySreach(int target, int low, int high) {
		if (low > high) return -1;
		else {
			int mid = (low + high) /2;
			if (target == array[mid]) {
				return mid;
			}
			else if (target > array[mid]) {
				return desBinarySreach(target, low, mid-1);
			}
			else return desBinarySreach(target, mid+1, high);
		}
	}
	
	public void print(int[]arr) {
		for (int ele : arr) System.out.print(ele + "  ");
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		MyArray myarr = new MyArray(arr);
		System.out.println(myarr.iterativeLinearSreach(6));
		System.out.println(myarr.recursiveLinearSreach(6));
		int[] arr2 = {7, 6, 5, 4, 3, 2, 1};
		MyArray myarr2 = new MyArray(arr2);
		System.out.println(myarr2.descendingBinarySreach(4));
		
	}
}
