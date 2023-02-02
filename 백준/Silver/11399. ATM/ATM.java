import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);
        int[] prefixSum = getPrefixSum(arr);
        int sum = 0;
        for (Integer i: prefixSum) {
            sum += i;
        }
        System.out.println(sum);
    }

    static int[] getPrefixSum(int[] arr) {
        int size = arr.length;
        int[] prefixSum = new int[size];
        prefixSum[0] = arr[0];
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        return prefixSum;
    }
}
