import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int count = 1;

    static void dfs(int x, int y) {
        if (x < 0 || x >= n + 1 || y < 0 || y >= m + 1) {
            return;
        }

        if (map[x][y] == 1) {
            map[x][y] = 0; //방문 완료

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n + 1 || ny < 0 || ny >= m + 1) continue;
                if (map[nx][ny] != 1) continue;
                dfs(nx, ny);
                count += 1;
            }
            max = Math.max(max, count);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken()); //세로
        m = Integer.parseInt(tk.nextToken()); //가로
        k = Integer.parseInt(tk.nextToken()); //쓰레기 개수
        map = new int[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            map[a][b] = 1; //쓰레기 존재
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (map[i][j] != 0) {
                    count = 1;
                    dfs(i, j);
                }
            }
        }
        System.out.println(max);
    }
}