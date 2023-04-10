import java.util.*;
class Solution {
    public static final int SIZE = 3;
    public static int[] arr = new int[SIZE];
    public static boolean[] isUsed;
    public static List<Integer> sums = new ArrayList<>();
    public static boolean[] noPrime;
    
    public int solution(int[] nums) {
        isUsed = new boolean[nums.length];
        dfs(nums,0,0);
        int max = Integer.MIN_VALUE;
        for (int num : sums) {
            max = Math.max(num, max);
        }
        getPrime(max);
        int count = 0;
        for (int num : sums) {
            if(!noPrime[num]) count++;
        }
        return count;
    }
    
    public void dfs(int[] nums, int depth, int start) {
        if (depth == SIZE) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            sums.add(sum);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = nums[i];
                dfs(nums, depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
    
    public void getPrime(int max) {
        noPrime = new boolean[max + 1];
        noPrime[0] = true;
        noPrime[1] = true;
        for (int i = 0; i * i <= max; i++) {
            if (noPrime[i]) continue;
            for (int j = i * i; j <= max; j += i) {
                noPrime[j] = true;
            }
        }
    }
}