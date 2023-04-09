class Solution {
    public int solution(int n) {
        int answer = 0;
        String trans = "";
        while (n > 0) {
            trans += n % 3;
            n /= 3;
        }
        return Integer.parseInt(trans, 3);
    }
}