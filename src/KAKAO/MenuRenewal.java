package KAKAO;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {

        List<Map<String, Integer>> FoodMaps = new ArrayList<>();
        int[] MaxCnt = new int[11];

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        for (int i = 0; i < 11; i++) {
            FoodMaps.add(new HashMap<String, Integer>());
        }

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder(), FoodMaps, MaxCnt);
        }

        List<String> list = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);
        System.out.println("list = " + list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println("answer = " + answer);

    }

    static void comb(char[] str, int pos, StringBuilder candi, List<Map<String, Integer>> FoodMaps, int[] MaxCnt) {
        if (pos >= str.length) {
            int len = candi.length();
            if (len >= 2) {
                int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                FoodMaps.get(len).put(candi.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len], cnt);
            }
            return;
        }
        comb(str, pos + 1, candi.append(str[pos]), FoodMaps, MaxCnt);
        candi.setLength(candi.length() -1);
        comb(str, pos +1, candi, FoodMaps, MaxCnt);
    }
}
