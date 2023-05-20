import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[] frequency = new int[n];

        for (int i = 0; i < n; i++) {
            frequency[i] = Integer.parseInt(br.readLine());
        }

        int nowPos = a;
        int nowDiff = Integer.MIN_VALUE;
        int count = 0;
        for (int i : frequency) {
            nowDiff = Math.abs(nowPos - b);
            if (b == i) {
                System.out.println("1");
                return;
            }
            if (nowDiff > Math.abs(b - i)) {
                count = 1;
                nowPos = i;
            }
        }

        count += Math.abs(nowPos - b);;
        System.out.println(count);
    }
}