import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> initArray(int size, StringTokenizer token) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(token.nextToken()));
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int sum = 0;

        StringTokenizer token1 = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        List<Integer> arrA = initArray(size, token1);
        List<Integer> arrB = initArray(size, token2);

        Collections.sort(arrA);
        arrB.sort(Collections.reverseOrder());
        
        for (int i = 0; i < arrA.size(); i++) {
            sum += arrA.get(i) * arrB.get(i);
        }
        System.out.println(sum);
    }
}
