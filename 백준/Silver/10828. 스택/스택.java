import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        //if 또는 switch 사용
        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop": {
                    if (stack.isEmpty()) bw.write("-1\n");
                    else bw.write(stack.pop() + "\n");
                    break;
                }
                case "size": {
                    bw.write(stack.size() + "\n");
                    break;
                }
                case "empty": {
                    if (stack.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                }
                case "top": {
                    if (stack.isEmpty()) bw.write("-1\n");
                    else bw.write(stack.peek() + "\n");
                    break;
                }
                default: {
                    String[] arr = command.split(" ");
                    int n = Integer.parseInt(arr[1]);
                    stack.push(n);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}