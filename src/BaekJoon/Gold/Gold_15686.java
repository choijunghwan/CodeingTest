package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold_15686 {
    /**
     * 집의 좌표를 List에 저장해둔다.
     * 치킨집을 M개를 골라 배열에 저장한다.
     * 도시의 치킨 거리를 구한다.
     */

    static int M;
    static int N;
    static int[][] maps;
    static List<Point> homes;
    static List<Point> chickens;
    static Stack<Point> selectChicken;
    static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        selectChicken = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 1) {
                    homes.add(new Point(i, j));
                } else if (maps[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        select(0, 0);

        System.out.println(cnt);
    }

    private static void select(int start, int count) {
        if (count == M) {
            calcDist();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectChicken.push(chickens.get(i));
            select(i + 1, count + 1);
            selectChicken.pop();
        }
    }

    private static void calcDist() {
        int sum = 0;
        for (Point home : homes) {
            int min = Integer.MAX_VALUE;
            for (Point chicken : selectChicken) {
                min = Math.min(min, getDistance(home, chicken));
            }
            sum += min;

            if (sum > cnt) {
                return;
            }
        }
        cnt = Math.min(sum, cnt);
    }


    private static int getDistance(Point home, Point chicken) {
        return Math.abs(home.c - chicken.c) + Math.abs(home.r - chicken.r);
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            if (r == point.r && c == point.c) {
                return true;
            }
            return false;
        }
    }
}
