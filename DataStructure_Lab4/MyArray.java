package lab4;

import java.util.Arrays;
import java.util.Random;

public class MyArray {
    //    Task 1.1
    public static void swap(int[] arr, int index1, int index2) {
        int num = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = num;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //    Task 1.2
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j+1]) swap(arr, j, j+1);
            }
        }
    }

    //    Task 1.3
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;

            while (j > 0 && arr[j-1] < key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }

    //    Task 2.1
    public static void mergeSort(int[] arr) {
        mergeSorting(arr, 0, arr.length - 1);
    }
    public static void mergeSorting(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSorting(arr, left, mid);
            mergeSorting(arr, mid+1, right);
            merge(arr, left, mid ,right);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] arrL = new int[m - l + 1];
        int[] arrR = new int[r - m];

        for (int i = 0; i < arrL.length; i++) {
            arrL[i] = arr[l + i];
        }

        for (int i = 0; i < arrR.length; i++) {
            arrR[i] = arr[m + 1 + i];
        }

        int i = 0; int j = 0;
        int cursor = l;

        while ( i < arrL.length && j < arrR.length) {
            if (arrL[i] > arrR[j]) {
                arr[cursor] = arrL[i];
                i++;
            }
            else {
                arr[cursor] = arrR[j];
                j++;
            }
            cursor++;
        }

        while (i < arrL.length) {
            arr[cursor] = arrL[i];
            i++;
            cursor++;
        }
        while (j < arrR.length) {
            arr[cursor] = arrR[j];
            j++;
            cursor++;
        }
    }

    //    Task 2.2
    public static void quickSort(int arr[]) {
        if (arr.length <= 1) return ;
        recursive(arr, 0, arr.length-1);
    }

    public static void recursive(int[] arr, int low, int high) {
        if (low < high) {
            int partiton = partition(arr, low, high);
            recursive(arr, low, partiton-1);
            recursive(arr, partiton+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = getPivot_Last(arr);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, high, i);
        return i;
    }

    private static int getPivot_MedianOfThree(int[] arr) {
        int sum = 0;
        if (arr.length < 3) {
            for (int i = 0; i < arr.length; i++) {
                sum += i;
            }
            return arr[sum/arr.length];
        }
        else {
            for (int i = 0; i < 3; i++) {
                sum += i;
            }
            return arr[sum/3];
        }
    }

    private static int getPivot_First(int[] arr) {
        return arr[0];
    }
    private static int getPivot_Last(int[] arr) {
        return arr[arr.length - 1];
    }
    private static int getPivot_Random(int[] arr) {
        Random ran = new Random();
        return arr[ran.nextInt(arr.length)];
    }
    public static void main(String[] args) {
        int[] arr = {23, 1, 23, 43, 65, 12};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
