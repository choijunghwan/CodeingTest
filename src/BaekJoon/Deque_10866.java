package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Deque_10866 {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(pop_front());
                    break;
                case "pop_back":
                    System.out.println(pop_back());
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if (empty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    System.out.println(front());
                    break;
                case "back":
                    System.out.println(back());
                    break;
            }
        }

    }

    private static int back() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.get(list.size() - 1);
    }

    private static int front() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.get(0);
    }

    private static boolean empty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int pop_back() {
        if (list.isEmpty()) {
            return -1;
        }
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return temp;
    }

    private static int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }
        int temp = list.get(0);
        list.remove(0);
        return temp;
    }

    private static void push_back(int x) {
        list.add(x);
    }

    private static void push_front(int x) {
        list.add(0, x);
    }

}
