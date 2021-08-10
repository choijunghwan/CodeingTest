package Programmers.DynamicProgramming;

public class DP3 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int answer = solution(m, n, puddles);
        System.out.println("answer = " + answer);
    }

    /**
     * i,j 좌표로 갈수 있는 방법의 수 = i,j-1 좌료 + i-1,j 좌표의 합
     * route[i][j] = route[i][j-1] + route[i-1][j]
     *
     * route[i][j] 배열을 1로 초기화 물웅덩이는 0으로 초기화
     * 1. i = 0 이면 왼쪽값을 그대로 전송
     * 2. j = 0 이면 위쪽값을 그대로 전송
     * 3. 그 외는 점화식
     *
     * or
     *
     * m= 4, n =3 이라면
     * 1111
     * 1111
     * 1111  이런 모양인데
     *
     * 00000
     * 01111
     * 01111
     * 01111  이처럼 0으로 위쪽과 왼쪽을 감싸면
     * 다른조건없이
     * route[i][j] = route[i][j-1] + route[i-1][j] 점화식만으로 풀 수 있다.
     */
    public static int solution(int m, int n, int[][] puddles) {
        int[][] route = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                route[i][j] = 1;
            }
        }

        for (int[] puddle : puddles) {
            route[puddle[1] - 1][puddle[0] - 1] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(route[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 시작 지점
                if (i == 0 && j == 0) {
                    continue;
                }

                // 물 웅덩이
                if (route[i][j] == 0) {
                    continue;
                }

                if (i == 0) {
                    route[i][j] = route[i][j - 1];
                } else if (j == 0) {
                    route[i][j] = route[i - 1][j];
                } else {
                    route[i][j] = route[i - 1][j] + route[i][j - 1];
                    // 효율성 테스트를 위한 모듈러 연산 추가
                    //      x-1         x
                    // y-1  250000001   500000004
                    //  y   500000004       ?
                    // 위 처럼 큰 수들이 들어가면 문제가 생기므로, 모든 행렬에 대해 모듈러 연산을 수행
                    if (route[i][j] >= 1000000007) {
                        route[i][j] %= 1000000007;
                    }
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(route[i][j]);
            }
            System.out.println();
        }

        return route[n-1][m-1];
    }
}
