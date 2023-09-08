import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int s = Integer.parseInt(tk.nextToken());
        int[] arr = new int[n];
        int count = 0;

        //초기화
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        //00001 ~ 11111
        for(int i = 1; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[n - 1 - j];
                }
            }
            if (sum == s) count++;
        }
        System.out.println(count);
    }
}