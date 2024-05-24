import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] A;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new long[M + 1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            A[i] = Long.parseLong(tk.nextToken());
        }
    }

    static boolean determine(long length) {
        int cnt = 0;
        for (int i = 1; i <= M; i++) {
            cnt += A[i] / length;
        }
        return cnt >= N;
    }

    static void pro() {
        long L = 1, R = Integer.MIN_VALUE, ans = 0;
        for (int i = 1; i <= M; i++) R = Math.max(R, A[i]);
        while(L <= R) {
            long mid = (L + R) / 2;
            if (determine(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}