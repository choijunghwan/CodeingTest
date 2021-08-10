package Programmers.Hash;

import java.util.*;
import java.util.Map.Entry;

public class Hash4 {
    public static void main(String[] args) {
        String[] genres = {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
        int[] plays = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            if (!map.containsKey(key)) {
                map.put(key, plays[i]);
            } else {
                map.put(key, map.get(key) + plays[i]);
            }
        }

        System.out.println("map = " + map);


        // Map.Entry 리스트 작성
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

        // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            @Override
            // compare로 값을 비교
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                // 내림 차순으로 정렬
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println("내림 차순 정렬");

        ArrayList<Integer> answer = new ArrayList<>();

        // 결과 출력
        for (Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            Comparator<String> comparator = (s1, s2)->s2.compareTo(s1);
            Map<Integer, Integer> position = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if (entry.getKey().equals(genres[i])) {
                    position.put(i, plays[i]);
                }
//                System.out.println("i = " + i);
            }

            System.out.println("position = " + position);
            // value 값을 기준으로 정렬
            List<Integer> valueList = new ArrayList<>(position.values());
            valueList.sort((s1, s2) -> s2.compareTo(s1));

            int count = answer.size();
            loopOut:
            for (Integer value : valueList) {
                System.out.println("value = " + value);

//                    answer.add(position.get(value));
//                for (int j = 0; j < plays.length; j++) {
//                    if (value == plays[j]) {
//                        answer.add(j);
//                        if (answer.size() - count == 2) {
//                            break loopOut;
//                        }
//                    }
//                }
                Collection<Integer> values = position.keySet();
                for (Integer pos : values) {
//                    System.out.println("integer = " + integer);
                    if (value == plays[pos]) {
                        answer.add(pos);
                        if (answer.size() - count == 2) {
                            break loopOut;
                        }
                    }
                }

            }

        }

        System.out.println("answer = " + answer);
        System.out.println("answer.size = " + answer.size());
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        System.out.println("result = " + result.length);

    }
}

