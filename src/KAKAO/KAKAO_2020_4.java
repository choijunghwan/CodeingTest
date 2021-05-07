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
}
