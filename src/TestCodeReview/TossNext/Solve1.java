package TestCodeReview.TossNext;

public class Solve1 {
    public static void main(String[] args) {
        long orderAmount = 120;
        long taxFreeAmount = 0;
        long serviceFee = 20;
        long result = solution(orderAmount, taxFreeAmount, serviceFee);
        System.out.println("result = " + result);
    }

    public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        // (비과세금액 + 봉사료 <= 주문금액)
        // 주문금액 + 봉사료 = 공급대가 ->   공급대가 - 비과세금액 = 과세금액 + 부가가치세 + 봉사료

        long freeAmount = 0;  // 과세금액

        long temp = orderAmount + serviceFee - taxFreeAmount;
        if (temp == 1) { // 공급대가 - 비과세금액 이 1인경우
            return 0;
        }
        // freeAmount + (long) Math.ceil(freeAmount / 10) + serviceFee = temp
        temp = temp - serviceFee;

        long start = 0;
        long end = 10000000;
        while (start <= end) {
            long mid = (start + end) / 2;

//            double extraAmount = Math.ceil((double) mid / 10);  // 부가가치세
            long result = mid + (long) Math.ceil((double) mid / 10);
            if (result == temp){
                freeAmount = mid;
                break;
            } else if (result < temp) {
                start = mid + 1;
            } else if (result > temp) {
                end = mid - 1;
            }
        }
        if (freeAmount == 0) freeAmount = start;
        return (long) Math.ceil((double) freeAmount /10);
    }
}
