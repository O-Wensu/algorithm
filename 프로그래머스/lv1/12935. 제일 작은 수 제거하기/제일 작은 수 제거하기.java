import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Integer integer = list.stream().min(Integer::compareTo).get();
        int index = list.indexOf(integer);
        list.remove(index);
        return list.stream().mapToInt(i -> i).toArray();
    }
}