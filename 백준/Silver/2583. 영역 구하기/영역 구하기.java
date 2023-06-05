import java.util.*;
import java.io.*;

public class Main {

    static int m, n, k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    static void dfs(int x, int y) {
        if (!checkRange(x, y)) return;

        if (map[x][y] == 0) {
            map[x][y] = 1; //방문

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!checkRange(nx, ny)) continue;
                if (map[nx][ny] == 1) continue;
                dfs(nx, ny);
                count++;
            }
        }
        return;
    }

    static boolean checkRange(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(tk.nextToken());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());
        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            tk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tk.nextToken());
            int y1 = Integer.parseInt(tk.nextToken());
            int x2 = Integer.parseInt(tk.nextToken());
            int y2 = Integer.parseInt(tk.nextToken());

            //왼쪽상단 기준 행과 열으로 변환
            int a1 = (m - 1) - y1;
            int b1 = x1;
            int a2 = (m - 1) - (y2 - 1);
            int b2 = x2 - 1;

            for (int j = a2; j <= a1; j++) {
                for (int l = b1; l <= b2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    areas.add(count + 1);
                }
            }
        }

        Collections.sort(areas);
        bw.write(areas.size() + "\n");
        for (Integer area : areas) {
            bw.write(area + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}