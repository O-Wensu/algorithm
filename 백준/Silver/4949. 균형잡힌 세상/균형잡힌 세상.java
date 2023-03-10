import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            String[] s = br.readLine().split("");
            if (s[0].equals(".")) break;
            String ans = "yes";
            Stack<String> stack = new Stack<>();

            for(String x : s) {
                if (x.equals("(") || x.equals("[")) {
                    stack.push(x);
                } else if (x.equals(")")){
                    if (!stack.isEmpty() && stack.peek().equals("(")){
                        stack.pop();
                    } else {
                        ans = "no";
                        break;
                    }
                } else if (x.equals("]")) {
                    if (!stack.isEmpty() && stack.peek().equals("[")){
                        stack.pop();
                    } else {
                        ans = "no";
                        break;
                    }
                } else if (x.equals(".")) {
                    break;
                }
            }

            if (!stack.isEmpty()) ans = "no";
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}