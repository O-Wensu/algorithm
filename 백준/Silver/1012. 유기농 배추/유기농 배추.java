import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;

        if (graph[x][y] == 1) {
            graph[x][y] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            m = Integer.parseInt(tk.nextToken());
            n = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken());
            graph = new int[n][m];
            int count = 0;

            for (int j = 0; j < k; j++) {
                tk = new StringTokenizer(br.readLine());
                int mm = Integer.parseInt(tk.nextToken());
                int nn = Integer.parseInt(tk.nextToken());
                graph[nn][mm] = 1;
            }

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dfs(a, b)) count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}