package DFSBFS;

public class DFSBFS1 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = 0;

        answer += dfs(numbers[0], 1, numbers, target);
        answer += dfs(-numbers[0], 1, numbers, target);

        System.out.println("answer = " + answer);

    }

    static int dfs(int prev, int depth, int[] numbers, int target) {
        if (depth >= numbers.length) {
            if (prev == target) {
                return 1;
            }
            return 0;
        }

        int cur1 = prev + numbers[depth];
        int cur2 = prev - numbers[depth];

        int ans = 0;
        ans += dfs(cur1, depth + 1, numbers, target);
        ans += dfs(cur2, depth + 1, numbers, target);

        return ans;
    }
}
