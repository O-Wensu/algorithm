import java.io.*;

public class Main {
    static int[] dp;
    static int[] scores;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        dp = new int[size + 1];
        scores = new int[size + 1];

        for (int i = 1; i < size + 1; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];

        if (size > 1) {
            dp[2] = scores[1] + scores[2];
        }

        for (int i = 3; i < size + 1; i++) {
            dp[i] = Math.max(dp[i-3] + scores[i-1], dp[i-2]) + scores[i];
        }
        System.out.println(dp[size]);
    }
}