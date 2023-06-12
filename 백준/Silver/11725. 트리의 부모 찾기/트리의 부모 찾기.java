import java.util.*;
import java.io.*;

public class Main {

    static List<ArrayList<Integer>> map = new ArrayList<>();
    static int[] parents;
    static boolean[] isVisited;

    public static void dfs(int x) {
        isVisited[x] = true;
        for (int i = 0; i < map.get(x).size(); i++) {
            int temp = map.get(x).get(i);
            if(!isVisited[temp]) {
                parents[temp] = x;
                dfs(temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(tk.nextToken());
            int v2 = Integer.parseInt(tk.nextToken());

            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}