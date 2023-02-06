import java.util.*;
import java.io.*;

public class Main {

    static class Score {
        int first;
        int second;

        public Score(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getMin() {
            return Math.min(getFirst(), getSecond());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++) {
            int size = Integer.parseInt(br.readLine());
            List<Score> scores = new ArrayList<>();
            int min = 0;
            int count = 1;
            for (int j = 0; j < size; j ++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(token.nextToken());
                int second = Integer.parseInt(token.nextToken());
                scores.add(new Score(first, second));
            }
            scores.sort(Comparator.comparing(Score::getFirst));
            min = scores.get(0).getSecond();
            for (int k = 1; k < scores.size(); k++) {
                if (scores.get(k).getSecond() < min) {
                    count++;
                    min = scores.get(k).getSecond();
                }
            }
            bw.write(String.format("%d\n", count));
        }
        bw.flush();
        bw.close();
    }
}