package KAKAO;

import java.util.Arrays;

public class KAKAO_2020_4 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        Arrays.sort(words);
        Arrays.sort(queries);

        for (String word : words) {
            System.out.println("word = " + word);
        }
        for (String query : queries) {
            System.out.println("query = " + query);
        }

        System.out.println("words = " + words);
        System.out.println("queries = " + queries);
    }

    // 정확성 25점 효율성 30점짜리 코드
    public static int[] precise_solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                boolean check = true;
                if (query.length() != word.length()) {
                    continue;
                }

                for (int index = 0; index < query.length(); index++) {
                    if (query.charAt(index) == '?') {
                        continue;
                    } else if (query.charAt(index) != word.charAt(index)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    count++;
                }
            }

            answer[i] = count;
        }
        return answer;
    }
}
