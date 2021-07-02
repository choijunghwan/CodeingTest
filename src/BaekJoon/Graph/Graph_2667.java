package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Graph_2667 {
    static int[][] map;
    static int[][] aptMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2];
        aptMap = new int[N+2][N+2];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 1 && aptMap[i][j] == 0) {
                    getAptNumber(i,j, ++count);
                }
            }
        }
        System.out.println(count);
        int[] aptCount = new int[count];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (aptMap[i][j] != 0) {
                    aptCount[aptMap[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(aptCount);
        for (int c : aptCount) {
            System.out.println(c);
        }
    }

    private static void getAptNumber(int x, int y, int count) {
        aptMap[x][y] = count;

        // 위
        if ((map[x - 1][y] == 1) && (aptMap[x - 1][y] == 0)) {
            getAptNumber(x - 1, y, count);
        }
        // 아래
        if ((map[x + 1][y] == 1) && (aptMap[x + 1][y] == 0)) {
            getAptNumber(x + 1, y, count);
        }
        // 좌
        if ((map[x][y - 1] == 1) && (aptMap[x][y - 1] == 0)) {
            getAptNumber(x, y - 1, count);
        }
        // 우
        if ((map[x][y + 1] == 1) && (aptMap[x][y + 1] == 0)) {
            getAptNumber(x, y + 1, count);
        }
    }
}
