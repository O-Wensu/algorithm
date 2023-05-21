import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<Integer> cranes = new ArrayList<>();
    static List<Integer> boxes = new ArrayList<>();
    static boolean[] isMoved;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(tk.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(tk.nextToken()));
        }

        isMoved = new boolean[m];

        Collections.sort(cranes, Comparator.reverseOrder());
        Collections.sort(boxes, Comparator.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.println("-1");
            return;
        }

        while (boxes.size() != 0) {
            int index = 0;
            for (int i = 0; i < n;) {
                if (index == boxes.size()) break;
                else if (cranes.get(i) >= boxes.get(index)) {
                    boxes.remove(index);
                    i++;
                } else index++;
            }
            time++;
        }
        
        System.out.println(time);
    }

}