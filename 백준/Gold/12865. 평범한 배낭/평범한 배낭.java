import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] dp;
    static int[] weight;
    static int[] value;

    static Integer find(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {

            if (weight[i] <= k) {
                dp[i][k] = Math.max(find(i - 1, k), find(i - 1, k - weight[i]) + value[i]);
            } else {
                dp[i][k] = find(i - 1, k);
            }
        }
        return dp[i][k];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken()); //물품 개수
        int k = Integer.parseInt(token.nextToken()); //견딜 수 있는 무게
        dp = new Integer[n][k + 1];
        weight = new int[n];
        value = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(tk.nextToken());
            value[i] = Integer.parseInt(tk.nextToken());
        }

        int result = find(n - 1, k);
        System.out.println(result);
    }
}