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

        @Override
        public String toString() {
            return "Assignment{" +
                    "deadline=" + deadline +
                    ", score=" + score +
                    '}';
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

        //점수 오름차순, 점수 같으면 마감일 내림차순
        Collections.sort(assignments, Comparator.comparing(Assignment::getScore).reversed().thenComparing(Assignment::getDeadline));


        // 마감일에 근거하여 과제를 수행하기 위한 배열 생성
        boolean[] days = new boolean[1001];
        result = 0;

        for (Assignment assignment : assignments) {
            int deadline = assignment.getDeadline();

            // 이미 수행된 과제가 있는지 확인
            while (deadline > 0 && days[deadline]) {
                deadline--;
            }

            // 과제를 수행할 수 있는 마감일이 있을 경우
            if (deadline > 0) {
                days[deadline] = true;
                result += assignment.getScore();
            }
        }

        System.out.println(result);
    }
}