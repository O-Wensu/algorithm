import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] sortedArr;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sortedArr = Arrays.stream(arr).sorted().toArray();

        bw.write(arithmetic_mean() + "\n");
        bw.write(median() + "\n");
        bw.write(most_frequent() + "\n");
        bw.write(range() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int arithmetic_mean() {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (int) Math.round(sum / size);
    }

    public static int median() {
        return sortedArr[size / 2];
    }

    public static int most_frequent() {
        int count[] = new int[8001];
        int maxCount = 0; //최대 빈도수
        for (int i = 0; i < sortedArr.length; i++) {
            int index = sortedArr[i] + 4000;
            count[index]++;
            maxCount = Math.max(count[index], maxCount);
        }
        
        List<Integer> maxIndex = new ArrayList<>();
        for (int i = 0; i < count.length; i++)
            if (maxCount == count[i]) {
                maxIndex.add(i - 4000);
            }
        if (maxIndex.size() > 1) {
            return maxIndex.get(1);
        }
        return maxIndex.get(0);
    }

    public static int range() {
        int last = sortedArr[size - 1];
        int first = sortedArr[0];
        return Math.abs(last - first);
    }
}