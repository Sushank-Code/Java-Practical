import java.util.Scanner;

public class Ques2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1d array
        System.out.print("Enter size of 1D array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of 1D array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // for loop
        System.out.println("\n1D Array using for loop:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }

        // for-each loop
        System.out.println("\n1D Array using for-each loop:");
        for (int num : arr) {
            System.out.print(num + "\t");
        }

        // 2d array
        System.out.print("\n\nEnter rows of 2D array: ");
        int r = sc.nextInt();

        System.out.print("Enter columns of 2D array: ");
        int c = sc.nextInt();

        int[][] arr_2d = new int[r][c];
        System.out.println("Enter elements of 2D array:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr_2d[i][j] = sc.nextInt();
            }
        }

        // for loop
        System.out.println("\n2D Array using for loop:");
        for (int row = 0; row < arr_2d.length; row++) {
            for (int col = 0; col < arr_2d[row].length; col++) {
                System.out.print(arr_2d[row][col] + "\t");
            }
            System.out.println();
        }

        // for-each loop
        System.out.println("\n2D Array using for-each loop:");
        for (int[] row : arr_2d) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}