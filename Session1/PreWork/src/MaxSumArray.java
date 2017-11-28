import java.util.List;

public class MaxSumArray {

    public int maxSubArray(final List<Integer> a) {
        int n = a.size();
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = a.get(0);
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = a.get(i) + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
