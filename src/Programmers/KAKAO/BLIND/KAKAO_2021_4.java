package Programmers.KAKAO.BLIND;

public class KAKAO_2021_4 {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int result = solution(n, s, a, b, fares);
        System.out.println("result = " + result);
    }

    static final int INF = 4000000;
    static int[][] Dist = new int[200][200];

    public static void floyd(int n) {
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Dist[i][j] = Math.min(Dist[i][j], Dist[i][k] + Dist[k][j]);
                }
            }
        }
    }
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    Dist[i][j] = 0;
                } else {
                    Dist[i][j] = INF;
                }
            }
        }

        for (int[] edge : fares) {
            Dist[edge[0] -1][edge[1] -1] = edge[2];
            Dist[edge[1] -1][edge[0] -1] = edge[2];
        }

        floyd(n);

        s--;
        a--;
        b--;
        int answer = INF;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, Dist[s][i] + Dist[i][a] + Dist[i][b]);
        }

        return answer;
    }
}
