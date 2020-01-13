package two_pointer;

public class leetcode_26_Remove_Duplicates_from_Sorted_Array {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left+1] = nums[right];
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
