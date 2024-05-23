import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    static boolean determine(long ml) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int remain = A[i];
            cnt += remain / ml;
        }
        return cnt >= K;
    }

    static long binSearch(long L, long R) {
        long ans = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determine(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    static void pro() {
        long L = 0, R = Integer.MAX_VALUE;
        System.out.println(binSearch(L, R));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}