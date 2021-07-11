package TestCodeReview.Programmers;

/**
 * 요구사항
 * 1. 첫 번째 보트에는 1개를 실어서 보낸다.
 * 2. 이게 성공하면 그 다음부터는 이전에 보낸 것에 2배를 실어 보낸다.
 * 3. 위에 제시한 방법으로 상자를 보내는 경우 사용하게 된 보트의 수를 return
 * 4. m개를 보내는데 보트의 수가 부족하면 -1을 리턴
 *
 * 제한사항
 * 1. d의 길이는 1이상 1000이하
 * 2. d의 각 원소는 1이상 6000이하의 자연수
 * 3. m은 1이상 200000 이하의 자연수
 */
public class programming1 {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int m = 6;
        int result = solution(d, m);
        System.out.println(result);
    }

    private static int solution(int[] d, int m) {
        int answer = 0;
        int box = 1;
        int cnt = 0;

        for (int i = 0; i < d.length; i++) {

            // 상자를 다 보냈을 경우
            if (cnt >= m) {
                break;
            }

            if (d[i] >= box) {
                cnt += box;
                box *= 2;
            } else if (d[i] < box) {
                box = 1;
            }

            answer++;
        }

        // 보트의 수가 부족해 m개를 보내는데 실패한 경우
        if (cnt < m) {
            answer = -1;
        }

        return answer;
    }


}
