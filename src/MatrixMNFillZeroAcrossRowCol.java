import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeet on 08-12-2016.
 */
public class MatrixMNFillZeroAcrossRowCol {


    public static void main(String[] args) {
        int m = 4, n = 4;
        int[][] matrix = new int[m][n];
        int k = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = k++;

        int row = (int) (Math.random() * (m - 0));
        int col = (int) (Math.random() * (n - 0));
        matrix[row][col] = 0;
        printMatrix(matrix);
        setToZero(matrix);
    }


    public static void setToZero(int[][] matrix) {
        List<AbstractMap.SimpleImmutableEntry<Integer, Integer>> listOfIndices = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0)
                    listOfIndices.add(new AbstractMap.SimpleImmutableEntry(i, j));
            }

        for (AbstractMap.SimpleImmutableEntry entry : listOfIndices) {
            for (int i = 0; i <= col - 1; i++)
                matrix[(int) entry.getKey()][i] = 0;

            for (int i = 0; i <= row - 1; i++)
                matrix[i][(int) entry.getValue()] = 0;

        }

        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        System.out.println("Print Matrix: ");
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
