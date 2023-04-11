import java.util.*;
class Solution {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>() {{
            put("zero", 0); put("one", 1);
            put("two", 2); put("three", 3);
            put("four", 4); put("five", 5);
            put("six", 6); put("seven", 7);
            put("eight", 8); put("nine", 9);
        }};

        for (String numberStr : map.keySet()) {
            if (s.contains(numberStr)) {
                s = s.replace(numberStr, map.get(numberStr) + "");
            }
        }
        return Integer.parseInt(s);
    }
}