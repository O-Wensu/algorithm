import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] map;
    static int[] depth;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new List[n + 1];
        depth = new int[n + 1];
        Arrays.fill(depth, -1);

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

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(map[i], Collections.reverseOrder());
        }

        dfs(r, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(depth[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node, int prev) {
        depth[node] = depth[prev] + 1;
        for (int i = 0; i < map[node].size(); i++) {
            int next = map[node].get(i);
            if (depth[next] == -1) {
                dfs(next, node);
            }
        }
    }
}