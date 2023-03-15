import java.io.*;
import java.util.*;

public class Main {

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        cost = new int[size][3];
        dp = new int[size][3];

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(tk.nextToken());
            cost[i][1] = Integer.parseInt(tk.nextToken());
            cost[i][2] = Integer.parseInt(tk.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }
        int minCost = Math.min(dp[size-1][0], Math.min(dp[size-1][1], dp[size-1][2]));
        System.out.println(minCost);
    }
}