package Greedy;

import java.util.HashMap;

public class Greedy2 {
    public static void main(String[] args) {
        String name = "REAAAAAAAR";

        int answer = solution(name);
        System.out.println("answer = " + answer);
    }

    /**
     * A B C D E F G H I J  K  L  M  N  O  P  Q R S T U V W X Y Z
     * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 12 11 10 9 8 7 6 5 4 3 2 1
     *
     * 현재 시점에서 오른쪽으로 쭉 가는경우와, 왼쪽으로 다시 되돌아 가는 경우중
     * 최선의 선택을 하는 문제이다.
     */
    public static int solution(String name) {
        HashMap<String, Integer> map = new HashMap<>();
        String front = "ABCDEFGHIJKLMN";
        for (int i = 0; i < front.length(); i++) {
            String temp = Character.toString(front.charAt(i));
            map.put(temp, i);
        }
        String behind = "OPQRSTUVWXYZ";
        for (int i = 0; i < behind.length(); i++) {
            String temp = Character.toString(behind.charAt(i));
            map.put(temp, 12 - i);
        }

        int answer = 0;
        for (int i = 0; i < name.length(); i++) {
            String temp = Character.toString(name.charAt(i));
            answer += map.get(temp);
        }

        // 연속된 A의 등장에 따라 최소 움직임이 달라진다.
        // 내 위치에서 첫 위치로 돌아간 후(i+i) + A가 연속으로 나오는 지점의 다음부터 끝까지(len-next)
        // 위의 값이랑 그냥 쭉 오른쪽으로 이동했을때의 이동값 name.length() -1
        // 이 두개의 값중 최소값을 골라야 한다. Math.min(len -1, i+i+len-next)
        int min_move = name.length() -1;
        for (int i = 0; i < name.length(); i++) {

            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            min_move = Math.min(min_move, i + i + name.length() - next);

        }

        return answer + min_move;
    }

}
