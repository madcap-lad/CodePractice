import com.sun.deploy.util.SystemUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Jeet on 06-12-2016.
 */
public class ClosestSumElementArray {

    public static void main(String[] args) {
        int[] arr = new int[]{11, 12, 2, 4, 8, 5, 6, 7, 11};
        (new ClosestSumElementArray()).getClosestSum(arr, 50);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        (new ClosestSumElementArray()).getClosestSum2(arr, 50);
    }

    public void getClosestSum(int[] arr, int n) {
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        int f = 0;
        int s = 0;
        int t = 0;

        for (int i = 0; i <= arr.length - 3; i++) {
            for (int j = i + 1; j <= arr.length - 2; j++) {
                if (arr[i] != arr[j]) {
                    for (int k = j + 1; k <= arr.length - 1; k++) {
                        if (arr[j] != arr[k] && arr[i] != arr[k]) {
                            int add = arr[i] + arr[j] + arr[k];
                            int diff = Math.abs(add - n);
                            minDiff = minDiff > diff ? diff : minDiff;
                            if (minDiff == diff) {
                                sum = add;
                                f = i;
                                s = j;
                                t = k;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(String.format("Closest sum- %d", sum));
        System.out.println(String.format("Respective indices-%d,%d,%d", f, s, t));
    }


    public void getClosestSum2(int[] arr, int n) {
        int len = arr.length - 1;
        int sum = 0, minDiff = Integer.MAX_VALUE;
        int first = 0, second = 0, third = 0;
        for (int i = 0; i < len - 1; i++) {
            int j = 0, k = len;
            while (j < k) {
                if (j == i) j++;
                if (arr[i] == arr[j]) j++;
                if (arr[j] == arr[k] || arr[i] == arr[k]) k--;

                if (i != j && j < k & k != i) {

                    int add = arr[i] + arr[j] + arr[k];
                    int diff = Math.abs(n - add);
                    if (diff < minDiff) {
                        sum = add;
                        first = i;
                        second = j;
                        third = k;
                    }
                    minDiff = diff < minDiff ? diff : minDiff;
                    if (add < n) j++;
                    else k--;
                }
            }

        }
        System.out.println(String.format("Program2- Closest sum- %d", sum));
        System.out.println(String.format("Program2- Respective indices-%d,%d,%d", first, second, third));
    }

}
