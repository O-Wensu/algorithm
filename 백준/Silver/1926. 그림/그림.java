import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {-0, 0, -1, 1};
    static int area = 0;
    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }

        if (map[x][y] == 1) {
            map[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) continue;
                dfs(nx, ny);
                area++;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken()); //행
        m = Integer.parseInt(tk.nextToken()); //열
        map = new int[n][m];
        int maxArea = Integer.MIN_VALUE;
        int areaCount = 0;

        boolean noPic = true;
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 1) noPic = false;
            }
        }

        if (noPic) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) areaCount++;
                maxArea = Math.max(maxArea, area);
                area = 0;
            }
        }

        System.out.println(areaCount);
        System.out.println(maxArea + 1);
    }
}