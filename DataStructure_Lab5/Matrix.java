package lab5;

import java.util.Arrays;

public class Matrix {
    public static boolean isSameSize(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != b[i].length) return false;
            }
            return true;
        }
    }
//    Task 1.1
    public static int[][] add(int[][] a, int[][] b) {
        if (isSameSize(a, b)) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] += b[i][j];
                }
            }
            return a;
        }
        else return null;
    }
//Task 1.2
    public static int[][] subtract(int[][] a, int[][] b) {
        if (isSameSize(a, b)) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] -= b[i][j];
                }
            }
            return a;
        }
        else return null;
    }

//    Task 1.3
    public static boolean isValid(int[][] a, int[][] b) {
        return a[0].length == b.length;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        if (isValid(a, b)) {
            int resultRow = a.length;
            int resultCol = b[0].length;
            int[][] result = new int[resultRow][resultCol];
            for (int i = 0; i < resultRow; i++) {
                for (int j = 0; j < resultCol; j++) {
                    for (int k = 0; k < a[i].length; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            return result;
        }
        else return null;
    }

//    Task 1.4
    public static int[][] transpose(int[][] a) {
        int[][] result = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] mat2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] mat3 = {{1, 3, 5}, {2, 4, 6}};
        System.out.println(Arrays.deepToString(multiply(mat1, mat2)));
        System.out.println(Arrays.deepToString(transpose(mat3)));
    }
}
