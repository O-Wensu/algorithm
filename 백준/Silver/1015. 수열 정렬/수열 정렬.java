import java.util.*;
import java.io.*;

public class Main {
    static class Elem implements Comparable<Elem> {
        public int num, idx;

        @Override
        public int compareTo(Elem other) {
            return num - other.num;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        B = new Elem[N];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = Integer.parseInt(tk.nextToken());
            B[i].idx = i;
        }
    }

    static void pro() {
        Arrays.sort(B);
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb.toString());
    }
}