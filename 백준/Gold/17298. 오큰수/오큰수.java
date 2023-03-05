import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[size];
        int[] result = new int[size];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        for (int i = 0; i < size; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < size; i++) {
            if (result[i] == 0) bw.write("-1 ");
            else bw.write(result[i]+ " ");
        }
        bw.flush();
        bw.close();
    }
}