import java.util.*;
import java.io.*;

public class Main {

    // 0: Red 1: Green 2: Blue
    static int[][] cost;
    static int[][] dp;

    static int paint(int x, int color) {
        if (dp[x][color] > 0) {
            return dp[x][color];
        }

        if (color == 0) { //Red
            dp[x][0] = Math.min(paint(x-1,1), paint(x-1,2)) + cost[x][0];
        } else if (color == 1) { //Green
            dp[x][1] = Math.min(paint(x-1,0), paint(x-1,2)) + cost[x][1];
        } else { //Blue
            dp[x][2] = Math.min(paint(x-1,0), paint(x-1,1)) + cost[x][2];
        }
        return dp[x][color];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        cost = new int[size][3]; //각 집 색상 cost
        dp = new int[size][3]; //최소 비용

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(tk.nextToken());
            cost[i][1] = Integer.parseInt(tk.nextToken());
            cost[i][2] = Integer.parseInt(tk.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        int red = paint(size - 1, 0);
        int green = paint(size - 1, 1);
        int blue = paint(size - 1, 2);
        int minCost = Math.min(red, Math.min(green, blue));

        System.out.println(minCost);
    }
}