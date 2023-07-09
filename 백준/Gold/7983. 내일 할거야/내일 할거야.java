import java.util.*;
import java.io.*;

public class Main {
    static class Work {
        int day;
        int deadLine;

        public Work(int day, int deadLine) {
            this.day = day;
            this.deadLine = deadLine;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Work[] works = new Work[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(tk.nextToken());
            int t = Integer.parseInt(tk.nextToken());
            works[i] = new Work(d, t);
        }

        // 마감일 내림차순 정렬
        Arrays.sort(works, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o2.deadLine - o1.deadLine;
            }
        });

        int beforeLastWork = works[0].deadLine;

        for (Work work : works) {
            if (beforeLastWork > work.deadLine) {
                beforeLastWork = work.deadLine;
            }

            beforeLastWork -= work.day;
        }

        System.out.println(beforeLastWork);
    }
}