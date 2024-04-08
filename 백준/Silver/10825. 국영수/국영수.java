import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        public String name;
        public int kor, eng, math;

        @Override
        public int compareTo(Student other) {
            if (kor != other.kor) return other.kor - kor;
            if (eng != other.eng) return eng - other.eng;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Student[] students;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new Student[N];
        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            students[i] = new Student();
            students[i].name = tk.nextToken();
            students[i].kor = Integer.parseInt(tk.nextToken());
            students[i].eng = Integer.parseInt(tk.nextToken());
            students[i].math = Integer.parseInt(tk.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(students);

        for (int i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb.toString());
    }
}