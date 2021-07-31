package BaekJoon.DC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장 가까운 두 점을 구하는데 핵심은 효율적이게 구해야 한다.
 * 완전 탐색을 사용하면 최대 100000 * 99999 / 2 의 경우를 계산해야 한다.
 * 분할 정복
 * 수직선에서 임의의 y=N 이라는 선을 기준으로 영역을 반으로 나누는 과정을 반복해
 * 나눠진 영역에서 값의 최소값을 찾는다.
 *
 * 주의해야할 점
 * 1. 입력으로 주어지는 좌표가 정렬되어 있는 좌표가 아니다 -> x좌표를 기준으로 정렬한다.
 * 2. 분할 정복을 할 때, 원소가 1개만 남을 경우 거리를 탐색하지 못한다.
 * 3. 분할한 구간 내의 두 점에 대한 최솟값이 전체에 대한 최솟값이라고 보장할 수는 없다.
 */
public class DC_2261 {

    private static Point[] p;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 Point의 거리를 반환하는 메소드
    private static int dist(Point o1, Point o2) {
        return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
    }

    // Y좌표를 오름차순으로 정렬하는 Comparator 익명객체
    private static final Comparator<Point> Ycomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.y - o2.y;
        }
    };

    // X좌료픞 오름차순으로 정렬하는 Comparator 익명객체
    private static final Comparator<Point> Xcomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        p = new Point[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p, Xcomp);

        System.out.println(closet(0, N - 1));
    }

    private static int closet(int start, int end) {

        // p[start] ~ p[end] 원소개 3개 이하라면 브루트포스로 거리 반환
        if (end - start + 1 < 4) {
            return brute(start, end);
        }

        // 가운데 index를 구한다.
        int mid = (start + end) / 2;

        // left는 start ~ mid, right는 mid+1 ~ end로 분할 탐색
        int left = closet(start, mid);
        int right = closet(mid + 1, end);

        // 각 각의 거리 중 최솟값을 구한 뒤 반환
        int minDist = Math.min(left, right);

        // 중간 영역의 최소 거리
        int band = middleBand(start, mid, end, minDist);
        return Math.min(minDist, band);
    }

    private static int middleBand(int start, int mid, int end, int minDist) {
        int xDist;

        // index 참조가 많으므로 ArrayList를 활용
        ArrayList<Point> list = new ArrayList<>();

        // 후보군 추출하기
        int midX = p[mid].x;
        for (int i = start; i <= end; i++) {
            xDist = p[i].x - midX;

            // minDist는 제곱값이므로, x좌표거리도 제곱으로 계산해준다.
            if (xDist * xDist < minDist) {
                list.add(p[i]);
            }
        }

        Collections.sort(list, Ycomp);

        // 후보군들을 순회하면서 y좌표 차이가 minDist내에 있는 원소들만 거리 측정
        int yDist;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {

                yDist = list.get(i).y - list.get(j).y;
                if (yDist * yDist < minDist) {
                    minDist = Math.min(minDist, dist(list.get(i), list.get(j)));
                }
                else {
                    break;
                }
            }
        }

        return minDist;
    }

    private static int brute(int start, int end) {

        int minDist = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                minDist = Math.min(minDist, dist(p[i], p[j]));
            }
        }

        return minDist;
    }
}
