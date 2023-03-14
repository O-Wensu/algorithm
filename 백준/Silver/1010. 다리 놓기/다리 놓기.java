import java.io.*;
import java.util.*;

//제출 안했음
public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == j || j == 0) dp[i][j] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int m = Integer.parseInt(tk.nextToken());


            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
                }
            }
            bw.write(dp[m][n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}