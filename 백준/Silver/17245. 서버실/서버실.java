import java.util.*;
import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static long sum = 0;
    static int[][] A;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer tk;
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(tk.nextToken());
                sum += A[i][j];
                max = Math.max(max, A[i][j]);
            }
        }
    }

    static boolean determine(int sec) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] > sec) cnt += sec;
                else cnt += A[i][j];
            }
        }
        return ((double) cnt / sum) >= 0.5;
    }

    static void pro() {
        int L = 0, R = max;
        while(L + 1 < R) {
            int mid = (L + R) / 2;
            if (determine(mid)) {
                R = mid;
            } else {
                L = mid;
            }
        }
        System.out.println(R);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}