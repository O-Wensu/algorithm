import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[] isVisited;
    static int[] arr;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void dfs(int depth, int start) throws IOException{
        if (depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = i;
                dfs(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        isVisited = new boolean[n + 1];
        arr = new int[m];

        dfs(0, 1);
        bw.flush();
        bw.close();
        br.close();
    }
}