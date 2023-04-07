import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) throws IOException{
        int len = s.length();
        String answer = "";
        if (len % 2 == 0) {
            answer = s.substring((len / 2) - 1, (len / 2) + 1);
        } else {
            answer = s.substring((len / 2), (len / 2) + 1);
        }
        return answer;
    }
}