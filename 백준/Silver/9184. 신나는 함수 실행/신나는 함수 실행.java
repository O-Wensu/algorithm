import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[51][51][51];

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a > 20 || b > 20 || c > 20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return dp[a][b][c];
        }
        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}