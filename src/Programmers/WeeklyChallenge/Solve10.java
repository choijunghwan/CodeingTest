package Programmers.WeeklyChallenge;

import java.util.ArrayList;
import java.util.List;

public class Solve10 {

    /**
     * int 값 곱셈이 있을때는 int형 범위를 벗어나는 경우가 있는지 고려해서 에러처리를 하거나
     * long형으로 형 변환을 고려해봐야 한다.
     */
    public String[] solution(int[][] line) {
        int MinX = Integer.MAX_VALUE;
        int MinY = Integer.MAX_VALUE;
        int MaxX = Integer.MIN_VALUE;
        int MaxY = Integer.MIN_VALUE;
        // 두개의 직선을 비교하며 교점이 있으면 교점을 구한다.
        // 두개의 직선의 기울기를 비교
        // 기울기가 같으면 교점이 없다.(겹치는 경우는 없음)
        // 기울기가 다르면 교점을 구한다.
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < line.length - 1; i++) {
            // Ax + By + E = 0
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                // Cx + Dy + F = 0;
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                // 기울기가 같은경우
                long ADBC = (A * D) - (B * C);
                if (ADBC == 0) {
                    continue;
                }

                long BFED = (B * F) - (E * D);
                long ECAF = (E * C) - (A * F);


                // 교점이 정수가 아닌경우
                if (BFED % ADBC != 0 || ECAF % ADBC != 0) {
                    continue;
                }
                int tempX = (int) (BFED/ADBC);
                int tempY = (int) (ECAF/ADBC);

                list.add(new Point(tempX, tempY));
                MinX = Math.min(MinX, tempX);
                MaxX = Math.max(MaxX, tempX);
                MinY = Math.min(MinY, tempY);
                MaxY = Math.max(MaxY, tempY);
            }
        }

        // x 범위 -4 ~ 4 , y 범위 -4 ~ 4
        // MinX, MaxY(-4, 4) 를 기준으로 (4,1)은 4-1 = 3 , 4 - (-4) = 8;
        char[][] map = new char[MaxY - MinY + 1][MaxX - MinX + 1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '.';
            }
        }

        for (Point point : list) {
            int r = MaxY - point.y;
            int c = point.x - MinX;
            map[r][c] = '*';
        }

        String[] answer = new String[map.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = String.valueOf(map[i]);
        }

        return answer;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
