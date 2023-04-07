class Solution {
    public int solution(int[] a, int[] b) {
        int len = a.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}