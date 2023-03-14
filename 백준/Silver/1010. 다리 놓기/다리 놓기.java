import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dp = new int[30][30];

    public static int combination(int m, int n) {
        if (dp[m][n] > 0) {
            return dp[m][n];
        }
        
        if (n == 0 || m == n) {
            return 1;
        }
        
        return dp[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int m = Integer.parseInt(tk.nextToken());

            int result = combination(m, n);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}