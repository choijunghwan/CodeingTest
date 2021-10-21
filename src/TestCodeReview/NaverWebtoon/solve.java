package TestCodeReview.NaverWebtoon;

public class solve {

    /**
     * 정수를 입력 받아 3자리 마다 콤마(,) 를 추가하는 함수를 작성하여라.
     * 예를 들어 1234가 입력되면 1,234를 반환하여야 하고 123456789가 입력되면 123,456,789를 반환하여야 한다.
     */
    public static void main(String[] args) {
        int num = 1099;

        String str = "";

        while (num >= 1000) {

            str = Integer.toString(num % 1000) + str;
            num /= 1000;
            if (num != 0) {
                str = "," + str;
            }

        }
        str = Integer.toString(num) + str;

        System.out.println("str = " + str);

    }

    /**
     * 1. String -> StringBuilder로 변환
     * 2. 정수를 양수, 음수 나눠서 생각할것
     * 3. 정수를 문자로 변활할때 0이 포함된 경우를 고려할것.
     */
}
