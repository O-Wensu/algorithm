import java.util.*;
import java.io.*;

public class Main {
    static class Assignment {
        private int deadline;
        private int score;

        public Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getScore() {
            return score;
        }
    }
    static int result = 0;
    static List<Assignment> assignments = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(tk.nextToken());
            int score = Integer.parseInt(tk.nextToken());
            assignments.add(new Assignment(deadLine, score));
        }

        Collections.sort(assignments, Comparator.comparing(Assignment::getScore).reversed().thenComparing(Assignment::getDeadline));

        int[] days = new int[1001];
        result = 0;

        for (Assignment assignment : assignments) {
            int deadline = assignment.getDeadline();

            // 이미 수행된 과제가 있는지 확인
            while (deadline > 0 && days[deadline] != 0) {
                deadline--;
            }

            // 과제를 수행할 수 있는 마감일이 있을 경우
            if (deadline > 0) {
                days[deadline] = assignment.getScore();
                result += assignment.getScore();
            }
        }

        System.out.println(result);
    }
}