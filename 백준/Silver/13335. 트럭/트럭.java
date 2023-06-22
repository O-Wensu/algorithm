import java.util.*;
import java.io.*;

public class Main {
    static class Truck {
        int weight;
        int move = 1;

        public Truck(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken()); //트럭 수
        int w = Integer.parseInt(tk.nextToken()); //다리 길이
        int l = Integer.parseInt(tk.nextToken()); //다리 최대하중
        int[] trucks = new int[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(tk.nextToken());
        }

        Queue<Truck> bridge = new LinkedList<>();
        int hour = 0;
        int pos = 0;

        while (true) {
            hour++;
            if (pos == 0) {
                bridge.offer(new Truck(trucks[pos]));
                pos++;
                continue;
            }

            int nowWeight = 0;

            if (!bridge.isEmpty()) {
                //다리를 다 건넜으면 제거
                bridge.removeIf(truck -> truck.move + 1 > w);

                for (Truck truck : bridge) {
                    truck.move += 1;
                    nowWeight += truck.weight;
                }
            }

            //다리를 안 건넌 트럭이 있으면
            if (pos < n) {
                //(현재 다리 위 트럭 무게 + 다리 밖 트럭 무게 <= 최대 하중) 이면 추가
                if (nowWeight + trucks[pos] <= l) {
                    bridge.offer(new Truck(trucks[pos]));
                    pos++;
                }
            } else {
                //다리를 안 건넌 트럭이 없고, 다리 위에 트럭이 없으면 중지
                if (bridge.isEmpty()) break;
            }
        }
        System.out.println(hour);
    }
}