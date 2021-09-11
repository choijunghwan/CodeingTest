package TestCodeReview.Kakao;

import java.util.*;

public class Solve3 {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = solution(fees, records);
    }
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> visitRecord = new HashMap<>();
        Map<String, Integer> parkPrice = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            if (split[2].equals("IN")) {
                visitRecord.put(split[1], split[0]);
            } else if (split[2].equals("OUT")) {
                String inputTime = visitRecord.get(split[1]);
                int parkTime = getParkTime(inputTime, split[0]);

                if (parkPrice.containsKey(split[1])) {
                    parkPrice.put(split[1], parkPrice.get(split[1]) + parkTime);
                } else {
                    parkPrice.put(split[1], parkTime);
                }

                visitRecord.remove(split[1]);
            }
        }

        Iterator<String> recordKeys = visitRecord.keySet().iterator();
        while (recordKeys.hasNext()){
            String key = recordKeys.next();
            int parkTime = getParkTime(visitRecord.get(key), "23:59");

            if (parkPrice.containsKey(key)) {
                parkPrice.put(key, parkPrice.get(key) + parkTime);
            } else {
                parkPrice.put(key, parkTime);
            }
        }

        Iterator<String> priceKeys = parkPrice.keySet().iterator();
        while (priceKeys.hasNext()) {
            String key = priceKeys.next();
            int value = parkPrice.get(key);

            if (value <= fees[0]) {
                parkPrice.put(key, fees[1]);
            } else if (value > fees[0]) {
                int sumPrice = fees[1];
                sumPrice += Math.ceil((double)(value - fees[0]) / fees[2] ) * fees[3];
                parkPrice.put(key, sumPrice);
            }
        }
        int[] answer = new int[parkPrice.size()];
        int index = 0;

        List<String> keyList = new ArrayList<>(parkPrice.keySet());
        keyList.sort(((o1, o2) -> {
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        }));

        for (String nKey : keyList)
        {
            answer[index++] = parkPrice.get(nKey);
        }
        return answer;
    }

    private static int getParkTime(String inTime, String outTime) {
        int input = convertTimeToMin(inTime);
        int output = convertTimeToMin(outTime);
        return output - input;
    }

    private static int convertTimeToMin(String time) {
        String[] str = time.split(":");
        int sumTime = 0;
        sumTime += Integer.parseInt(str[0]) * 60;
        sumTime += Integer.parseInt(str[1]);
        return sumTime;
    }
}
