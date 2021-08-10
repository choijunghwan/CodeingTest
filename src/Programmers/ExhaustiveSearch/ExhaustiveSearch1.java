package Programmers.ExhaustiveSearch;

import java.util.ArrayList;

public class ExhaustiveSearch1 {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        int correct_1 = 0;
        int correct_2 = 0;
        int correct_3 = 0;

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int tmp1 = i % 5;
            int tmp2 = i % 8;
            int tmp3 = i % 10;

            if (answers[tmp1] == one[tmp1]) {
                correct_1++;
            }
            if (answers[tmp2] == two[tmp2]) {
                correct_2++;
            }
            if (answers[tmp3] == three[tmp3]) {
                correct_3++;
            }
        }

        int[] count = {correct_1, correct_2, correct_3};
        ArrayList arr = new ArrayList<>();

        int max = count[0];
        for (int i = 1; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                arr.add(i + 1);
            }
        }

        System.out.println("arr = " + arr);
    }
}
