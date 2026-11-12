class ClaimAnalyzer {

    static int longestClaimSpike(int[] dailyClaims) {
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < dailyClaims.length; right++) {
            while (left <= right && dailyClaims[right] <= 100) {
                left = right + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("\n===== TASK 4: SLIDING WINDOW =====");

        int[] dailyClaims = {
                80, 120, 150, 130, 90, 140, 160, 170, 110
        };

        System.out.println("Longest spike streak: " +
                ClaimAnalyzer.longestClaimSpike(dailyClaims));
    }
}
