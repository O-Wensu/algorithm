import java.util.*;
import java.io.*;

public class Main {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        //회의실 시작 시간 오름차순 정렬
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        pq.offer(meetings[0]);
        int answer = 1;
        for (int i = 1; i < n; i++) {
            while(!pq.isEmpty() && pq.peek().end <= meetings[i].start) pq.poll();
            pq.offer(meetings[i]);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}