package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1212 {
    static char[] twoCharArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eight = br.readLine();
        char[] eightCharArr = eight.toCharArray();

        int twoLen = getPossibleDigitNumber(eightCharArr);
        twoCharArr = new char[twoLen];

        int index = twoLen - 1;
        // 가장 첫 번째 자리(맨뒤의 수) 부터 탐색 시작
        for (int i = eight.length() - 1; i >= 0; i--) {
            char num = eightCharArr[i];
            index = getTwoDigitNumber(num, index);
        }

        System.out.println(new String(twoCharArr));
    }

    // 8진수 숫자 1개 -> 2진수 숫자 3개 변환
    // 2진수의 현재 index 리턴
    static int getTwoDigitNumber(char ch, int nowIndex) {
        int num = ch - '0';

        // 총 3회 반복
        for (int i = 0; i < 3; i++) {
            twoCharArr[nowIndex--] = (char) ((num % 2) + '0');
            num /= 2;

            if (nowIndex < 0) { // 이미 2진수개수를 알고 있으므로 index로 길이 판단.
                break;
            }
        }

        return nowIndex;
    }

    // 8진수를 2진수로 변환 했을 때의 2진수의 길이 리턴
    static int getPossibleDigitNumber(char[] charArr) {
        int len = charArr.length * 3;

        if (len == 0) {
            return 0;
        }

        int firstNum = charArr[0] - '0';
        if (firstNum / 4 > 0) { // 첫 번째 숫자가 3자리 가능
            return len;
        }
        if (firstNum / 2 > 0) { // 첫 번째 숫자가 2자리 가능
            return len - 1;
        }

        return len - 2;

    }
}
