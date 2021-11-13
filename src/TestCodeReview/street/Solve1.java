package TestCodeReview.street;

// 11번가 코테
public class Solve1 {

    public int solution(int[] A) {
        int maxOdd = 0;
        int maxEven = 0;

        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) { //even
                maxEven = Math.max(maxEven, A[i]);
            } else {
                maxOdd = Math.max(maxOdd, A[i]);
            }
        }

        return maxOdd + maxEven;
    }
}
