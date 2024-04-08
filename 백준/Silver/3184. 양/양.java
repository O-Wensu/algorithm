import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int R, C, liveSheep, liveWolf, sheep, wolf;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static String[] a;
    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());
        a = new String[R];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            a[i] = br.readLine();
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        if (a[x].charAt(y) == 'o') sheep++;
        else if (a[x].charAt(y) == 'v') wolf++;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (a[nx].charAt(ny) == '#' || visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j] || a[i].charAt(j) == '#') continue;
                sheep = 0;
                wolf = 0;
                dfs(i, j);
                if (sheep > wolf) liveSheep += sheep;
                else liveWolf += wolf;
            }
        }
        sb.append(liveSheep).append(' ').append(liveWolf);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb);
    }
}