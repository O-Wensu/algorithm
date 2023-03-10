import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String[] s = br.readLine().split("");
            String ans = "YES";

            for(String x : s) {
                if (x.equals("(")) {
                    stack.push(x);
                } else {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    else {
                        ans = "NO";
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) ans = "NO";
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}