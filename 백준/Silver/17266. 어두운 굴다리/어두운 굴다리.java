import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] a;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        a = new int[M];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            a[i] = Integer.parseInt(tk.nextToken());
        }
    }

    static boolean determine(int height) {
        int L = a[0] - height, R = a[0] + height;
        if (L > 0) return false;
        for (int i = 1; i < M; i++) {
            int l = a[i] - height;
            int r = a[i] + height;
            if (R >= l) {
                R = r;
            } else return false;
        }
        if (R >= N) return true;
        return false;
    }

    static void pro() {
        int L = 0, R = N, ans = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (determine(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}