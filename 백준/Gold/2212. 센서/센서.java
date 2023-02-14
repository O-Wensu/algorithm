import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] sensors = new int[n];
        int[] diff = new int[n-1];
        int sum = 0;

        if (n <= k) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(tk.nextToken());
            sensors[i] = temp;
        }
        Arrays.sort(sensors);

        for (int i = 0; i < n-1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < n-k; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}