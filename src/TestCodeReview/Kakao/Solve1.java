package TestCodeReview.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solve1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> record = new HashMap<>();
        Map<String, Integer> recordCnt = new HashMap<>();
        for (String id : id_list) {
            record.put(id, new ArrayList<>());
            recordCnt.put(id, 0);
        }

        for (String rp : report) {
            String[] str = rp.split(" ");
            String userId = str[0];
            String reportUserId = str[1];

            if (record.get(userId).contains(reportUserId)) { //이미 신고한 경우
                continue;
            }

            record.get(userId).add(reportUserId);
            recordCnt.put(reportUserId, recordCnt.get(reportUserId) + 1);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];

            int reportCnt = recordCnt.get(userId);
            if (reportCnt < k) {
                continue;
            }

            for (int j = 0; j < id_list.length; j++) {
                if (i == j) continue;
                List<String> list = record.get(id_list[j]);
                if (list.contains(userId)) {
                    answer[j]++;
                }
            }
        }


        return answer;
    }
}
