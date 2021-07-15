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
        int result = solution1(line1, line2);
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

    // 정규표현식을 사용하지 않은 이유
    // 정규표현식은 하나의 조건에 대해 문자열을 검증할때 주로 사용한다.
    // 하지만 위 문제의 경우 조건이 계속해서 변하며
    // 정규표현식은 문자열이 포함되어 있는지 true, false로 반환하는 반면에
    // 위 문제는 문자열이 몇개 포함되어 있는지 갯수를 세어야 한다.
    // 그래서 abbbabbb 의 경우 bbb를 정규표현식으로 체크하면 2개가 나오는것이 아닌 true가 나오므로
    // 갯수를 셀려고 할때는 적합하지 않다.
    private static int solution1(String line1, String line2) {
        int answer = 0;
        int len2 = line2.length();
        int len1 = line1.length();
        int blank = 0;

        while (true) {
            int changeLen = len2 + (len2 - 1) * blank;

            if (changeLen > len1) {
                break;
            }

            String temp = line1;
            String pattern ="^.*";
            for (int j = 0; j < len2; j++) {
                pattern += Character.toString(line2.charAt(j));
                if (j != len2 - 1) {
                    pattern += ".{" + blank + "}";
                }
            }
            pattern += ".*$";
            boolean validation = temp.matches(pattern);
            while (validation) {
                temp = temp.replaceFirst(pattern, "   ");
                answer++;
                validation = temp.matches(pattern);
            }


            blank++;
        }

        return answer;
    }

}
