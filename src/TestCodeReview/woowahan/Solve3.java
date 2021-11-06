package TestCodeReview.woowahan;

import java.util.HashMap;
import java.util.Map;

public class Solve3 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        // 재료 정보
        Map<Character, Integer> ingMap = new HashMap<>();
        for (String ing : ings) {
            String[] str = ing.split(" ");
            ingMap.put(str[0].charAt(0), Integer.parseInt(str[1]));
        }

        // 메뉴 순이익
        Map<String, Integer> menuCost = new HashMap<>();
        for (String m : menu) {
            String[] str = m.split(" ");

            int cost = 0;
            for (int i = 0; i < str[1].length(); i++) {
                char ch = str[1].charAt(i);
                cost += ingMap.get(ch);
            }

            cost = Integer.parseInt(str[2]) - cost;
            menuCost.put(str[0], cost);
        }

        int result = 0;

        for (String s : sell) {
            String[] str = s.split(" ");
            result += menuCost.get(str[0]) * Integer.parseInt(str[1]);
        }
        return result;
    }
}
