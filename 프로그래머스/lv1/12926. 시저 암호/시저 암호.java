class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int pos = Integer.MIN_VALUE;
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                pos = ((int)c - 'A' + n) % 26 + (int)'A';
                sb.append((char)pos);
            } else if (Character.isLowerCase(c)) {
                pos = ((int)c - 'a' + n) % 26 + (int)'a';
                sb.append((char)pos);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}