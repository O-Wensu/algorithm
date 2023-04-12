class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (countDivisor(i) % 2 == 0) sum += i;
            else sum -= i;
        }
        return sum;
    }
    
    public static int countDivisor(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}