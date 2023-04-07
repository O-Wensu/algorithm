class Solution {
    public long[] solution(int x, int n) {
        long[] result = new long[n];
        result[0] = x;
        for (long i = 1; i < n; i++) {
            result[(int) i] = x * (i + 1);
        }
        return result;
    }
}