import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans = 0;
    static int[] A;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(br.readLine());
    }

    static boolean determination(int K) {
        int cnt = 1, remain = K;
        for (int i = 1; i <= N; i++) {
            if (remain < A[i]) {
                cnt++;
                remain = K - A[i];
            } else {
                remain -= A[i];
            }
        }
        return cnt <= M;
    }

    static void binSearch(int L, int R) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1; 
            } else {
                L = mid + 1;
            }
        }
    }

    static void pro() {
        int L = Integer.MIN_VALUE, R = 1000000000;
        for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);
        binSearch(L, R);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}