import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static Character[] numbers = new Character[]{'I','V','X','L'};
    static Character[] arr;
    static boolean[] isUsed = new boolean[4];
    static Set<Integer> result = new HashSet<>();
    public static void search(int depth, int start) {
        if (depth == size) {
            getNumber();
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            int index = i % 4;
            arr[depth] = numbers[index];
            search(depth + 1, i);
        }
    }

    public static void getNumber() {
        int answer = 0;
        for (Character c : arr) {
            if (c == 'I') answer += 1;
            else if (c == 'V') answer += 5;
            else if (c == 'X') answer += 10;
            else answer += 50;
        }
        result.add(answer);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new Character[size];

        search(0, 0);
        System.out.println(result.size());
    }
}