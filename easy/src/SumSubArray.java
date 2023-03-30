public class SumSubArray {

    public static void main (String[] args){
        int[] array = {3,3,0,5,-2,0};
        int k = 3;
        System.out.println("All subarrays with the given sum ="+ k+" :"+ Solution1.sumSubArray(array,k));

    }
    class  Solution1 {
        public static int  sumSubArray(int[] array, int k) {

            int count = 0;
            int sum =0;
            for(int i = 0; i<array.length; i++){
                sum=0;
                for(int j=i; j<array.length; j++){
                   sum+=array[j];
                   if(sum == k){count++;}
                }
            }

            return count;

        }
    }

}
