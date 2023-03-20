import java.io.*;
import java.util.*;

public class Main {

    static int size;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return;
        }
        int target = graph[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                continue;
            }
            if (!visited[nx][ny] && graph[nx][ny] == target) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                graph[i][j] = chars[j] - '0';
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }
        bw.write(count + " ");
        count = 0;
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == 'G' - '0') {
                    graph[i][j] = 'R' - '0';
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}