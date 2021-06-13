package BaekJoon;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Arrays.sort는 퀵소트를 사용하는데 퀵소트는 시간복잡도가 O(nlogn)이지만 최악의 경우 O(n제곱)이다
 * 이 문제는 최악의 경우가 있는거 같아서
 * Collections.sort를 사용한다. 이 방법은 Timsort로 합병 및 삽입정렬 알고리즘을 사용한다.
 * 시간복잡도도 최악의 경우 O(nlogn)을 보장해 준다.
 */
public class Sort_2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
