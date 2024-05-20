import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int T, I, X, Y, EX, EY;
    static int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    static int[][] dist;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void init(int size) {
        dist = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dist[i][j] = -1;
            }
        }
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(X);
        Q.add(Y);
        dist[X][Y] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() throws IOException {
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            StringTokenizer tk = new StringTokenizer(br.readLine());
            X = Integer.parseInt(tk.nextToken());
            Y = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(br.readLine());
            EX = Integer.parseInt(tk.nextToken());
            EY = Integer.parseInt(tk.nextToken());
            init(I);
            bfs();
            System.out.println(dist[EX][EY]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}