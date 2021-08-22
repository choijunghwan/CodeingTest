package TestCodeReview.Grepp;

public class Solve3 {
    public static void main(String[] args) {
        String word = "APPLE";
        String[] cards = {"LLZKE", "LCXEA", "CVPPS", "EAVSR", "FXPFP"};
        int result = solution(word, cards);
        System.out.println("result = " + result);
    }

    static int answer = 0;
    public static int solution(String word, String[] cards) {
        int wordLen = word.length();
        int cardLen = cards.length;

        for (int i = 0; i <= cardLen - wordLen; i++) {
            for (int j = 0; j < cardLen; j++){

                char ch = cards[i].charAt(j);

                for (int k = 0; k < word.length(); k++) {
                    boolean[] visited = new boolean[cardLen];
                    boolean[] isUseWord = new boolean[wordLen];
                    if (word.charAt(k) == ch) {
                        isUseWord[k] = true;
                        visited[i] = true;
                        dfs(word, cards, visited, isUseWord, i+1, j);
                    }
                }

            }

        }

        return answer;
    }

    private static void dfs(String word, String[] cards, boolean[] visited, boolean[] isUseWord, int row, int col) {

        int count = 0;
        for (boolean use : isUseWord){
            if (use) {
                count++;
            }
        }

        if (count == word.length()) {
            answer++;
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }

            char ch = cards[row].charAt(i);
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == ch && !isUseWord[j]) {
                    isUseWord[j] = true;
                    visited[i] = true;
                    dfs(word, cards, visited, isUseWord, row+1, i);
                    isUseWord[j] = false;
                    visited[i] = false;
                }
            }
        }

    }
}
