class Solution {
    public boolean solution(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean answer = false;
        boolean isNumber = true;
        for (char c : chars) {
            if (!(48 <= (int)c && (int)c <= 57)) {
                isNumber = false;
                break;
            }
        }
        if (isNumber) {
            if (length == 4 || length == 6) answer = true;
        }
        return answer;
    }
}