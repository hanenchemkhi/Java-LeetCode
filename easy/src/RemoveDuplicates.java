public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = new int[nums.length]; // The expected answer with correct length

        int k = Solution.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]+", ");
            assert nums[i] == expectedNums[i];

        }
    }


    class Solution {
        public static int removeDuplicates(int[] nums) {
            int j = 0;

            for (int i = 1; i < nums.length; i++) {

                if (nums[j] == nums[i]) {
                    continue;

                } else {
                    j++;
                    nums[j] = nums[i];
                }

            }
            return j + 1;

        }
    }

}
