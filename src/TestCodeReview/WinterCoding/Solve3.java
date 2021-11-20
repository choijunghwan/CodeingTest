package TestCodeReview.WinterCoding;

import java.util.HashSet;
import java.util.Set;

public class Solve3 {

    public static void main(String[] args) {
        String[] cakes = {"AAAACX", "AAAACX", "AAAACX", "ZZZZZX", "ATTTTX", "XUUUUU"};
        int[] cut_rows = {1, 2, 4};
        int[] cut_columns = {2, 3};

        int result = solution(cakes, cut_rows, cut_columns);
    }

    static String[] cake;
    static int answer = 0;

    public static int solution(String[] cakes, int[] cut_rows, int[] cut_columns) {
        cake = cakes;
        // 2,3     2
        // 0~2, 2~3, 3~4    0~2, 2~4
        // (0,0) - (2,2)
        // (0,2) - (2,4)


        // 1,2,4  2,3
        // 0~1, 1~2, 2~4, 4~6        0~2, 2~3, 3~6
        // 0,0  1,2
        // 0,2  1,3

        // 자르는 행과 열의 번호를 가지고 네모난 조각의 영역을 구한다.

        // 자르는 행이 2,3 이면 나눠진 영역은 (0,2)(2,3)(3,4)이다.
        // 앞뒤로 0과 cakes의 길이를 추가해준다.

        // 각각의 네모난 영역의 좌표를 구한다.
        // 행영역이 (2,3), 열영역이 (0,2) 라면 영역은 (2,0) ~ (3,2)이다.
        int len = cakes.length;
        int[] partition_rows = new int[cut_rows.length+2];
        int[] partition_columns = new int[cut_columns.length+2];

        for (int i = 0; i < cut_rows.length; i++) {
            partition_rows[i + 1] = cut_rows[i];
        }
        partition_rows[partition_rows.length - 1] = len;

        for (int i = 0; i < cut_columns.length; i++) {
            partition_columns[i + 1] = cut_columns[i];
        }
        partition_columns[partition_columns.length - 1] = len;


        for (int i = 0; i < partition_rows.length - 1; i++) {
            for (int j = 0; j < partition_columns.length - 1; j++) {
                check(partition_rows[i], partition_rows[i+1], partition_columns[j], partition_columns[j+1]);
            }
        }

        return answer;
    }

    private static void check (int r1, int r2, int c1, int c2) {
        Set<Character> set = new HashSet<>();

        for (int i = r1; i < r2; i++) {
            String str = cake[i];

            for (int j = c1; j < c2; j++) {
                set.add(str.charAt(j));
            }
        }

        answer = Math.max(answer, set.size());
    }
}
