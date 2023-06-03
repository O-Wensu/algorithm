import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            //커서 기준 왼쪽 오른쪽
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char command : br.readLine().toCharArray()) {
                switch (command) {
                    //커서 왼쪽 이동
                    case '<':
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    //커서 오른쪽 이동
                    case '>':
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    //백스페이스
                    case '-' :
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default :
                        left.push(command);
                        break;
                }
            }
            left.stream().forEach(sb1::append);
            right.stream().forEach(sb2::append);
            sb2.reverse();
            bw.write(sb1.toString() + sb2.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}