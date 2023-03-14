import java.io.*;
import java.util.*;

public class Main {
    static Long[] dp = new Long[101];

    public static Long padovan(int x) {
        if (dp[x] != null) {
            return dp[x];
        }

        if (x <= 0) {
            return 0L;
        }

        dp[x] = padovan(x - 1) + padovan(x - 5);

        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        dp[1] = dp[2] = dp[3] = 1L;
        dp[4] = dp[5] = 2L;

        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(br.readLine());
            Long result = padovan(x);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}