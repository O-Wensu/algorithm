import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] map;
    static int[] sequence;
    static int seq = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new List[n + 1];
        sequence = new int[n + 1];

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

        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(sequence[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        sequence[node] = seq;

        for (int i = 0; i < map[node].size(); i++) {
            int next = map[node].get(i);
            if (sequence[next] == 0) {
                seq++;
                dfs(next);
            }
        }
    }
}