import java.io.*;
import java.util.*;

public class Main {
    static class Member implements Comparable<Member> {
        private int age;
        private String name;
        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Member m) {
            return this.age - m.age;
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
        Member[] members = new Member[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(tk.nextToken());
            String name = tk.nextToken();
            members[i] = new Member(age, name);
        }
        Arrays.sort(members);
        for(int i = 0; i < N; i++) {
            bw.write(members[i].toString());
        }
        bw.flush();
        bw.close();
    }
}