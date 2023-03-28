import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] arr;

    static int prefixSum(int x) {
        if (x < 0) return 0;
        if (dp[x] != 0) {
            return dp[x];
        }
        dp[x] = prefixSum(x - 1) + arr[x];
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken()); //수의 개수
        int m = Integer.parseInt(tk.nextToken()); //합을 구해야 하는 횟수

        dp = new int[n];
        arr = new int[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp[0] = arr[0];

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int toEnd = prefixSum(end - 1);
            if (start > 1) {
                int toStart = prefixSum(start - 2);
                bw.write((toEnd - toStart) + "\n");
                continue;
            }
            bw.write(toEnd + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}