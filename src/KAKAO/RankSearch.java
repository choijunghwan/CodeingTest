package KAKAO;

import java.util.HashMap;
import java.util.Map;

public class RankSearch {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        Map<String, Integer> Wordmap = new HashMap<>();
        Wordmap.put("-", 0);
        Wordmap.put("cpp", 1);
        Wordmap.put("java", 2);
        Wordmap.put("python", 3);
        Wordmap.put("backend", 1);
        Wordmap.put("frontend", 2);
        Wordmap.put("junior", 1);
        Wordmap.put("senior", 2);
        Wordmap.put("chicken", 1);
        Wordmap.put("pizza", 2);

    }
}
