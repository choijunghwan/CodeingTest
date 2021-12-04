package TestCodeReview.DevMatching.last_2021;

public class Solve1 {

    // (0,0) ~ (0, len-1) 까지 차례로 반복
    // 자기 위치를 (r,c)로 나타내고
    // r > len 이 되거나, *를 두번 만날때까지 반복

    public int solution(String[] drum) {
        int answer = 0;

        int len = drum.length;

        for (int i = 0; i < len; i++) {
            int r = 0;
            int c = i;
            int starCnt = 0;

            while (r < len) {
                char ch = drum[r].charAt(c);

                if (ch == '#') {
                    r++;
                } else if (ch == '>') {
                    c++;
                } else if (ch == '<') {
                    c--;
                } else if (ch == '*') {
                    r++;
                    starCnt++;
                }

                if (starCnt == 2) {
                    answer++;
                    break;
                }
            }

        }

        return len - answer;
    }
}
