import java.util.*;
class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] kPositions = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] copyArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copyArray);
            kPositions[i] = copyArray[command[2] - 1];
        }
        return kPositions;
    }
}