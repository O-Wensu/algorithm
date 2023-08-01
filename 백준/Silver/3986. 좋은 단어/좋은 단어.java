import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            stack.push(splits[0]);

            for (int j = 1; j < splits.length; j++) {
                String now = splits[j];
                if (!stack.isEmpty() && stack.peek().equals(now)) stack.pop();
                else stack.push(now);
            }
            if (stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}