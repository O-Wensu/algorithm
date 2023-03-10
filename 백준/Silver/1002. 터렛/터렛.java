import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tk.nextToken());
            int y1 = Integer.parseInt(tk.nextToken());
            int r1 = Integer.parseInt(tk.nextToken());
            int x2 = Integer.parseInt(tk.nextToken());
            int y2 = Integer.parseInt(tk.nextToken());
            int r2 = Integer.parseInt(tk.nextToken());
            int answer;

            double distance = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);

            // 중점과 반지름 같음
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                answer = -1;
            }
            // 두 원 반지름 합보다 거리가 더 큼 || 원 안에 원이 있고 접하지 않음
            else if (distance > Math.pow(r1 + r2, 2) || distance < Math.pow(r2 - r1, 2)) {
                answer = 0;
            }
            // 내접
            else if (distance == Math.pow(r1 - r2, 2)) {
                answer = 1;
            }
            // 외접
            else if (distance == Math.pow(r1 + r2, 2)) {
                answer = 1;
            }
            // 교차
            else {
                answer = 2;
            }
            System.out.println(answer);
        }
    }
}