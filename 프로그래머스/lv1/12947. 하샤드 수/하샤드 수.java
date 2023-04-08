class Solution {
    public boolean solution(int x) {
        char[] chars = (x + "").toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        if (x % sum == 0) return true;
        return false;
    }
}