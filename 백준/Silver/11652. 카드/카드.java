import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
    }

    static void pro() {
        Arrays.sort(nums);

        long most = nums[0];
        int mostCnt = 1, curCnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (curCnt > mostCnt) {
                mostCnt = curCnt;
                most = nums[i];
            }
        }
        System.out.println(most);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}