import java.util.*;
import java.io.*;

public class Main {
    static int N, A, B, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(tk.nextToken());
        B = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void bfs(int start) {
        for (int i = 0; i <= N; i++) dist[i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);
        dist[start] = 0;

        while(!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) continue;
                Q.offer(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        dist = new int[N + 1];
        bfs(A);
        System.out.println(dist[B]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}