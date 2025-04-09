public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Get sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and take absolute values
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        int result = 0;

        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            int multiple = 1;

            // Double the divisor until it is just smaller than dividend
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            lDividend -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
