import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop": {
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.pollFirst() + "\n");
                    break;
                }
                case "size": {
                    bw.write(q.size() + "\n");
                    break;
                }
                case "empty": {
                    if (q.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                }
                case "front": {
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.getFirst() + "\n");
                    break;
                }
                case "back": {
                    if (q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.getLast() + "\n");
                    break;
                }
                default: {
                    String[] arr = command.split(" ");
                    int n = Integer.parseInt(arr[1]);
                    q.offerLast(n);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}