import java.io.*;

public class Main {
    static int[][] dp = new int[41][2];

    static int[] fibo(int x) {
        if (dp[x][0] == Integer.MIN_VALUE || dp[x][1] == Integer.MIN_VALUE) {
            dp[x][0] = fibo(x-1)[0] + fibo(x-2)[0];
            dp[x][1] = fibo(x-1)[1] + fibo(x-2)[1];
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < 41; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(br.readLine());
            int[] result = fibo(x);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}