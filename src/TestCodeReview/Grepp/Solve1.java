package TestCodeReview.Grepp;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solve1 {

    boolean isLogin = false;  // 로그인 여부
    List<Integer> cart; // 장바구니
    public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = new boolean[actions.length];
        cart = new ArrayList<>();

        for (int i = 0; i < actions.length; i++) {
            StringTokenizer st = new StringTokenizer(actions[i], " ");
            String command = st.nextToken();
            boolean result = false;

            if (command.equals("LOGIN")) {
                result = login(infos, st.nextToken(), st.nextToken());
            } else if (command.equals("ADD")) {
                result = add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("ORDER")) {
                result = order();
            }
            answer[i] = result;
        }

        return answer;
    }

    private boolean order() {
        if (cart.isEmpty()) {
            return false;
        }

        cart.clear();
        return true;
    }

    private boolean add(int food) {
        if (!isLogin) {
            return false;
        }

        cart.add(food);
        return true;
    }

    private boolean login(String[] infos, String id, String password) {
        // 로그인 상태
        if (isLogin) {
            return false;
        }

        for (String info : infos) {
            String[] str = info.split(" ");
            if (str[0].equals(id) && str[1].equals(password)) {
                isLogin = true;
                return true;
            }
        }

        return false;
    }
}
