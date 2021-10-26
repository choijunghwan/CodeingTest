package Programmers.WeeklyChallenge;

public class Solve12 {

    // 모든 경우를 탐색해보면서 최대 던전수를 찾는다.
    // 모든 경우를 탐색하는 방법은 DFS를 이용한다.
    static int ans = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        DFS(0, 0, k, dungeons);

        return ans;
    }

    private void DFS(int depth, int cnt, int k, int[][] dungeons) {

        // 던전을 모두 탐색해봤을때
        if (depth == dungeons.length) {
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            // 던전 "최소 필요 피로도"를 만족한다면 던전 탐험
            if (k >= dungeons[i][0]) {
                DFS(depth + 1, cnt + 1, k - dungeons[i][1], dungeons);
            } else {
                DFS(depth + 1, cnt, k, dungeons);
            }
            visited[i] = false;
        }

    }
}
