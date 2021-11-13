package TestCodeReview.street;

import java.util.HashMap;
import java.util.Map;

public class Solve3 {

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        int sum = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);

            sum += Math.min(value, Math.abs(key - value));
        }
        return sum;
    }
}
