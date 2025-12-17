public class ProfitAndLossTwiceTrans {
  static int maxProfOne(int[] prices, int idx) {
    int minSoFar = prices[idx];
    int res = 0;

    for (int i = idx + 1; i < prices.length; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);
      res = Math.max(res, prices[i] - minSoFar);
    }
    return res;
  }

  static int maxProfit(int[] prices) {
    int n = prices.length;
    int minSoFar = prices[0];
    int res = 0;

    for (int i = 1; i < n; i++) {
      if (prices[i] > minSoFar) {
        int curr = prices[i] - minSoFar + maxProfOne(prices, i);
        res = Math.max(res, curr);
      } else {
        minSoFar = Math.min(minSoFar, prices[i]);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] prices = { 10, 22, 5, 75, 65, 80 };
    System.out.println(maxProfit(prices));
  }

}
