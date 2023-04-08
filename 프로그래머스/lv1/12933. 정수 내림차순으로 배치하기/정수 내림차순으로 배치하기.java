import java.util.*;
class Solution {
    public long solution(long n) {
        String[] split = Long.toString(n).split("");
        Arrays.sort(split, Comparator.reverseOrder());
        String answer = "";
        for (String s : split) {
            answer += Integer.parseInt(s);
        }
        return Long.parseLong(answer);
    }
}