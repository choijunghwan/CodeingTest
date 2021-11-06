package TestCodeReview.woowahan;

public class Solve7 {

    public String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];

        if (clockwise) {  // 시계방향
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                int cnt = 2 * i + 1;

                int r = grid.length - 1;
                int c = 2 * i;

                // (r,c) -> (r, c - 1) -> (r -1, c - 2) 순서로 삽입
                while (cnt > 0) {
                    sb.append(grid[r].charAt(c));
                    cnt--;

                    c = c - 1;

                    if (c < 0) {
                        break;
                    }

                    sb.append(grid[r].charAt(c));
                    r = r - 1;
                    c = c - 1;
                    cnt--;
                }
                answer[i] = sb.toString();
            }
        } else {   //반시계 방향
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                int cnt = 2 * i + 1;

                int r = grid.length - 1 - i;
                int c = 2 * r;

                // (r,c) -> (r + 1, c + 1) -> (r + 1, c) -> (r + 2, c)
                sb.append(grid[r].charAt(c));
                cnt--;
                while (cnt > 0) {
                    r = r + 1;
                    c = c + 1;
                    sb.append(grid[r].charAt(c));
                    cnt--;

                    c = c - 1;
                    sb.append(grid[r].charAt(c));
                    cnt--;
                }
                answer[i] = sb.toString();
            }
        }
        return answer;
    }
}
