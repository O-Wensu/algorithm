import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        long m = Integer.parseInt(br.readLine()); //총 예산
        long[] budgets = new long[n]; //지방별 예산요청
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(tk.nextToken());
        }

        long start = 1;
        long end = Arrays.stream(budgets).max().getAsLong();
        long total = 0;
        long result = Integer.MIN_VALUE;

        while(start <= end) {
            long mid = (start + end) / 2; //상한액
            for (long budget : budgets) {
                if (budget > mid) total += mid;
                else total += budget;
            }
            if (total > m) {
                end = mid - 1;
            } else {
                result = Math.max(result, mid);
                start = mid + 1;
            }
            total = 0;
        }
        System.out.println(result);
    }
}