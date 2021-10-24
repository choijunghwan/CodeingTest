package TestCodeReview.NaverWebtoon;

public class Solve1 {

    /**
     * 문자열에서 가장 먼저 나온 유일한 문자를 출력하시오.
     * adacbce  -> d
     * aczefacce -> z
     * abcdfabcd -> f
     */
    public static void main(String[] args) {
        String input = "abcdfabcd";
        String answer = null;

        int[] arr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            arr[index]++;
        }

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            if (arr[index] == 1) {
                answer = String.valueOf(input.charAt(i));
                break;
            }
        }

        System.out.println("answer = " + answer);

    }
}
