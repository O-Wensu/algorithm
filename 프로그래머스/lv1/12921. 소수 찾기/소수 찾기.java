class Solution {
    public int solution(int n) {
        boolean[] noPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (noPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                noPrime[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!noPrime[i]) count++;
        }
        return count;
    }
}