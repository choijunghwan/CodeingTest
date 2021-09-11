package TestCodeReview.Line;

public class Solve2 {
    public static void main(String[] args) {
        String[] research = {"yxxy", "xxyyy"};
        int n = 2;
        int k = 1;

        String result = solution(research, n, k);
    }

    public static String solution(String[] research, int n, int k) {
        //검색어를 일별[26][] 2차원 배열에 기록한다.
        //이슈검색어 횟수를 [26]배열에 저장
        //사용된 검색어는 체크
        int[][] searchWordCnt = new int[26][research.length];  //검색어 일별 사용 횟수 저장
        boolean[] checked = new boolean[26];  // 검색어 사용 여부, 사용 했을경우 true
        int[] issueWordCnt = new int[26];

        for (int i = 0; i < research.length; i++) {
            String str = research[i];
            for (int j = 0; j < str.length(); j++) {
                char word = str.charAt(j);
                searchWordCnt[word - 'a'][i]++;
                checked[word - 'a'] = true;
            }
        }

        int issueCnt = 2 * n * k;
        for (int i = 0; i < searchWordCnt.length; i++) {
            if (!checked[i]) {  //한번도 검색어를 사용하지않은 경우
                continue;
            }

            for (int j = 0; j <= research.length - n; j++) {
                int count = 0;
                boolean isContinueDay = true;
                for (int t = j; t < j + n; t++) {
                    if (searchWordCnt[i][t] == 0) {
                        j = t + 1; //k번 이하로 검색된 날이 중간에 있으면 그 이후부터 탐색
                        isContinueDay = false;
                        break;
                    }
                    count += searchWordCnt[i][t];
                }

                if (isContinueDay && count >= issueCnt) {
                    issueWordCnt[i]++;
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < issueWordCnt.length; i++) {
            if (issueWordCnt[i] == 0) {
                continue;
            }

            if (max < issueWordCnt[i]) {
                max = issueWordCnt[i];
                index = i;
            }
        }
        String answer = "";
        if (max == 0 && index == 0){
            answer = "None";
        } else {
            answer = Character.toString(index + 'a');
        }
        return answer;
    }
}
