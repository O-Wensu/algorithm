class Solution {
    boolean solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        for (char c : chars) {
            if (c == 'p') pCount++;
            else if (c == 'y') yCount++;
        }
        if (pCount != yCount) answer = false;
        return answer;
    }
}