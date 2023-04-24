import java.util.*;
import java.io.*;

public class Main {

    static class Tomato {
        int z;
        int x;
        int y;

        public Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    static int m, n, h;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static Queue<Tomato> queue = new LinkedList<>();

    static int bfs() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int z = tomato.z;
            int x = tomato.x;
            int y = tomato.y;

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (map[nz][nx][ny] == 0) {
                    queue.add(new Tomato(nz, nx, ny));

                    map[nz][nx][ny] = map[z][x][y] + 1;
                }
            }
        }

        int day = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) return -1;
                    day = Math.max(day, map[i][j][k]);
                }
            }
        }
        if (day == 1) return 0;
        return day - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(tk.nextToken()); //열
        n = Integer.parseInt(tk.nextToken()); //행
        h = Integer.parseInt(tk.nextToken()); //높이
        map = new int[h][n][m];

        boolean isZero = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tk = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(tk.nextToken());
                    if (map[i][j][k] == 1) queue.offer(new Tomato(i, j, k));
                    if (map[i][j][k] == 0) isZero = false;
                }
            }
        }

        if (isZero) {
            System.out.println("0");
            return;
        }

        int result = bfs();

        System.out.println(result);
    }
}