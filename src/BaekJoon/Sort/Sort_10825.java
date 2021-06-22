package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][4];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        // 음수 or 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1].equals(e2[1])) {
                if (e1[2].equals(e2[2])) {
                    if (e1[3].equals(e2[3])) {
                        return e1[0].compareTo(e2[0]);
                    } else {
                        return Integer.compare(Integer.parseInt(e2[3]), Integer.parseInt(e1[3]));
                    }
                } else {
                    return Integer.compare(Integer.parseInt(e1[2]), Integer.parseInt(e2[2]));
                }
            } else {
                return Integer.compare(Integer.parseInt(e2[1]), Integer.parseInt(e1[1]));
            }
        });

        for (int i = 0; i <n; i++) {
            System.out.println(arr[i][0]);
        }
    }
}

