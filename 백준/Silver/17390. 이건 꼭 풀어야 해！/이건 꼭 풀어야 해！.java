import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int q = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] accumSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            accumSum[i + 1] = arr[i] + accumSum[i];
        }

        for (int i = 0; i < q; i++) {
            tk = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(tk.nextToken());
            int r = Integer.parseInt(tk.nextToken());
            bw.write(accumSum[r] - accumSum[l - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}