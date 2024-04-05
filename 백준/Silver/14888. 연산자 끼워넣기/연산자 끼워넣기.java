import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, max, min;
    static int[] nums, operations, order;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        operations = new int[5];
        order = new int[N + 1];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) operations[i] = Integer.parseInt(tk.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int calculator() {
        int value = nums[1];
        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1) value += nums[i + 1]; 
            if (order[i] == 2) value -= nums[i + 1];
            if (order[i] == 3) value *= nums[i + 1];
            if (order[i] == 4) value /= nums[i + 1]; 
        }
        return value;
    }

    static void rec_func(int k) {
        if (k == N) { 
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operations[cand] >= 1) {
                    operations[cand]--;
                    order[k] = cand;
                    rec_func(k + 1);
                    operations[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}