package TestCodeReview.Line;

public class Solve1 {

    public int solution(int[] student, int k) {
        int answer = 0;
        for (int i = 0; i < student.length; i++) {
            int count = 0; //재학생 수
            for (int j = i; j < student.length; j++) {
                if (student[j] == 1) {
                    count++;
                }

                if (count == k) {
                    answer++;
                } else if (count > k) {
                    break;
                }
            }
        }

        return answer;
    }
}
