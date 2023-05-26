import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        private int no;
        private int start;
        private int end;

        public Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        PriorityQueue<Integer> classes = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(tk.nextToken());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            lectures.add(new Lecture(no, start, end));
        }

        //강의 시작 시간 오름차순 정렬
        Collections.sort(lectures, Comparator.comparing(Lecture::getStart).thenComparing(Lecture::getEnd));

        int count = Integer.MIN_VALUE;
        for (int i = 0; i < lectures.size(); i++) {
            while (!classes.isEmpty() && classes.peek() <= lectures.get(i).start) {
                classes.poll();
            }
            classes.offer(lectures.get(i).end);
            count = Math.max(count, classes.size());
        }
        System.out.println(count);
    }
}