import java.util.*;
import java.io.*;

public class Main {
    static class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Member> members = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(tk.nextToken()), tk.nextToken()));
        }
        Collections.sort(members, Comparator.comparing(Member::getAge));
        members.stream().forEach(member -> {
            sb.append(member.getAge() + " " + member.getName() + "\n");
        });
        System.out.println(sb);
    }
}