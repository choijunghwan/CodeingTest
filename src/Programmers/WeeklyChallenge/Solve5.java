package Programmers.WeeklyChallenge;

public class Solve5 {
    public int solution(String word) {
        //단어를 첫단어부터 탐색
        //첫째자리일 경우
        // A일경우 + 1 , E일경우 5^4+5^3+5^2+5^1+5^0 을 더해준다.

        //둘째자리일 경우
        // A일경우 + 1 , E일경우 5^3+5^2+5^1+5^0
        int answer = 0;
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            answer++;

            for (int j = 0; j < alphabet.length; j++) {
                if (ch == alphabet[j]) {
                    answer += addOrder(i,j);
                }
            }
        }

        return answer;
    }

    private int addOrder(int wordIndex, int alphaIndex) {
        if (alphaIndex == 0) {
            return 0;
        }

        int sum = 0;
        while (wordIndex <= 4) {

            sum += Math.pow(5, 4 - wordIndex);
            wordIndex++;
        }
        return (sum * alphaIndex);
    }
}
