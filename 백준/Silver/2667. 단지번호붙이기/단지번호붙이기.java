import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int count = 0;

    public static void dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= n) {
            return;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> results = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i,j);
                if (count != 0) {
                    results.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(results);
        bw.write(results.size() + "\n");
        for (Integer result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}