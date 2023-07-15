import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        Integer[] W = new Integer[10];
        Integer[] K = new Integer[10];

        W = initData(W);
        K = initData(K);

        int wScore = calcScore(W);
        int kScore = calcScore(K);

        System.out.println(wScore + " " + kScore);
    }

    public static Integer[] initData(Integer[] arr) throws IOException {
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        return arr;
    }

    public static int calcScore(Integer[] arr) {
        return arr[0] + arr[1] + arr[2];
    }
}