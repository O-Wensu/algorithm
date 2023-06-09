import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }
            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    temp[left] = arr[j];
                    left++;
                } else {
                    temp[right] = arr[j];
                    right--;
                }
            }

            int max = Math.abs(temp[0] - temp[n - 1]);
            for (int j = 0; j < n - 1; j++) {
                max = Math.max(max, Math.abs(temp[j] - temp[j + 1]));
            }
            bw.write(max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}