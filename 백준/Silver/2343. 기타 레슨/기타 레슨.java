import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new int[N + 1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(tk.nextToken());
        }
    }

    static boolean determination(int size) {
        int cnt = 1, sum = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] <= size) {
                sum += A[i];
            } else {
                cnt++;
                sum = A[i];
            }
        }
        return cnt <= M;
    }

    static void pro() {
        int l = 1, r = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) l = Math.max(l, A[i]);

        while(l <= r) {
            int mid = (l + r) / 2;
            if (determination(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        sb.append(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb);
    }
}