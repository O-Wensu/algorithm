import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] number;

    static int find(int x) {
        //자신이 이전 값들보다 큰지 계속 검사
        if (dp[x] == 0){
            dp[x] = 1;

            for (int i = 0; i < x; i++) {
                if (number[i] < number[x]){
                    dp[x] = Math.max(dp[x], find(i) + 1);
                }
            }
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        number = new int[size];
        dp = new int[size];

        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            number[i] = Integer.parseInt(tk.nextToken());
        }
        dp[0] = 1;
        for (int i = 1; i < size; i++) {
            find(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}