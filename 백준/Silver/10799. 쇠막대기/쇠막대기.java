import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push('(');
            else {
                stack.pop();
                if (chars[i - 1] == '(') sum += stack.size();
                else sum += 1;
            }
        }
        System.out.println(sum);
    }
}