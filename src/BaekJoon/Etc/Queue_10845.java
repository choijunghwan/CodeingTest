package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Queue_10845 {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
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

    private static void push(int x) {
        list.add(x);
    }

    private static int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        int temp = list.get(0);
        list.remove(0);
        return temp;
    }

    private static boolean empty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int front() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.get(0);
    }

    private static int back() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.get(list.size() - 1);
    }
}
