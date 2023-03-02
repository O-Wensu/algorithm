import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1 ,-1 ,1};

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= h || y < 0 || y >= w) return false;
        if (graph[x][y] == 1) {
            graph[x][y] = 0;

            for (int i = 0; i < dx.length; i++) {
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

        while (true) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            w = Integer.parseInt(tk.nextToken()); //열
            h = Integer.parseInt(tk.nextToken()); //행
            if (w == 0 || h == 0) break;
            graph = new int[h][w];

            for (int i = 0; i < h; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(tk.nextToken());
                }
            }
            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (dfs(i, j)) result++;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}