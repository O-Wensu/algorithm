import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (now < arr[j]) {
                    break;
                }
                count++;
                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }
}