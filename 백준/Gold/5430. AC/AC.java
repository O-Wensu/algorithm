import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] commands = br.readLine().toCharArray();
            int size = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();
            boolean isLeft = true;
            boolean isError = false;

            StringTokenizer tk = new StringTokenizer(br.readLine(), "[],");
            while(tk.hasMoreTokens()) {
                deque.offer(tk.nextToken());
            }

            for (char command : commands) {
                if (command == 'R') {
                    isLeft = !isLeft;
                } else if (command == 'D') {
                    if (isLeft) {
                        if (deque.pollFirst() == null) {
                            bw.write("error\n");
                            isError = true;
                            break;
                        }
                    } else {
                        if (deque.pollLast() == null) {
                            bw.write("error\n");
                            isError = true;
                            break;
                        }
                    }
                }
            }

            if (isError) continue;

            bw.write("[");
            int tempSize = deque.size();
            for (int j = 0; j < tempSize; j++) {
                if (isLeft) {
                    if (j == tempSize - 1) bw.write(deque.pollFirst()+ "");
                    else bw.write(deque.pollFirst() + ",");
                } else {
                    if (j == tempSize - 1) bw.write(deque.pollLast()+ "");
                    else bw.write(deque.pollLast() + ",");
                }
            }
            bw.write("]\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}