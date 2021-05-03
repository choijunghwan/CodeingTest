package KAKAO;

public class KAKAO_2020_1 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        String s1 = "a";

        int answer = solution(s1);
        System.out.println("answer = " + answer);
    }

    public static int solution(String s){
        int count = 1;
        int answer = 1000;

        if (s.length() == 1){
            return 1;
        }

        // 여러개 비교할경우
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < s.length(); j += i) {
                if (j + i >= s.length()){
                    if (count != 1){
                        result.append(Integer.toString(count));
                    }
                    result.append(s.substring(j,s.length()));
                    count = 1;
                    break;
                } else if (j+i+i > s.length()){
                    if (count != 1) {
                        result.append(Integer.toString(count));
                    }
                    result.append(s.substring(j,s.length()));
                    count = 1;
                    break;
                }

                String left = s.substring(j,j+i);
                String right = s.substring(j+i, j+i+i);

                if (left.equals(right)){
                    count++;
                } else {
                    if (count == 1){
                        result.append(left);
                    } else {
                        result.append(Integer.toString(count));
                        result.append(left);
                        count = 1;
                    }
                }

            }

            System.out.println("result = " + result);
            answer = Math.min(result.length(), answer);
        }

        return answer;
    }
}
