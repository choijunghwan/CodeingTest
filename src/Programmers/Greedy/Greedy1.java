package Programmers.Greedy;

/**
 * Programmers.Greedy(탐욕법)이란?
 * 경우의 수가 존재할 경우, 최선이라고 생각하는 경우를 선택한다.
 * 즉, 최종적으로는 그 선택이 최선이 아닐 수 있지만, 지금 선택할 때는 최선인 경우를 선택한다.
 * 예를 들어, 지금 초코파이를 먹을 수 있지만, 10분 후면 랍스타를 먹을 수 있다.
 * Programmers.Greedy 알고리즘 경우에는 현재 최선을 다하므로 초코파이를 먹는 선택을 한다.
 */
public class Greedy1 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,3,4};
        int[] reserve = {2,3};

        int answer = solution(n, lost, reserve);
        System.out.println("answer = " + answer);
    }


    /**
     * 체육복을 가지고 있는 갯수를 배열에 저장한다.
     * n=5, lost=[2,4], reserve=[1,3,5]
     * cloth = [2,0,2,0,2]
     * 0일때 바로 앞이랑, 뒤를 탐색해 2개를 가지고 있음 한개를 빌린다.
     *
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] cloth = new int[n];

        for (int i = 0; i < n; i++) {
            cloth[i] = 1;
        }
        for (int i = 0; i < lost.length; i++) {
            cloth[lost[i] - 1] -= 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            cloth[reserve[i] - 1] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (cloth[i] == 0) {
                if (i - 1 > 0 && cloth[i - 1] == 2) {
                    cloth[i - 1] -= 1;
                    cloth[i] += 1;
                } else if (i + 1 < n && cloth[i + 1] == 2) {
                    cloth[i] += 1;
                    cloth[i + 1] -= 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (cloth[i] >= 1) {
                count++;
            }
        }

        return count;

    }
}
