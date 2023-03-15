import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] dp;

    static int tri(int row, int col) {
        if (row == 0) {
            return dp[0][col];
        }
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        dp[row][col] = Math.max(tri(row - 1, col), tri(row - 1, col + 1)) + map[row][col];
        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][501];
        dp = new int[size][501];

        //초기화
        for (int i = map.length - 1; i >= 0; i--) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int j = 0;
            while(tk.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                j++;
            }
        }
        dp[0] = map[0];

        System.out.println(tri(size - 1, 0));
    }
}