import java.util.*;

class Solution {
    public int solution(String s) {
        int[] num = new int[]{0,1,2,3,4,5,6,7,8,9};
        String[] numStr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < num.length; i++) {
            s = s.replace(numStr[i], num[i] + "");
        }
        return Integer.parseInt(s);
    }
}

// class Solution {
//     public int solution(String s) {
//         //딕셔너리 사용
//         Map<String, Integer> map = new HashMap<>() {{
//             put("zero", 0); put("one", 1);
//             put("two", 2); put("three", 3);
//             put("four", 4); put("five", 5);
//             put("six", 6); put("seven", 7);
//             put("eight", 8); put("nine", 9);
//         }};

//         for (String numberStr : map.keySet()) {
//             if (s.contains(numberStr)) {
//                 s = s.replace(numberStr, map.get(numberStr) + "");
//             }
//         }
//         return Integer.parseInt(s);
//     }
// }