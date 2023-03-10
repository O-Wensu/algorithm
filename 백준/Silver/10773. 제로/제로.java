import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(br.readLine()));

        for (int i = 0; i < size - 1; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) stack.pop();
            else stack.push(n);
        }
        int sum = 0;
        for (Integer i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}