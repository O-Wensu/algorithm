import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = new int[]{1, 2, 3, 4, 5};
        int[] person2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] result = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) result[0]++;
            if (answers[i] == person2[i % 8]) result[1]++;
            if (answers[i] == person3[i % 10]) result[2]++;
        }

        List<Integer> ans = new ArrayList<>();
        int max = Math.max(result[0], Math.max(result[1], result[2]));
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) ans.add(i + 1);
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}