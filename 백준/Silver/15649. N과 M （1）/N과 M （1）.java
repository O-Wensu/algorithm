import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static boolean[] visited;
    public static int[] arr;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void dfs(int index) throws IOException {
        if (index == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[index] = i;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0);
        bw.flush();
        bw.close();
        br.close();
    }
}