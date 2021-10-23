package TestCodeReview.NHN;


import java.util.ArrayList;
import java.util.List;

public class Solve3 {

    public static void main(String[] args) {
        int numOfConflict = 3;
        int[][] conflicts = {{5, 3}, {4, 3}, {4, 7}, {3, 6}};

        solution(numOfConflict, conflicts);
    }

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;

    private static void solution(int numOfConflict, int[][] conflicts) {
        for (int i = 0; i <= 8; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] conflict : conflicts) {
            int A = conflict[0];
            int B = conflict[1];
            list.get(A).add(B);
            list.get(B).add(A);
        }

        for (int i = 1; i <= 8; i++) {
            visited = new boolean[9];
            DFS(i, 0);
        }
    }

    private static void DFS(int start, int index) {
        if (index == 7) {
            ans++;
            return;
        }

        visited[start] = true;

        for (int i = 1; i <= 8; i++) {
            if (visited[i]) {
                continue;
            }

            if (list.get(start).contains(i)) {
                continue;
            }

            DFS(i, index + 1);
            visited[i] = false;
        }
    }
}
