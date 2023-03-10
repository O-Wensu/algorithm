import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] originalArray = new int[size];
        int[] sortedArray = new int[size];
        int pos = 0;

        for (int i = 0; i < size; i++) {
            originalArray[i] = Integer.parseInt(br.readLine());
        }
        sortedArray = originalArray.clone();
        Arrays.sort(sortedArray);

        for (int i : sortedArray) {
            stack.push(i);
            sb.append("+\n");
            if (!stack.isEmpty()) {
                while(stack.peek() == originalArray[pos]) {
                    stack.pop();
                    pos++;
                    sb.append("-\n");
                    if (stack.isEmpty()) break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }
        br.close();
    }
}