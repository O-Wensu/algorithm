import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] isVisited;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new ArrayList[n + 1];
        results = new int[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            map[u].add(v);
            map[v].add(u);
        }

        bfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (isVisited[i]) {
                sb.append(results[i]).append("\n");
                continue;
            }
            sb.append(-1).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        isVisited[node] = true;

        while(!q.isEmpty()) {
            node = q.poll();
            for (int i = 0; i < map[node].size(); i++) {
                int next = map[node].get(i);
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    results[next] = results[node] + 1;
                    q.offer(next);
                }
            }
        }
    }
}