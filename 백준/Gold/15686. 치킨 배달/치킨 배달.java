import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Pos target) {
            return Math.abs(target.x - x) + Math.abs(target.y - y);
        }
    }

    static int n, m;
    static List<Pos> homes = new ArrayList<>(); //집 좌표
    static List<Pos> chickens = new ArrayList<>(); //치킨집 좌표
    static Pos[] posArr; //선택된 치킨집 좌표
    static boolean[] isUsed;
    static int distance = Integer.MAX_VALUE;

    public static void search(int depth, int start) {

        if (depth == m) {
            distance = Math.min(distance, sumDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            posArr[depth] = chickens.get(i);
            search(depth + 1, i + 1);
        }
    }

    public static int sumDistance() {
        int temp = 0;
        for (Pos home : homes) {
            int distance = Integer.MAX_VALUE;
            for (Pos pos : posArr) {
                distance = Math.min(distance, home.getDistance(pos));
            }
            temp += distance;
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken()); //행, 열
        m = Integer.parseInt(tk.nextToken()); //치킨집 개수
        posArr = new Pos[m];

        //위치 저장
        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(splits[j]);
                if (num == 2) chickens.add(new Pos(i, j));
                else if (num == 1) homes.add(new Pos(i, j));
            }
        }
        isUsed = new boolean[chickens.size()];

        search(0, 0);
        System.out.println(distance);
    }
}