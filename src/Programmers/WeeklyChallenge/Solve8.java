package Programmers.WeeklyChallenge;

public class Solve8 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution(sizes);
        System.out.println("result = " + result);
    }

    public static int solution(int[][] sizes) {
        int minW = sizes[0][0];
        int minH = sizes[0][1];

        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];

            if (w <= minW && h <= minH) {
                continue;
            }

            int origin = Math.max(minW, w) * Math.max(minH, h);
            int rotate = Math.max(minW, h) * Math.max(minH, w);

            if (origin <= rotate) {
                minW = Math.max(minW, w);
                minH = Math.max(minH, h);
            } else {
                minW = Math.max(minW, h);
                minH = Math.max(minH, w);
            }
        }
        return minW * minH;
    }
}
