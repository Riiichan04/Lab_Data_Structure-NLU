package Lab1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

//	Task 1.1
	public int[] mirror() {
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[array.length + i] = array[array.length - 1 - i];
		}

		return result;
	}

	public int[] removeDuplicates() {
		int[] tempArray = new int[array.length];
		int cursor = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0 && indexOf(tempArray, array[i]) == cursor) {
				tempArray[cursor] = array[i];
				cursor++;
			}
			if (!isDuplicate(tempArray, array[i])) {
				tempArray[cursor] = array[i];
				cursor++;
			}
		}
		int[] result = new int[cursor];
		for (int i = 0; i < result.length; i++) {
			result[i] = tempArray[i];
		}
		return result;
	}

	public boolean isDuplicate(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(int[] array, int checkValue) {
		for (int i = 0; i < array.length; i++) {
			if (checkValue == array[i]) {
				return i;
			}
		}
		return -1;
	}

//	Task 1.2
	public int[] getMissingValues() {
		int index = 0;
		int[] tempArray = new int[array.length];
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array[i] + 1; j < array[i + 1]; j++) {
				tempArray[index] = j;
				index++;
			}
		}

		int[] result = new int[index];
		for (int i = 0; i < result.length; i++) {
			result[i] = tempArray[i];
		}
		return result;
	}

	public int[] fillMissingValues(int k) {
		int[] listIndex = new int[array.length];
		int cursor = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if ( array[i] == -1 || (array[i-1] > array[i] && indexOf(listIndex, i) != -1)) {
				listIndex[cursor++] = i;
				// Ngoại lệ
				if (i < k || array.length - k <= i) {
					if (i == 0) {
						for (int j = 1; j < k + 1; j++) {
							sum += array[j];
						}
					}
					else if (i == array.length - 1) {
						for (int j = array.length - 2; j > array.length - 1 - k; j--) {
							sum+= array[j];
						}
					}
					else if (i < k/2) {
						for (int j = 0; j < i; j++) {
							sum += array[j];
						}
						for (int j = i + 1; j < k - i + 1; j++) {
							sum += array[j];
						}
					}
					else if (i > array.length - k/2) {
						for (int j = array.length - 1; j > i; j--) {
							sum += array[j];
						}
						for (int j = i - 1; j > i - k; j--) {
							sum+= array[j];
						}
					}
					sum /= k;
					array[i] = sum;

				}
				// Chạy chính
				else {
					for (int j = 1; j < k/2 + 1; j++) {
						sum += array[i - j];
						sum += array[i + j];
					}
					if (k % 2 == 1) {
						if (array[i - k/2 - 1] > array[i + k/2 + 1] && isValidDigit(array, i + k/2 + 1)) {
							sum+= array[i + k/2 + 1];
						}
						else if (indexOf(listIndex, i - k/2 - 1) != -1 && i - k/2 - 1 != 0) {
							sum += array[i + k/2 + 1];
						}
						else sum += array[i - k/2 - 1];
					}
					sum /= k;
					array[i] = sum;
				}
			}
		}

		return array;
	}
	
	public boolean isValidDigit(int[] array, int index) {
		if (index == 0) return true;
		else if (array[index] > array[index-1]) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray myarr1 = new MyArray(arr1);
		MyArray myarr2 = new MyArray(arr2);
		int[] res1 = myarr1.mirror();
		int[] res2 = myarr2.removeDuplicates();
		for (int ele : res2) {
			System.out.print(ele + " ");
		}
		System.out.println();
		int[] arr3 = { 10, 11, 12, 15, 16 };
		MyArray myarr3 = new MyArray(arr3);
		int[] res3 = myarr3.getMissingValues();
		for (int ele : res3) {
			System.out.print(ele + " ");
		}
		System.out.println();
		int[] arr4 = { - 1, 10, 11, 12, 14, 10, 17, 19, 20};
		MyArray myarr4 = new MyArray(arr4);
		int[] res4 = myarr4.fillMissingValues(3);
		for (int ele : res4) {
			System.out.print(ele + " ");
		}
	}
}
