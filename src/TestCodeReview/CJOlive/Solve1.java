package TestCodeReview.CJOlive;

public class Solve1 {

    public static void main(String[] args) {
        int[] x = {5};
        int[] y = {5};
        int[] r = {5};
        int[] v = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};
        int result = solution(x, y, r, v);
        System.out.println("result = " + result);
    }

    public static int solution(int[] x, int[] y, int[] r, int[] v) {
        // 1. x와 y 와 r을 이용해 i,r,b,t 를 구한다.
        //    반복문을 돌려 최소, 최대값을 매번 갱신하며 구한다.
        int leftX = Integer.MAX_VALUE;
        int rightX = 0;
        int bottomY = Integer.MAX_VALUE;
        int topY = 0;

        int len = x.length;
        for (int i = 0; i < len; i++) {
            leftX = Math.min(leftX, x[i] - r[i]);
            rightX = Math.max(rightX, x[i] + r[i]);
            bottomY = Math.min(bottomY, y[i] - r[i]);
            topY = Math.max(topY, y[i] + r[i]);
        }

        // 2. v에 있는 난수를 갖고 좌표를 변환한다.
        int width = rightX - leftX;
        int height = topY - bottomY;
        for (int i = 0; i < v.length; i += 2) {
            v[i] = leftX + (v[i] % width);
            v[i+1] = bottomY + (v[i+1] % height);
        }

        int count = 0;
        // 3. 기지국 영역 내에 있는지 검사하며 count 한다.
        for (int i = 0; i < v.length; i += 2) {
            int pointX = v[i];
            int pointY = v[i+1];

            for (int j = 0; j < len; j++){
                int distance = (x[j] - pointX) * (x[j] - pointX) + (y[j] - pointY) * (y[j] - pointY);

                if (distance <= r[j] * r[j]) {
                    count++;
                    break;
                }
            }
        }

        // 4. 면적을 구한다.
        int answer = width * height * count / (v.length / 2);
        return answer;
    }
}
