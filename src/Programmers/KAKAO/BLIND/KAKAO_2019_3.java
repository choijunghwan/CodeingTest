package Programmers.KAKAO.BLIND;

import java.util.*;

public class KAKAO_2019_3 {

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        int result = solution(relation);
        System.out.println(result);

    }
    public static int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= (1 << m) - 1; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < m; k++) {
                    if ((i & (1 << k)) > 0) { //정수 k 가 비트마스크에 포함되어 있다면
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if (set.size() == n) {
                list.add(i);
            }
        }

        int answer = 0;

        while (!list.isEmpty()) {
            int v = list.remove(0);
            answer++;
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int next = it.next();
                if ((next & v) == v) {
                    it.remove();
                }
            }
        }

        return answer;
    }
}
