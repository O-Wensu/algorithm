import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int reqMoney : d) {
            if (budget - reqMoney >= 0) {
                budget -= reqMoney;
                count++;
            } else break;
        }
        return count;
    }
}