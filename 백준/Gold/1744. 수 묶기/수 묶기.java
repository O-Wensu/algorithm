import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) positive.add(num);
            else negative.add(num);
        }

        //1이상 내림차순 정렬
        Collections.sort(positive, Collections.reverseOrder());
        //0이하 오름차순 정렬
        Collections.sort(negative);

        System.out.println(calculate(positive) + calculate(negative));
    }

    public static int calculate(List<Integer> list) {
        boolean[] isUsed = new boolean[list.size()];
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!isUsed[i]) {
                if (i == list.size() - 1) {
                    total += list.get(i);
                    break;
                }
                int sum = list.get(i) + list.get(i + 1);
                int multiply = list.get(i) * list.get(i + 1);
                int max = Math.max(sum, multiply);

                if (sum != multiply && multiply == max) {
                    isUsed[i] = true;
                    isUsed[i + 1] = true;
                    total += max;
                    continue;
                }
                total += list.get(i);
            }
        }
        return total;
    }
}