package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2 {
    public static void main(String[] args) {
        int[] number1 = {6, 10, 2};
        int[] number2 = {3, 30, 34, 5, 9};


        Integer[] casting = new Integer[number2.length];
        for (int i = 0; i < number2.length; i++) {
            casting[i] = number2[i];
        }

        Arrays.sort(casting, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String temp1 = o1.toString();
                String temp2 = o2.toString();
                return (temp2 + temp1).compareTo(temp1 + temp2);
            }
        });

        String answer = Arrays.toString(casting).replaceAll("[^0-9]", "");

        // 0인경우 제외
        if (answer.startsWith("0")) {
            answer = "0";
        }

        System.out.println("answer = " + answer);


    }
}
