package TestCodeReview.Line;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solve5 {

    boolean[] checked;
    List<List<Integer>> list;

    public int solution(String[] nicks, String[] emails) {
        // (a,b) (b,c) -> (a,c)
        // 유사한 유저 리스트를 만든뒤 BFS를 활용해 몇개의 그룹으로 나뉘는지 갯수를 센다
        // 7명  (1,3) (1,4) (3,5) (2,6)
        int userCnt = nicks.length;
        checked = new boolean[userCnt];
        list = new ArrayList<>();
        for (int i = 0; i <= userCnt; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < userCnt - 1; i++) {
            for (int j = i + 1; j < userCnt; j++) {
                boolean isSameNick = isSameNick(nicks[i], nicks[j]);
                if (!isSameNick) { // 닉네임이 같지 않다면
                    continue;
                }

                boolean isSameEmail = isSameEmail(emails[i], emails[j]);
                if (!isSameEmail) { // 이메일이 같지 않다면
                    continue;
                }
                list.get(i).add(j);
                list.get(j).add(i);
            }
        }


        for (int i = 0; i < userCnt; i++) {
            if (!checked[i]) {
                BFS(i);
            }
        }

        int answer = -1;
        return answer;
    }

    private void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {

        }
    }
    private boolean isSameEmail(String emailA, String emailB) {
        String[] A = emailA.split("@");
        String[] B = emailB.split("@");

        if (A[0].equals(B[0])) {
            return true;
        }

        int idxEmailA = 0;
        int idxEmailB = 0;
        int count = 0;

        while (idxEmailA < A[0].length() && idxEmailB < B[0].length()) {
            char chEmailA = emailA.charAt(idxEmailA);
            char chEmailB = emailB.charAt(idxEmailB);

            if (chEmailA == chEmailB) {
                idxEmailA++;
                idxEmailB++;
                continue;
            }

            if (emailA.charAt(idxEmailA+1) == chEmailB) {
                idxEmailA += 2;
                idxEmailB++;
                count++;
            } else if (emailB.charAt(idxEmailB+1) == chEmailA) {
                idxEmailB += 2;
                idxEmailA++;
                count++;
            } else {
                return false;
            }

            if (count > 1) {
                return false;
            }
        }

        if (idxEmailA < A[0].length()) {
            count += A[0].length() - idxEmailA - 1;
        }
        if (idxEmailB < B[0].length()) {
            count += B[0].length() - idxEmailB - 1;
        }

        if (count > 1) {
            return false;
        }

        if (A[1].equals(B[1])) {
            return true;
        }

        return false;

    }
    private boolean isSameNick(String userA , String userB) {
        // A가 두번, A 한번 B 한번, B가 두번

        if (userA.equals(userB)) {
            return true;
        }

        int idxUserA = 0;
        int idxUserB = 0;
        int count = 0;

        while (idxUserA < userA.length() && idxUserB < userB.length()) {
            char chUserA = userA.charAt(idxUserA);
            char chUserB = userA.charAt(idxUserB);

            if (chUserA == chUserB) {
                idxUserA++;
                idxUserB++;
                continue;
            }

            if (userA.charAt(idxUserA+1) == chUserB) {
                idxUserA += 2;
                idxUserB++;
                count++;
            } else if (userA.charAt(idxUserA+2) == chUserB) {
                idxUserA += 3;
                idxUserB++;
                count += 2;
            } else if (userB.charAt(idxUserB+1) == chUserA) {
                idxUserB += 2;
                idxUserA++;
                count++;
            } else if (userB.charAt(idxUserB+2) == chUserA) {
                idxUserB += 3;
                idxUserA++;
                count += 2;
            } else {
                return false;
            }

            if (count > 2) {
                return false;
            }
        }

        if (idxUserA < userA.length()) {
            count += userA.length() - idxUserA - 1;
        }
        if (idxUserB < userB.length()) {
            count += userB.length() - idxUserB - 1;
        }

        if (count > 2) {
            return false;
        }

        return true;
    }

}
