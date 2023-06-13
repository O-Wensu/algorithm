import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] tree;
    static int total, duplicated, last;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        total = duplicated = last = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[p] = new Node(a, b);
        }

        findLastNode(1);
        count(1, 0);

        System.out.println(total - duplicated);
    }

    static void findLastNode(int value) {
        if (tree[value].left != -1) {
            findLastNode(tree[value].left);
        }
        last = value;
        if (tree[value].right != -1) {
            findLastNode(tree[value].right);
        }
    }

    static void count(int value, int depth){
        if (tree[value].left != -1){
            total = total + 2;
            count(tree[value].left, depth + 1);
        }

        if (value == last) {
            duplicated = depth;
        }

        if (tree[value].right != -1){
            total = total + 2;
            count(tree[value].right, depth + 1);
        }
    }
}