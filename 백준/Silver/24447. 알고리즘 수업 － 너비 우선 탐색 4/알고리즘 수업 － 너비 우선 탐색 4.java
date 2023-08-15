import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] map;
    static long[] sequence;
    static long[] depth;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new List[n + 1];
        sequence = new long[n + 1];
        depth = new long[n + 1];
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

        bfs(r);
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += depth[i] * sequence[i];
        }
        System.out.println(sum);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        long seq = 1;
        sequence[node] = seq;
        depth[node] = 0;

        while(!q.isEmpty()) {
            node = q.poll();
            for (int i = 0; i < map[node].size(); i++) {
                int next = map[node].get(i);
                if (depth[next] == -1) {
                    seq++;
                    sequence[next] = seq;
                    depth[next] = depth[node] + 1;
                    q.offer(next);
                }
            }
        }
    }
}