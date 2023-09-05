import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] endDay = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            endDay[i] = (int) Math.ceil((float) (100 - progress) / speed);
        }
        List<Integer> releases = new ArrayList<>();
        releases.add(0);
        int lastRelease = endDay[0];
        for (Integer day : endDay) {
            if (day <= lastRelease) {
                int now = releases.get(releases.size() - 1);
                releases.set(releases.size() - 1, now + 1);
                continue;
            }
            releases.add(1);
            lastRelease = day;
        }
        return releases.stream().mapToInt(i -> i).toArray();
    }
}