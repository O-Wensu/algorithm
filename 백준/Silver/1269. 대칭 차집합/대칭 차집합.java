import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        init(setA, a);
        init(setB, b);
        compareSet(setA, setB);
        compareSet(setB, setA);
        System.out.println(count);
    }

    public static void init(Set<Integer> set, int size) throws IOException{
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            set.add(Integer.parseInt(tk.nextToken()));
        }
    }

    public static void compareSet(Set<Integer> origin, Set<Integer> source) {
        for (Integer i : origin) {
            if (!source.contains(i)) count++;
        }
    }
}