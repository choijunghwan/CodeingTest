package TestCodeReview.DevMatching.last_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solve2 {

    // recipes의 조리시간을 Map자료구조에 입력
    // 1 -> 4 -> 6
    // 1 -> 5 -> 7

    // 1 -> 9 -> 12
    // 1 -> 4 -> 9
    // 1 -> 7 -> 15
    public int solution(int n, String[] recipes, String[] orders) {
        // recipes 조리시간 Map에 저장
        Map<String, Integer> recipesMap = new HashMap<>();
        for (String recipe : recipes) {
            String[] str = recipe.split(" ");
            recipesMap.put(str[0], Integer.parseInt(str[1]));
        }

        int[] cookArr = new int[n];
        Arrays.fill(cookArr, 1);

        int lastOrderCookTime = 0;
        for (String order : orders) {
            String[] str = order.split(" ");
            String menu = str[0];
            int order_time = Integer.parseInt(str[1]);

            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < cookArr.length; i++) {
                if (cookArr[i] < min) {
                    min = cookArr[i];
                    idx = i;
                }
            }

            // 화구는 있지만 주문시간이 아직 안된경우
            if (min < order_time) {
                cookArr[idx] = order_time + recipesMap.get(menu);
            } else if (min >= order_time) {   // 화구가 없어 대기하는 경우
                cookArr[idx] = min + recipesMap.get(menu);
            }

            lastOrderCookTime = cookArr[idx];
        }

        return lastOrderCookTime;
    }
}
