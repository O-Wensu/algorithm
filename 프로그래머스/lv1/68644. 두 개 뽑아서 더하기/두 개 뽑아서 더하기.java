import java.util.*;
class Solution {
    public static int size;
    public static boolean[] isUsed;
    public static int[] arr = new int[2];
    public static int[] number;
    public static Set<Integer> ans = new HashSet<>();
    
    public static void dfs(int depth, int start) {
        if (depth == 2) {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            ans.add(sum);
            return;
        }

        for (int i = start; i < size; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = number[i];
                dfs(depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
    
    public int[] solution(int[] numbers) {
        size = numbers.length;
        isUsed = new boolean[size];
        number = new int[size];
        number = numbers;
        dfs(0,0);
        int[] sortedArr = ans.stream()
                .distinct()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
        return sortedArr;
    }
}