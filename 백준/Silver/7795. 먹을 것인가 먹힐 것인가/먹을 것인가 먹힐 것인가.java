import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] A, B;

    static void input() throws IOException {
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new int[N + 1];
        B = new int[M + 1];

        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(tk.nextToken());
        }
    }

    //a[L...R]에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
    static int lower_bound(int[] a, int L, int R, int X) {
        int result = L - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (a[mid] < X) {
                result = mid;
                L = mid + 1;
            } else if (a[mid] >= X) {
                R = mid - 1;
            }
        }
        return result;
    }

    static void pro() {
        Arrays.sort(B);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }
}