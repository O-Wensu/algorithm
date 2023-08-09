import java.util.*;
import java.io.*;

public class Main {
    static class Homework {
        private int score;
        private int time;

        public Homework(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    static Stack<Homework> stack = new Stack<>();
    static int totalScore = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.startsWith("0")) {
                doWork();
                continue;
            }
            String[] splits = str.split(" ");
            int score = Integer.parseInt(splits[1]);
            int time = Integer.parseInt(splits[2]);
            stack.push(new Homework(score, time));
            doWork();
        }
        System.out.println(totalScore);
    }

    static void doWork() {
        if (stack.isEmpty()) return;
        stack.peek().time -= 1;
        if (stack.peek().time == 0) {
            Homework work = stack.pop();
            totalScore += work.score;
        }
    }
}