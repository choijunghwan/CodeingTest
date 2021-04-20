package Greedy;

public class Greedy3 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        String answer = solution(number, k);
        System.out.println("answer = " + answer);
    }

    /**
     * String을 int로 변환하여 비교할때는 int 표현범위 제한에 걸리수있는지 가능성을 체크해야한다.
     * 위의 문제에서는 number이 1,000,000 자리까지 input 될수 있으므로 int로 변환하면 런타임 에러가 뜬다.
     *
     * 4177252841
     * 한자리씩 뺏을때 가장 큰수를 저장한다.
     */
    public static String first_Solution(String number, int k) {

        for (int i = 0; i < k; i++) {
//            String max = number.substring(1, number.length());
            StringBuilder max = new StringBuilder();
            max.append(number.substring(1, number.length()));
            for (int j = 1; j < number.length(); j++) {
                StringBuilder temp = new StringBuilder();
                temp.append(number.substring(0, j));
                temp.append(number.substring(j + 1, number.length()));
//                String l_sub = number.substring(0, j);
//                String r_sub = number.substring(j + 1, number.length());
//                String result = l_sub.concat(r_sub);

                max = (max.compareTo(temp) >= 0) ? max : temp;
            }
            System.out.println("max = " + max);
            number = max.toString();
        }

        return number;
    }

    /**
     * number을 앞에서부터 차례로 훑어보면서
     * 1. 숫자 9가 나오면 다음부터는 9이후부터 탐색한다.
     * 2. n번재 자리 수 보다 n+1번째 자리 수가 더 크면 n번째 자리를 삭제시킨다.
     * 3. 만약 모든숫자가 998876554321 처럼 내림차순으로 정렬되어 있다면 제일 끝에 숫자를 삭제시킨다.
     *
     * 이 코드는 11번 케이스에서 시간초과한 케이스다.
     */
    public String second_Solution(String number, int k) {
        int startIndex = 0;

        for (int i = 0; i < k; i++) {
            int len = number.length();
            boolean descending = true;

            for (int j = startIndex; j < number.length()-1; j++) {
                if (number.charAt(j) == '9') {
                    startIndex++;
                    continue;
                }
                if (number.charAt(j) - number.charAt(j+1) < 0) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(number.substring(0, j));
                    temp.append(number.substring(j + 1, number.length()));
                    number = temp.toString();
                    descending = false;
                    break;
                }

            }

            if (descending) {
                number = number.substring(0, number.length()-1);
            }


        }

        return number;
    }

    /**
     * second_solution 에서
     * String 처리부분을 모두 StringBuilder로 바꿔주고, 불필요한 부분을 최대한 지워주니 통과되었다.
     */
    public static String solution(String number, int k) {

        StringBuilder sb = new StringBuilder(number);
        int startIndex = 0;

        for (int i = 0; i < k; i++) {
            boolean descending = true;

            for (int j = startIndex; j < sb.length()-1; j++) {
                if (sb.charAt(j) == '9') {
                    startIndex++;
                    continue;
                }
                if (sb.charAt(j) - sb.charAt(j+1) < 0) {
//                    StringBuilder temp = new StringBuilder();
//                    temp.append(sb.substring(0, j));
//                    temp.append(sb.substring(j + 1, sb.length()));
                    sb.delete(j,j+1);
//                    sb.append(temp);
                    descending = false;
                    break;
                }

            }

            if (descending) {
                sb.delete(sb.length() - 1, sb.length());
            }

            System.out.println("sb = " + sb);
        }

        return sb.toString();
    }
}
