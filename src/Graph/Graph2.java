package Graph;

import java.util.Arrays;

/**
 * 플로이드 와샬 알고리즘(Floyd
 * 모든 정점에서 모든 정점으로의 최단 거리를 구하는 알고리즘이다. all-to-all방식
 * 플로이드 알고리즘을 통해 모든 정점과의 최단거리를 구하고, 그 결과를 통해
 * 최단거리 값이 없는경우는 두 정점과의 관계가 일체 없다는 뜻으로 순위를 예측할 수 없다는 뜻으로 해석이 가능해서
 * 관계가 없는 수를 제외하고 갯수를 세어준다.
 */
public class Graph2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = solution(n, results);
        System.out.println("answer = " + answer);
    }

    static int INF = 987654321;
    public static int solution(int n, int[][] results) {
        int[][] scores = new int[n+1][n+1];

        for (int[] score : scores) {
            Arrays.fill(score, INF);
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == j) {
                    scores[i][j] = 0;
                }
            }
        }

        for (int[] result : results) {
            scores[result[0]][result[1]] = 1;
        }

        for (int[] score : scores) {
            System.out.println(Arrays.toString(score));
        }

        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if (scores[i][j] > scores[i][k] + scores[k][j]) {
                        scores[i][j] = scores[i][k] + scores[k][j];
                    }
                }
            }
        }

        for (int[] score : scores) {
            System.out.println(Arrays.toString(score));
        }

        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for (int i = 1; i < n+1; i++){
            for (int j =1; j < n+1; j++) {
                if(scores[i][j] == INF && scores[j][i] == INF) {
                    flag[i] = false;
                    break;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n+1; i++){
            if(flag[i]) answer++;
        }



        return answer;
    }
}
