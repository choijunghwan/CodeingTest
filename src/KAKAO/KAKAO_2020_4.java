package KAKAO;

import java.util.Arrays;

public class KAKAO_2020_4 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution(words, queries);
        System.out.println("answer = " + answer.toString());

    }

    static class Trie {
        Trie[] child = new Trie[26];
        int count;
        int aletter = Character.getNumericValue('a');

        void insert(String word) {
            Trie curr = this;

            for (char ch : word.toCharArray()) {
                curr.count++;
                int idx = Character.getNumericValue(ch) - aletter;

                if (curr.child[idx] == null) {
                    curr.child[idx] = new Trie();
                }

                curr = curr.child[idx];
            }

            curr.count++;
        }

        int search(String word) {
            Trie curr = this;
            for (char ch : word.toCharArray()) {
                if (ch == '?') {
                    return curr.count;
                }

                curr = curr.child[Character.getNumericValue(ch) - aletter];
                if (curr == null) {
                    return 0;
                }
            }

            return curr.count;
        }
    }

    static Trie[] TrieRoot = new Trie[10000];
    static Trie[] ReTrieRoot = new Trie[10000];

    static public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;

        for (String str : words) {
            int idx = str.length() - 1;
            if (TrieRoot[idx] == null) {
                TrieRoot[idx] = new Trie();
                ReTrieRoot[idx] = new Trie();
            }

            TrieRoot[idx].insert(str);
            str = new StringBuilder(str).reverse().toString();
            ReTrieRoot[idx].insert(str);
        }

        for (String str : queries) {
            int idx = str.length() - 1;
            if (TrieRoot[idx] == null) {
                answer[ansIdx++] = 0;
                continue;
            }

            if (str.charAt(0) != '?') {
                answer[ansIdx++] = TrieRoot[idx].search(str);
            } else {
                str = new StringBuilder(str).reverse().toString();
                answer[ansIdx++] = ReTrieRoot[idx].search(str);
            }
        }

        return answer;
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
