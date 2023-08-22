import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static long[] depth;
    static long[] sequence;
    static int seq = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new List[n + 1];
        depth = new long[n + 1];
        sequence = new long[n + 1];
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
            Collections.sort(map[i]);
        }

        dfs(r, 0);
        long total = 0;
        for (int i = 1; i < n + 1; i++) {
            total += depth[i] * sequence[i];
        }
        System.out.println(total);
    }

    static void dfs(int node, int prev) {
        depth[node] = depth[prev] + 1;
        sequence[node] = seq;
        for (int i = 0; i < map[node].size(); i++) {
            int next = map[node].get(i);
            if (depth[next] == -1) {
                seq++;
                dfs(next, node);
            }
        }
    }
}