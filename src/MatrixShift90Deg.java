/**
 * Created by Jeet on 06-12-2016.
 */
public class MatrixShift90Deg {


    public static void main(String[] args) {
        shiftMatrix();
    }

    public static void shiftMatrix() {
        int m = 4, n = 4;
        int[][] matrix = new int[m][n];
        int k = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = k++;
        printMatrix(matrix);
        printMatrixIn90DShiftedOrder(matrix);
        shiftMatrix90D(matrix);


    }


    public static void printMatrixIn90DShiftedOrder(int[][] matrix) {
        System.out.println("Printing Shifted Matrix: ");
        for (int i = 0; i <= matrix[0].length - 1; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }


    public static void printMatrix(int[][] matrix) {
        System.out.println("Print Method()- Shifted Matrix: ");
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void shiftMatrix90D(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        int layers = matrix.length / 2;


        for (int i = 0; i < layers; i++) {
            int topRow = i;
            int bottomRow = row - 1 - i;
            int rightCol = col - 1 - i;
            int leftCol = i;
            for (int j = 0; j < col-1 - 2 * i; j++) {
                int temp = matrix[topRow][leftCol+j];

                matrix[topRow][leftCol+j]= matrix[bottomRow-j][leftCol];
                matrix[bottomRow-j][leftCol]=matrix[bottomRow][rightCol-j];

                matrix[bottomRow][rightCol-j]= matrix[topRow+j][rightCol];
                matrix[topRow+j][rightCol]= temp;

            }
        }
        printMatrix(matrix);

    }


}
