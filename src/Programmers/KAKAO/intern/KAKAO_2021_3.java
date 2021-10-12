package Programmers.KAKAO.intern;

import java.util.Stack;

public class KAKAO_2021_3 {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        String result = solution(n, k, cmd);
        System.out.println("result = " + result);
    }


    private static String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));

        for (String s : cmd) {
            char ch = s.charAt(0);
            if (ch == 'U') {
                int num = Integer.valueOf(s.substring(2));
                while (num-- > 0) {
                    k = pre[k];
                }
            } else if (ch == 'D') {
                int num = Integer.valueOf(s.substring(2));
                while (num-- > 0) {
                    k = next[k];
                }
            } else if (ch == 'C') {
                stack.push(new Node(pre[k], k, next[k]));
                if (pre[k] != -1) {
                    //현재 노드 삭제 후 앞뒤 연결
                    next[pre[k]] = next[k];
                }
                if (next[k] != -1) {
                    pre[next[k]] = pre[k];
                }
                sb.setCharAt(k, 'X');

                if (next[k] != -1) {
                    k = next[k];
                } else {
                    k = pre[k]; //마지막 행인 경우에 바로 윗 행 선택
                }
            } else if (ch == 'Z') {
                Node node = stack.pop();
                if (node.pre != -1) {
                    next[node.pre] = node.cur;
                }
                if (node.nxt != -1) {
                    pre[node.nxt] = node.cur;
                }
                sb.setCharAt(node.cur, 'O');
            }
        }
        return sb.toString();
    }

    static class Node {
        int pre;
        int cur;
        int nxt;

        public Node(int pre, int cur, int nxt) {
            this.pre = pre;
            this.cur = cur;
            this.nxt = nxt;
        }
    }
}
