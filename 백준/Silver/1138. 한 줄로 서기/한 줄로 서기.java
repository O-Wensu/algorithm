import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int[] line = new int[size];

        for (int i = 0; i < size; i++) {
            int temp = Integer.parseInt(token.nextToken());
            arr.add(temp);
        }

        for (int i = 0; i < size; i++) {
            int count = -1;
            int index = findIndex(line, 0);
            int pos = 0;
            for (int j = index; j < size; j++) {
                if (line[j] == 0) count++;

                if (count == arr.get(i)) {
                    pos = j;
                    break;
                }
            }
            line[pos] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i: line) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static int findIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }
}