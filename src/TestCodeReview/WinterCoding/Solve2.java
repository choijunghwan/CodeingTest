package TestCodeReview.WinterCoding;

public class Solve2 {
    public static void main(String[] args) {
        int time = 100;
        int gold = 200;
        int[][] upgrade = {{0, 5}, {1500, 3}, {3000, 1}};
        int result = solution(time, gold, upgrade);
    }

    public static int solution(int time, int gold, int[][] upgrade) {
        int answer = 0; // 최대 이익

        // upgrade 단계별로 업그레이드 했을때 비용이 얼마남고, 시간이 얼마남는지 체크
        int[][] arr = new int[upgrade.length][2];
        arr[0][0] = 0;
        arr[0][1] = time;

        int remainTime = time;
        int currentMoney = 0;
        for (int i = 1; i < upgrade.length; i++) {
            int needMoney = upgrade[i][0] - currentMoney;

            // 캐야할 광석의 갯수
            int cnt = (int) Math.ceil( (double) needMoney / gold );
            currentMoney = (gold * cnt) - needMoney;
            remainTime -= cnt * upgrade[i - 1][1];

            if (remainTime < 0) {
                break;
            }
            arr[i][0] = currentMoney;
            arr[i][1] = remainTime;
        }

        for (int i = 0; i < arr.length; i++) {
            int money = arr[i][0];

            int totalMoney = money + (arr[i][1] / upgrade[i][1]) * gold;
            answer = Math.max(answer, totalMoney);
        }
        return answer;
    }
}
