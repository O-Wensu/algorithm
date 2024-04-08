import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(tk.nextToken());
        }
    }

    static int binary_search(int[] arr, int l, int r, int k) {
        int res = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    static void pro() {
        Arrays.sort(nums, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            int candidate = binary_search(nums, left + 1, N, -nums[left]);

            if (left < candidate - 1 && Math.abs(nums[left] + nums[candidate - 1]) < best_sum) {
                best_sum = Math.abs(nums[left] + nums[candidate - 1]);
                v1 = nums[left];
                v2 = nums[candidate - 1];
            }

            if (candidate <= N && Math.abs(nums[left] + nums[candidate]) < best_sum) {
                best_sum = Math.abs(nums[left] + nums[candidate]);
                v1 = nums[left];
                v2 = nums[candidate];
            }

        }
        sb.append(v1).append(' ').append(v2);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb);
    }
}