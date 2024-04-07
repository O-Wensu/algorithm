import java.io.*;
import java.util.*;

public class Main {
    static int N, S, ans;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        S = Integer.parseInt(tk.nextToken());
        nums = new int[N + 1];
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(tk.nextToken());
        }
    }

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) ans++;
        } else {
            rec_func(k + 1, value + nums[k]);
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, 0);
        if (S == 0) ans--;
        System.out.println(ans);
    }
}