package TestCodeReview.Grepp;

import java.util.*;
import java.util.stream.Collectors;

public class Solve2 {

    public static void main(String[] args) {
        String[] grades = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F",
                "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
        String[] result = solution(grades);
    }
    public static String[] solution(String[] grades) {
        Map<String, Integer> gradeMap = getGradeMap();
        Map<Integer, String> scoreMap = getScoreMap();
        Map<String, Integer> map = new HashMap<>();

        for (String grade : grades) {
            String[] str = grade.split(" ");

            if (!map.containsKey(str[0])) {
                map.put(str[0], gradeMap.get(str[1]));
                continue;
            }

            if (map.get(str[0]) < gradeMap.get(str[1])) {
                map.put(str[0], gradeMap.get(str[1]));
            }
        }

        List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        String[] result = new String[map.size()];
        int size = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            result[size++] = entry.getKey() + " " + scoreMap.get(entry.getValue());
        }

        return result;
    }

    private static Map<Integer, String> getScoreMap() {
        Map<Integer, String> score = new HashMap<>();
        score.put(13, "A+");
        score.put(12, "A0");
        score.put(11, "A-");
        score.put(10, "B+");
        score.put(9, "B0");
        score.put(8, "B-");
        score.put(7, "C+");
        score.put(6, "C0");
        score.put(5, "C-");
        score.put(4, "D+");
        score.put(3, "D0");
        score.put(2, "D-");
        score.put(1, "F");
        return score;
    }

    private static Map<String, Integer> getGradeMap() {
        Map<String, Integer> score = new HashMap<>();
        score.put("A+", 13);
        score.put("A0", 12);
        score.put("A-", 11);
        score.put("B+", 10);
        score.put("B0", 9);
        score.put("B-", 8);
        score.put("C+", 7);
        score.put("C0", 6);
        score.put("C-", 5);
        score.put("D+", 4);
        score.put("D0", 3);
        score.put("D-", 2);
        score.put("F", 1);
        return score;
    }
}
