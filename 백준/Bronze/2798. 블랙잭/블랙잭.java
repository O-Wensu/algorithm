import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] cards = new int[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(tk.nextToken());
        }

        int sum = 0;
        int prevDiff = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int nowSum = cards[i] + cards[j] + cards[k];
                    if (nowSum <= m) {
                        int diff = m - nowSum;
                        int minDiff = Math.min(prevDiff, diff);
                        sum = m - minDiff;
                        prevDiff = minDiff;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}