class Solution {
    public long solution(long n) {
        long x = (long) Math.sqrt(n);
        long pow = (long) Math.pow(x, 2);

        if (pow == n) {
            return (long) Math.pow(x + 1, 2);
        }
        return -1;
    }
}