import java.io.*;

class Solution {
    public String solution(String phone_number) {
        char[] chars = phone_number.toCharArray();
        int len = phone_number.length();
        String answer = "";

        for (int i = 0; i < len - 4; i++) {
            answer += "*";
        }
        
        for (int i = len - 4; i < len; i++) {
            answer += chars[i];
        }

        return answer;
    }
}