package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_1991 {
    static Node node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            createNode(a, b, c);
        }

        preOrder(node);
        System.out.print(System.lineSeparator());
        inOrder(node);
        System.out.print(System.lineSeparator());
        postOrder(node);
    }

    private static void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }
    }

    private static void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            System.out.print(node.data);
            if (node.right != null) inOrder(node.right);
        }
    }

    private static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }

    private static void createNode(String data, String leftData, String rightData) {
        if (node == null) {
            node = new Node(data);
            if (!leftData.equals(".")) {
                node.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node, data, leftData, rightData);
        }
    }

    private static void searchNode(Node node, String data, String leftData, String rightData) {
        if (node == null) {
            return ;
        } else if (node.data.equals(data)) {
            if (!leftData.equals(".")) {
                node.left = new Node(leftData);
            }
            if (!rightData.equals(".")) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }


}
class Node {
    String data;
    BaekJoon.Graph.Node left;
    BaekJoon.Graph.Node right;

    Node(String data) {
        this.data = data;
    }
}

