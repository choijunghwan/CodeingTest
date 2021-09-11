package TestCodeReview.Kakao;

public class Solve2 {

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        int result = solution(n, k);
    }

    static final int  MAX_VALUE = 1000000;
    static boolean[] isNotPrime;

    public static int solution(int n, int k) {
        getIsNotPrime();

        String convertDigitK = "";
        while (n > 0) {
            int num = n % k;
            convertDigitK = Integer.toString(num) + convertDigitK;
            n /= k;
        }
        System.out.println(convertDigitK);


        int answer = 0;
        for (int i = 0; i < convertDigitK.length(); i++) {
            if (convertDigitK.charAt(i) != '0') {
                for (int j = i+1; j <= convertDigitK.length(); j++) {
                    if (j == convertDigitK.length() || convertDigitK.charAt(j) == '0') {
                        String prime = convertDigitK.substring(i,j);
                        answer += checkPrime(prime);
                        i = j;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    private static void getIsNotPrime() {
        isNotPrime = new boolean[MAX_VALUE];
        isNotPrime[1] = true;
        for (int i = 2; i < Math.sqrt(MAX_VALUE); i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i*i; j < MAX_VALUE; j += i) {
                isNotPrime[j] = true;
            }
        }
    }


    private static int checkPrime(String primeDigit) {
        long prime = Long.parseLong(primeDigit);

        if (prime <= MAX_VALUE) {
            return isNotPrime[(int) prime] ? 0 : 1;
        }

        for (long i = 2L; i < Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
