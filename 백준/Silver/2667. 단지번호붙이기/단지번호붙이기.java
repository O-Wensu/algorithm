import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static int count = 0;

    public static boolean bfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= n) {
            return false;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;

            bfs(x-1, y);
            bfs(x+1, y);
            bfs(x,y-1);
            bfs(x, y+1);
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> results = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(i, j)) {
                    results.add(count);
                    count = 0;
                }
            }
        }
        results.sort(Comparator.comparingInt(Integer::intValue));
        bw.write(results.size() + "\n");
        for (Integer result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}