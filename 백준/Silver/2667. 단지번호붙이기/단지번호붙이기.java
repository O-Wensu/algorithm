import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] adj;
    static boolean[][] visit;
    static ArrayList<Integer> group = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                adj[i][j] = chars[j] - '0';
            }
        }
    }

    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (adj[nx][ny] == 0 || visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == 0 || visit[i][j]) continue;
                group_cnt = 0;
                dfs(i, j);
                group.add(group_cnt);
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (int i : group) sb.append(i).append('\n');
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb);
    }
}