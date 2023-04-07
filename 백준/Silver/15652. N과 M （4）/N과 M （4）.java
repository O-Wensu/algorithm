import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] arr;

    public static void dfs(int depth, int start) throws IOException {
        if (depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        arr = new int[m];

        dfs(0, 1);
        bw.flush();
        bw.close();
        br.close();
    }
}