package lab3;

import java.util.*;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double sum = 0;
		for (OrderItem element : items) {
			sum += element.getProduct().getPrice();
		}
		return sum;
	}

	public boolean contains(Product p) {
		Arrays.sort(items, new Comparator<OrderItem>() {
			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				return o1.getProduct().getId().compareTo(o2.getProduct().getId());
			}
		});
		return sreachProduct(p, 0, items.length);
	}

	public boolean sreachProduct(Product p, int low, int high) {
		if (low > high)
			return false;
		else {
			int mid = (low + high) / 2;
			int compare = items[mid].compareTo(p);
			if (compare == 0) {
				return true;
			}
//			Target > mid
			else if (compare > 0) {
				return sreachProduct(p, mid + 1, high);
			}
//			Target < mid
			else
				return sreachProduct(p, low, mid - 1);
		}
	}

	public Product[] filter(String type) {
		boolean[] listIndex = new boolean[items.length];
		int cursor = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getProduct().getType().equals(type)) {
				listIndex[i] = true;
				cursor++;
			} else
				listIndex[i] = false;
		}
		Product[] result = new Product[cursor];
		cursor = 0;
		for (int i = 0; i < items.length; i++) {
			if (listIndex[i] == true) {
				result[cursor++] = items[i].getProduct();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Product[] list = { new Product("AAA", "A", 0.2, "B"), new Product("BBB", "BB", 1.2, "B"),
				new Product("101", "CC", 2.3, "C") };
		int[] listQuantity = { 12, 13, 4 };

		OrderItem[] listItem = new OrderItem[list.length];
		for (int i = 0; i < list.length; i++) {
			listItem[i] = new OrderItem(list[i], listQuantity[i]);
		}
		Order order = new Order(listItem);

		System.out.println(order.contains(new Product("BBB", "BB", 1.2, "B")));
		System.out.println(order.filter("B").length);

//		Test 1.4 Lab4
		order.mergeSortOrder(listItem);
		for (OrderItem ele : listItem) {
			System.out.println(ele.getProduct().getName());
		}
	}

//	Task 1.4 Lab4
	public void mergeSortOrder(OrderItem[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public void sort(OrderItem[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	public void merge(OrderItem[] arr, int left, int mid, int right) {
		OrderItem[] leftArr = new OrderItem[mid - left + 1];
		OrderItem[] rightArr = new OrderItem[right - mid];
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}

//		Index to check 2 sub arrays
		int i = 0, j = 0;
//		Cursor to put element back to original array
		int cursor = left;
		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i].compareTo(rightArr[j].getProduct()) > 0) {
				arr[cursor] = leftArr[i];
				i++;
			} else {
				arr[cursor] = rightArr[j];
				j++;
			}
			cursor++;
		}

		while (i < leftArr.length) {
			arr[cursor] = leftArr[i];
			i++;
			cursor++;
		}

		while (j < rightArr.length) {
			arr[cursor] = rightArr[j];
			j++;
			cursor++;
		}
	}
}
