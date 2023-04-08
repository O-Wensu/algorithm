import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = Integer.toString(n);
        char[] chars = str.toCharArray();
        int sum = 0;
        for(char c : chars) {
            sum += c - '0';
        }
        return sum;
    }
}