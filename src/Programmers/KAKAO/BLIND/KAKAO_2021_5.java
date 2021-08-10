package Programmers.KAKAO.BLIND;

public class KAKAO_2021_5 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String result = solution(play_time, adv_time, logs);
        System.out.println("result = " + result);
    }

    private static int convert(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 3600 +
                Integer.parseInt(arr[1]) * 60 +
                Integer.parseInt(arr[2]);
    }
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convert(play_time);
        int advSec = convert(adv_time);
        int[] total = new int[100 * 3600];

        for (String log : logs) {
            int start = convert(log.substring(0,8));
            int end = convert(log.substring(9,17));

            for (int i = start; i < end; i++) {
                total[i]++;
            }
        }

        long currSum = 0;
        int maxIdx = 0;
        for (int i = 0; i < advSec; i++) {
            currSum = currSum + total[i];
        }
        long maxSum = currSum;

        for (int i = advSec; i < playSec; i++) {
            currSum = currSum + total[i] - total[i - advSec];
            if (maxSum < currSum) {
                maxSum = currSum;
                maxIdx = i - advSec + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxIdx / 3600, maxIdx / 60 % 60, maxIdx % 60);
    }
}
