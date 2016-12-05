/**
 * Created by Jeet on 06-12-2016.
 */
public class ClosestSumElementArray {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 2, 5, 6, 7, 10};
        (new ClosestSumElementArray()).getClosestSum(arr, 50);
    }

    public void getClosestSum(int[] arr, int n) {
        int sum = 0;
        int minDiff = 2147483647;
        int f = 0;
        int s = 0;
        int t = 0;

        for(int i = 0; i <= arr.length - 3; ++i) {
            for(int j = i + 1; j <= arr.length - 2; ++j) {
                if(arr[i] != arr[j]) {
                    for(int k = j + 1; k <= arr.length - 1; ++k) {
                        if(arr[j] != arr[k] && arr[i] != arr[k]) {
                            int add = arr[i] + arr[j] + arr[k];
                            int diff = Math.abs(add - n);
                            minDiff = minDiff > diff?diff:minDiff;
                            if(minDiff == diff) {
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

        System.out.println(String.format("Closest sum- %d", new Object[]{Integer.valueOf(sum)}));
        System.out.println(String.format("Respective indices-%d,%d,%d", new Object[]{Integer.valueOf(f), Integer.valueOf(s), Integer.valueOf(t)}));
    }

}
