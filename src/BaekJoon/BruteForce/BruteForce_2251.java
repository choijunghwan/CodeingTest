package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BruteForce_2251 {

    static List<String> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[3];
        int[] bottle = new int[3];

        for (int i = 0; i < bottle.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bottle[2] = arr[2];
        String start = "0 0 " + arr[2] + " ";

        List<Integer> waterC = bfs(start);
        Collections.sort(waterC);
        StringBuilder sb = new StringBuilder();
        for (int c : waterC) {
            sb.append(c + " ");
        }

        System.out.println(sb.toString());
    }

    private static List<Integer> bfs(String start) {
        List<Integer> waterC = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        list.add(start);

        while (!q.isEmpty()) {
            String str = q.poll();
            int[] currentWater = convertArr(str);

            if (currentWater[0] == 0 && !waterC.contains(currentWater[2])) {
                waterC.add(currentWater[2]);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (currentWater[i] == 0) {
                        continue;
                    }

                    int[] temp = new int[3];
                    for (int k = 0; k < 3; k++) {
                        temp[k] = currentWater[k];
                    }

                    if (currentWater[i] + currentWater[j] > arr[j]) {
                        temp[i] = currentWater[i] + currentWater[j] - arr[j];
                        temp[j] = arr[j];
                    } else {
                        temp[j] += temp[i];
                        temp[i] = 0;
                    }

                    String water = covertString(temp);

                    if (!list.contains(water)) {
                        list.add(water);
                        q.add(water);

                    }
                }
            }
        }

        return waterC;
    }

    private static String covertString(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    private static int[] convertArr(String str) {
        int[] temp = new int[3];
        String[] s = str.split(" ");
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(s[i]);
        }
        return temp;
    }
}
