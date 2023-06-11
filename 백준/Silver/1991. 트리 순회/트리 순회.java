import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static class Tree {
        Node root;

        void insertNode(char value, char left, char right) {
            if (root == null) {
                root = new Node(value);

                root.left = left == '.' ? null : new Node(left);
                root.right = right == '.' ? null : new Node(right);
            } else {
                findNode(root, value, left, right);
            }
        }

        void findNode(Node node, char value, char left, char right) {
            if (node == null) return;
            if (node.value == value) {
                node.left = left == '.' ? null : new Node(left);
                node.right = right == '.' ? null : new Node(right);
            } else {
                findNode(node.left, value, left, right);
                findNode(node.right, value, left, right);
            }
        }

        //전위 순회
        //root -> left -> right
        void preOrder(Node node) throws IOException {
            if (node == null) return;
            bw.write(node.value + "");
            preOrder(node.left);
            preOrder(node.right);
        }

        //중위 순회
        //left -> root -> right
        void order(Node node) throws IOException {
            if (node == null) return;
            order(node.left);
            bw.write(node.value + "");
            order(node.right);
        }

        //후위 순회
        //left -> right -> root
        void postOrder(Node node) throws IOException {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            bw.write(node.value + "");
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            tree.insertNode(tk.nextToken().charAt(0), tk.nextToken().charAt(0), tk.nextToken().charAt(0));
        }

        tree.preOrder(tree.root);
        bw.write("\n");
        tree.order(tree.root);
        bw.write("\n");
        tree.postOrder(tree.root);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}