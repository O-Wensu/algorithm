class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int max_w = Integer.MIN_VALUE;
        int max_h = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            max_w = Math.max(max_w, w);
            max_h = Math.max(max_h, h);
        }
        return max_w * max_h;
    }
}