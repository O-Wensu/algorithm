import java.util.*;
import java.io.*;

public class Main {

    static class Conference {
        private int start;
        private int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Integer getEnd() {
            return end;
        }

        public Integer getStart() {
            return start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Conference> list = new ArrayList<>();
        int count = 0;
        int prev_end = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            list.add(new Conference(start, end));
        }

        list.sort(Comparator.comparing(Conference::getEnd).thenComparing(Conference::getStart));

        for (Conference conference: list) {
            if (prev_end <= conference.start) {
                prev_end = conference.end;
                count++;
            }
        }
        System.out.println(count);
    }
}
