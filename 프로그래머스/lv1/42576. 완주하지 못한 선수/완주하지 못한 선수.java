import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        String answer = "";
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])){
                answer = participant[i];
                return participant[i];
            }
        }
        int len = participant.length;
        return participant[len - 1];
    }
}