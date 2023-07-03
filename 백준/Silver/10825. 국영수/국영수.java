import java.util.*;
import java.io.*;

public class Main {
    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            String name = tk.nextToken();
            int ko = Integer.parseInt(tk.nextToken());
            int en = Integer.parseInt(tk.nextToken());
            int math = Integer.parseInt(tk.nextToken());

            students[i] = new Student(name, ko, en, math);
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean < o2.korean) {
                    return 1;
                }else if(o1.korean == o2.korean) {
                    if(o1.english > o2.english) {
                        return 1;
                    }else if(o1.english == o2.english) {
                        if(o1.math < o2.math) {
                            return 1;
                        }else if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
            }
        };

        Arrays.sort(students, comparator);

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}