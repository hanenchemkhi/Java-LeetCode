public class MaxProfit {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    public static void main(String[] args){

        int[] prices={7,1,5,3,6,4};
        System.out.println(Solution.maxProfit(prices));
    }
    class Solution {
        public static int maxProfit(int[] prices) {

            int min= Integer.MAX_VALUE;
            int minIndex=0;

            for(int i= 0; i <prices.length; i++){
                if(prices[i]<min){
                    min=prices[i];
                    minIndex = i;
                }
            }

            int max= min;
            for(int i = minIndex+1; i<prices.length; i++){
                if(prices[i]> max){
                    max = prices[i];

                }
            }

            return max-min;

        }
    }

}
