import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        int SIZE = 20;
        for (int i = 0; i < P; i++) {
            int[] heights = new int[SIZE];
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(tk.nextToken());
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                heights[j] = Integer.parseInt(tk.nextToken());
            }

            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < j; k++) {
                    if (heights[k] > heights[j]) count++;
                }
            }
            bw.write(T + " " + count + "\n");
        }
        bw.flush();
    }
}