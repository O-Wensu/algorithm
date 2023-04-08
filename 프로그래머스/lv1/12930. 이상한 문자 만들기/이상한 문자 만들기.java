import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        String[] str = s.split("");

        for (String s1 : str) {
            if (s1.equals(" ")) {
                answer += " ";
                count = 0;
                continue;
            }
            answer += count % 2 == 0 ? s1.toUpperCase() : s1.toLowerCase();
            count++;
        }

        return answer;
    }
}