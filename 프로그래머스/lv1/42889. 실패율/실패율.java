import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Float> stagePercentages = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            stagePercentages.put(i, calcFailPercentage(i, stages));
        }
        List<Map.Entry<Integer, Float>> percentageList = new ArrayList<>(stagePercentages.entrySet());
        Collections.sort(percentageList, new Comparator<Map.Entry<Integer, Float>>() {
            @Override
            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] answer = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Float> entry : percentageList) {
            answer[index++] = entry.getKey();
        }
        return answer;
    }
    public static float calcFailPercentage(int stageNum, int[] stages) {
        int tryCount = 0;
        int failCount = 0;
        for (int stage : stages) {
            if (stage >= stageNum) tryCount++;
            if (stage == stageNum) failCount++;
        }
        if (tryCount == 0) {
            return 0;
        }
        return (float) failCount / (float) tryCount;
    }
}