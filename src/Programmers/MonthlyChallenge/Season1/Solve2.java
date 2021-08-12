package Programmers.MonthlyChallenge.Season1;

public class Solve2 {
    public int solution(int n) {
        String a = "";

        while (n > 0) {
            a = (n % 3) + a;
            n /= 3;
        }

        a = new StringBuilder(a).reverse().toString();

        return Integer.parseInt(a, 3);
    }
}
