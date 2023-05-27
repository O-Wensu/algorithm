import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < arr[i]) {
                System.out.println(sum + 1);
                return;
            }
            sum += arr[i];
        }
        System.out.println(sum + 1);
    }
}