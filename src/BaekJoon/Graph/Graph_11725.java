package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리 문제이다.
 * 1. 주어진 input을 가지고 먼저 트리를 완성해야한다.
 *    1.1 두개의 A B 중에 존재하는 노드를 찾고,
 *    1.2 노드 밑에 자식 노드로 추가한다.
 * 2. 부모노드를 출력한다.
 *    2.1 미리 int[N] 배열을 생성해노아서 트리를 생성하며 부모노드를 따로 저장해놓는다.
 */
public class Graph_11725 {
    static int[] parentNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parentNode = new int[N];
        parentNode[0] = 1;
        Node node = new Node(1);

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            searchNode(node, left, right);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(parentNode[i] + System.lineSeparator());
        }

        System.out.println(sb.toString());

    }

    private static void searchNode(Node node, int left, int right) {
        if (node == null) {
            return ;
        } else if (node.data == left) {
            if (node.child == null) {
                node.child = new ArrayList<Node>();
                node.child.add(new Node(right));
                parentNode[right - 1] = node.data;
            } else {
                node.child.add(new Node(right));
                parentNode[right - 1] = node.data;
            }
        } else if (node.data == right) {
            if (node.child == null) {
                node.child = new ArrayList<Node>();
                node.child.add(new Node(left));
                parentNode[left - 1] = node.data;
            } else {
                node.child.add(new Node(left));
                parentNode[left - 1] = node.data;
            }
        } else {
            if (node.child == null) {
                return ;
            }
            for (Node c : node.child) {
                searchNode(c, left, right);
            }
        }
    }

    static class Node {
        int data;
        List<Node> child;

        Node(int data) {
            this.data = data;
        }
    }
}

