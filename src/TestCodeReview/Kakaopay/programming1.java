package TestCodeReview.Kakaopay;

public class programming1 {
    public static void main(String[] args) {
        int money = 12345678;
        int minratio = 10;
        int maxratio = 20;
        int ranksize = 250000;
        int threshold = 10000000;
        int months = 4;
        int result = solution(money, minratio, maxratio, ranksize, threshold, months);
        System.out.println(result);
    }

    private static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {

        for (int i = 0; i < months; i++) {

            int saveMoney = (money / 100) * 100;

            if (saveMoney < threshold) {
                continue;
            }

            int ratio = minratio;
            for (int j = 0; j < maxratio - minratio; j++) {
                int minrange = threshold + ranksize * j;
                int maxrange = threshold + ranksize * (j + 1) - 1;
                if (minrange <= saveMoney && saveMoney < maxrange) {
                    ratio += j;
                    break;
                }
            }

            if (saveMoney >= threshold + ranksize * (maxratio - minratio)) {
                ratio = maxratio;
            }

            money = money - (saveMoney / 100 * ratio);


        }
        return money;
    }
}
