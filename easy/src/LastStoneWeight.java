import java.util.Arrays;

public class LastStoneWeight {
    public static void main(String[] args) {
        int [] stones = {2,7,4,1,8,1};

        System.out.println("Expected output : 1");
        System.out.println("Output: "+ Solution.lastStoneWeight(stones));


    }
}
class Solution {
    public static int lastStoneWeight(int[] stones) {

        if(stones.length == 1){return stones[0];}

        int n = stones.length -1;

        Arrays.sort(stones);


        while(stones[n-1] != 0){

            if(stones[n-1] == stones[n]){
                stones[n-1]= 0; stones[n] = 0;
            }else {
                stones[n] = stones[n] - stones[n-1];
                stones[n-1] = 0;

            }
            Arrays.sort(stones);

        }

        return stones[n];


    }
}