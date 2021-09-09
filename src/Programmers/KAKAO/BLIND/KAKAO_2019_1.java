package Programmers.KAKAO.BLIND;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_2019_1 {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (String cmd : record) {
            String[] str = cmd.split(" ");

            if (str[0].equals("Enter")) {
                user.put(str[1], str[2]);
                list.add(new String[]{str[1], "님이 들어왔습니다."});
            } else if (str[0].equals("Leave")) {
                list.add(new String[]{str[1], "님이 나갔습니다."});
            } else if (str[0].equals("Change")) {
                user.put(str[1], str[2]);
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < answer.length; i++){
            String[] str = list.get(i);
            String nickName = user.get(str[0]);
            answer[i] = nickName + str[1];
        }
        return answer;
    }
}
