import java.util.*;
import java.io.*;

public class Main {

    public static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = 2; j < x + 1; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }
            bw.write(dp[x][0] + " " + dp[x][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}