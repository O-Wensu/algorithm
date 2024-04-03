import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }
}