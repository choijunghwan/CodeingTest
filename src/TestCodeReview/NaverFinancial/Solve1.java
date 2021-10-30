package TestCodeReview.NaverFinancial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solve1 {

    public static void main(String[] args) {
        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
        int k = 3;

        int result = solution(id_list, k);
    }

    public static int solution(String[] id_list, int k) {
        Map<String, Integer> coupons = new HashMap<>();

        for (String ids : id_list) {
            String[] record = ids.split(" ");
            List<String> custom = new ArrayList<>();

            for (int i = 0; i < record.length; i++) {
                String str = record[i];

                // 하루에 물품을 여러번 구매한 경우
                if (custom.contains(str)) {
                    continue;
                }
                custom.add(str);

                // 소유한 쿠폰수가 K가 안된경우
                if (coupons.containsKey(str)) {
                    if (coupons.get(str) < k) {
                        coupons.put(str, coupons.get(str) + 1);
                    }
                } else { // 처음 구매하신경우
                    coupons.put(str, 1);
                }
            }
        }

        int sum = 0;
        for (String key : coupons.keySet()) {
            sum += coupons.get(key);
        }

        return sum;
    }
}
