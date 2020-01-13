package two_pointer;

public class leetcode_27_Remove_Element {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {0,0,0,1,2,2,3};
        int val = 0;
        System.out.println(removeElement(nums, val));
    }
}
