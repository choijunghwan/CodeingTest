package Programmers.KAKAO.intern;

import java.util.HashMap;
import java.util.Map;

public class KAKAO_2021_1 {
    public int solution(String s) {
        Map<String, Integer> wordMap = createWordMap();

        for (String key : wordMap.keySet()) {
            s = s.replace(key, Integer.toString(wordMap.get(key)));
        }


        int answer = Integer.parseInt(s);
        return answer;
    }

    private Map<String, Integer> createWordMap() {
        Map<String, Integer> wordMap = new HashMap<>();
        wordMap.put("zero", 0);
        wordMap.put("one", 1);
        wordMap.put("two", 2);
        wordMap.put("three", 3);
        wordMap.put("four", 4);
        wordMap.put("five", 5);
        wordMap.put("six", 6);
        wordMap.put("seven", 7);
        wordMap.put("eight", 8);
        wordMap.put("nine", 9);

        return wordMap;
    }
}
