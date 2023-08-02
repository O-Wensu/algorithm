import java.util.*;
import java.io.*;

public class Main {
    static class Work {
        int time;
        int deadLine;

        public Work(int time, int deadLine) {
            this.time = time;
            this.deadLine = deadLine;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Work[] works = new Work[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(tk.nextToken());
            int deadLine = Integer.parseInt(tk.nextToken());
            works[i] = new Work(time, deadLine);
        }
        Arrays.sort(works, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if (o1.deadLine == o2.deadLine) {
                    return o1.time - o2.time;
                }
                return o2.deadLine - o1.deadLine;
            }
        });

        int prev_start = works[0].deadLine;
        for (Work work : works) {
            if (work.deadLine >= prev_start) {
                prev_start -= work.time;
                continue;
            }
            prev_start = work.deadLine - work.time;
        }
        if (prev_start < 0) System.out.println(-1);
        else System.out.println(prev_start);
    }
}