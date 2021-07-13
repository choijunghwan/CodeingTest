package TestCodeReview.Kakaopay;

/**
 * 주어진 line2에 변형 문자열을 일일이 대조해보는 완전 탐색을 하였습니다.
 * 공백 부분은 문자를 비교하지 않아도 되므로 line2의 변형 문자열에서 공백은 뛰어넘고
 * 공백이아닌 문자만 바교하였습니다.
 *
 * line1과 비교할때 line2 변형 문자열이 line1을 넘지 않는 선까지만 비교하고
 * 비교하다가 문자가 하나라도 틀리면 break를 통해 다음 경우를 고려하면서, 약간의 효율성 상승을 노력하였습니다.
 */
public class programming3 {
    public static void main(String[] args) {
        String line1 = "abbbcbbb";
        String line2 = "bbb";
        int result = solution(line1, line2);
        System.out.println(result);
    }

    private static int solution(String line1, String line2) {
        int answer = 0;
        int len2 = line2.length();
        int blank = 0;
        int len1 = line1.length();

        while (true) {
            int changeLen = len2 + (len2 - 1) * blank;

            if (changeLen > len1) {
                break;
            }

            for (int i = 0; i <= len1 - changeLen; i++) {
                boolean check = true;
                for (int j = 0; j < len2; j++) {
                    if (line2.charAt(j) != line1.charAt(i + (blank + 1) * j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer++;
                }
            }

            blank++;
        }

        return answer;
    }

    private static int solution1(String line1, String line2) {
        int answer = 0;
        int len2 = line2.length();
        int len1 = line1.length();
        int blank = 0;
    }

}
