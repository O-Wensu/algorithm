import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        int zero = 0;
        List<Integer> lotto_list = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> win_list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        for (int lotto : lotto_list) {
            if (win_list.contains(lotto)) match++;
            else if (lotto == 0) zero++;
        }

        int firstPrize = getPrize(match + zero);
        int lastPrize = getPrize(match);
        return new int[]{firstPrize, lastPrize};
    }
    
        public int getPrize(int count) {
        if (count == 6) return 1;
        else if (count == 5) return 2;
        else if (count == 4) return 3;
        else if (count == 3) return 4;
        else if (count == 2) return 5;
        else return 6;
    }
}