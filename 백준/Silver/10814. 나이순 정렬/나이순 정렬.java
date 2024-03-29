import java.io.*;
import java.util.*;

public class Main {
    static class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(tk.nextToken());
            String name = tk.nextToken();
            members.add(new Member(age, name));
        }
        members.sort(Comparator.comparingInt(Member::getAge));
        for(int i = 0; i < N; i++) {
            bw.write(members.get(i).toString());
        }
        bw.flush();
        bw.close();
    }
}