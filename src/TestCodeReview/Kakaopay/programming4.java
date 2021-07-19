package TestCodeReview.Kakaopay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class programming4 {
    public static void main(String[] args) {
        int[] ages = {35, 25, 3, 8, 7};
        int[][] wires = {{1, 2, 5}, {2, 1, 5}, {1, 3, 2}, {3, 4, 2}, {3, 5, 20}, {4, 5, 1}};
        int[] result = solution1(ages, wires);
        System.out.println(Arrays.toString(result));

        int[] arr = {30, 25, 3, 5, 7};  // 정렬해서 3 4 5 2 1

    }

    // 이 문제를 Graph로 풀수는 없을까요??
    // 인접 리스트를 이용해 각 발전기에서 연결되어있는 발전기 번호와 전력 길이를 입력
    // boolean[] stop -> 중단 여부, int[] stopTime -> 다른 발전기로부터 전력 도착 시간
    // int[] stopTime -> 발전기 수명 과 전력 도착시간을 비교해 발전기 중단 시간 유추
    // 전력 도착시간은 제일 늦게 들어오는 전력 시간 기준이므로 최대 값을 넣어준다.
    // 발전기 중단 시간 = min(전력 도착 시간, 발전기 수명)
    private static int[] solution1(int[] ages, int[][] wires) {
        ArrayList<ArrayList<electronic>> arrayLists = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < ages.length; i++) {
            arrayLists.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            arrayLists.get(wire[0] - 1).add(new electronic(wire[1], wire[2]));
        }

        boolean[] stop = new boolean[ages.length];  // 중단 여부
        int[] arrive = new int[ages.length];     // 전력 도착시간
        int[] stopTime = ages;    // 중단 시간
        for (int i = 0; i < ages.length; i++) {
            int min = 999999;
            int index = 0;
            for (int j = 0; j < stopTime.length; j++) {
                if (min > stopTime[j] && !stop[j]) {
                    min = stopTime[j];
                    index = j;
                }
            }

            stop[index] = true;
            answer.add(index+1);

            ArrayList<electronic> list = arrayLists.get(index);
            for (electronic e : list) {
                if (arrive[e.node - 1] == 0) {
                    arrive[e.node - 1] = min + e.len;
                } else {
                    arrive[e.node - 1] = Math.max(arrive[e.node - 1], min + e.len);
                }
                stopTime[e.node - 1] = Math.min(arrive[e.node -1], ages[e.node -1]);
            }

        }

        int[] result = new int[answer.size()];
        int size = 0;
        for (Integer a : answer) {
            result[size++] = a;
        }

        return result;
    }

    private static int[] solution(int[] ages, int[][] wires) {

        // 2차원 배열에 발전기 번호를 넣지않고 푸는 방법은 없을까요??
        // 1번 발전기  35  30
        // 2번 발전기  25  40
        // 3번 발전기  3   37
        // 4번 발전기  8   5
        // 5번 발전기  7   23  9
        //  30  25  3  5  7

        // 왜 2차원 배열 자료구조를 선택했냐??
        // 조회가 빠르고, 발전기의 번호도 필요해서 1차원 대신 2차원 배열을 선택
        long[][] arr = new long[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = i + 1;
        }

        for (int[] wire : wires) {
            arr[wire[1] - 1][0] = Math.min(arr[wire[1] - 1][0], ages[wire[0] - 1] + wire[2]);
        }

        // 이렇게 2차원 배열 정렬이 효율성이 좋냐/?
        // 기본적으로 Timsort(하이브리드 정렬: 삽입 정렬 + 병합정렬)로 구현되어 있다.

        // 아싸리 우선순위 큐에 넣는 경우는 어떤거 같냐?
        // -> 우선순위 큐를 이용하면 값을 넣는과 동시에 정렬을 할수는 있지만
        // 발전기의 수명 최소값을 구할때는 일일이 조회를 해야 하는데 우선순위 큐 자체가 큐의방식을 갖고 있어서
        // 조회에는 성능이 안좋다. 또한 마지막에 우선순위 큐를 넣어 정렬을 하는것보다
        // 2차원 배열을 바로 정렬하는 것이 더욱 효율적이다.
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            } else {
                return Long.compare(o1[0], o2[0]);
            }
        });

        // 발전기 번호를 return 해주는 것이기 때문에
        // 문제에서 발전기 번호는 100000을 넘지 않는다고 했으므로 int형으로 변환
        int[] answer = new int[ages.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = (int) arr[i][1];
        }
        return answer;
    }
}

class electronic {
    int node;
    int len;

    public electronic(int node, int len) {
        this.node = node;
        this.len = len;
    }
}