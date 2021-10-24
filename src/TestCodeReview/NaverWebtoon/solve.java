package TestCodeReview.NaverWebtoon;

public class solve {

    /**
     * 정수를 입력 받아 3자리 마다 콤마(,) 를 추가하는 함수를 작성하여라.
     * 예를 들어 1234가 입력되면 1,234를 반환하여야 하고 123456789가 입력되면 123,456,789를 반환하여야 한다.
     */
    /**
     * 1. String -> StringBuilder로 변환
     * 2. 정수를 양수, 음수 나눠서 생각할것
     * 3. 정수를 문자로 변활할때 0이 포함된 경우를 고려할것.
     */
    public static void main(String[] args) {
        int num = 123456789;

        StringBuilder sb = new StringBuilder();
        boolean minus = false;
        if (num < 0) {
            minus = true;
            num *= -1;
        }

        while (num >= 1000) {
            String value = intToString(num%1000);
            sb.insert(0, value);
            sb.insert(0, ",");
            num /= 1000;
        }
        sb.insert(0, Integer.toString(num));

        if (minus) {
            sb.insert(0, "-");
        }

        System.out.println("str = " + sb.toString());


    }

    private static String intToString(int num) {
        char[] arr = new char[3];

        for (int i = 2; i >= 0; i--) {
            if (num > 0) {
                arr[i] = (char) ((num % 10) + '0');
                num /= 10;
            } else {
                arr[i] = '0';
            }
        }

        return new String(arr);
    }

}
