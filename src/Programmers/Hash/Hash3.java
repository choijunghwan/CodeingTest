package Programmers.Hash;

import java.util.HashMap;
import java.util.Iterator;

public class Hash3 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String item = clothes[i][1];
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                map.put(item, map.get(item) + 1);
            }
        }

        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        System.out.println("answer = " + (answer -1));

        /*ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < clothes.length; i++) {
            String item = null;
            item = clothes[i][1];
            if (!arrayList.contains(item)) {
                arrayList.add(item);
            }
        }

        System.out.println("arrayList = " + arrayList);


        for (String s : arrayList) {
            int count = 1;
            for (int i = 0; i < clothes.length; i++) {
                if (clothes[i][1].equals(s)) {
                    count++;
                }
            }
            answer *= count;
        }

        System.out.println("answer = " + (answer-1));*/
    }
}
