import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        V = Integer.parseInt(tk.nextToken());
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y = 1; y <= N; y++) {
            if (adj[x][y] == 0 || visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visit[x] = true;

        while(!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(' ');
            for (int y = 1; y <= N; y++) {
                if (adj[x][y] == 0 || visit[y]) continue;
                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        visit = new boolean[N + 1];
        bfs(V);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb);
    }
}