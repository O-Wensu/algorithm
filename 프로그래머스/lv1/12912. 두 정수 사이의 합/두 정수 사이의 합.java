class Solution {
    public long solution(int a, int b) {
        long total = 0;
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        for (long i = min; i <= max; i++) {
            total += i;
        }
        return total;
    }
}