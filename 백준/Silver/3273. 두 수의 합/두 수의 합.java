import java.util.*;
import java.io.*;

public class Main {
    static int N, X, ans;
    static String nums;
    static Map<Integer, Integer> hashMap = new HashMap<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = br.readLine();
        X = Integer.parseInt(br.readLine());
    }

    static void pro() {
        StringTokenizer tk = new StringTokenizer(nums);
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tk.nextToken());
            if (hashMap.get(X - n) != null) ans++;
            else hashMap.put(n, 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(ans);
    }
}