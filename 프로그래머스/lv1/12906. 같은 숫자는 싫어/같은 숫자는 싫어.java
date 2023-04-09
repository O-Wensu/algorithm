import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for (int i : arr) {
            if (prev == i) continue;
            list.add(i);
            prev = i;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}