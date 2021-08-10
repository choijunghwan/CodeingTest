package Programmers.ExhaustiveSearch;

public class ExhaustiveSearch3 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] answer = new int[2];

        int half_border = (brown + 4) / 2;

        for (int i = 3 ; i <= half_border/2 ; i++) {
            int width = half_border - i;
            int height = i;

            if ( (width-2) * (height-2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
