import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(tk.nextToken()); //주어진 랜선 수
        long n = Integer.parseInt(tk.nextToken()); //필요한 랜선 수
        long[] arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Arrays.stream(arr).max().getAsLong();
        int total = 0;
        long result = Integer.MIN_VALUE;

        while(start <= end) {
            long mid = (start + end) / 2;
            for (long len : arr) {
                total += len / mid;
            }
            if (total < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = Math.max(result, mid);
            }
            total = 0;
        }
        System.out.println(result);
    }
}