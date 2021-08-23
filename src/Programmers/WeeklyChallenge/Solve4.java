package Programmers.WeeklyChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class Solve4 {

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};

        // int 비교의 경우 20 > 3 이지만
        // String 비교를 하면 첫번째 자리 2 < 3 이기때문에 20 < 3 인 결과가 리턴된다.
        System.out.println("20".compareTo("3"));

        String result = solution(table, languages, preference);

        System.out.println(result);
    }
    public static String solution(String[] table, String[] languages, int[] preference) {
        String[][] result = new String[table.length][2];


        for (int i = 0; i < table.length; i++) {
            String[] str = table[i].split(" ");
            int preferCount = 0;

            preferCount += calculate(str, languages, preference);

            result[i][0] = str[0];
            result[i][1] = Integer.toString(preferCount);
        }

        Arrays.sort(result, new CustomComparator());

        return result[0][0];
    }

    static class CustomComparator implements Comparator<String[]> {

        @Override
        public int compare(String[] o1, String[] o2) {
            if (o1[1].equals(o2[1])) {
                return o1[0].compareTo(o2[0]);
            } else {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        }
    }

    private static int calculate(String[] str, String[] languages, int[] preference) {
        int sum = 0;

        for (int i = 0; i < languages.length; i++) {
            String language = languages[i];

            for (int j = 1; j < str.length; j++) {
                if (str[j].equals(language)) {
                    sum += preference[i] * (6 - j);
                    break;
                }
            }
        }

        return sum;
    }
}
