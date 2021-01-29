package com.claus.binarySearch;

public class binarySearch_demo {

    public static int bsearch_basic(int[] nums, int target_value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] == target_value) {
                return mid;
            } else if (nums[mid] < target_value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    查找第一个等于给定值的元素
    如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
    如果 mid 不等于 0，但 nums[mid]的前一个元素 nums[mid-1]不等于 value，那也说明 nums[mid]就是我们要找的第一个值等于给定值的元素
     */
    public static int bsearch_firsttarget(int[] nums, int target_value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > target_value) {
                high = mid - 1;
            } else if (nums[mid] < target_value) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid-1] != target_value) {
                    // mid是第一个或者mid前一个元素不是目标值
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /*
    查找最后一个值等于给定值的元素
    如果 nums[mid]这个元素已经是数组中的最后一个元素了，那它肯定是我们要找的；
    如果 nums[mid]的后一个元素 a[mid+1]不等于 value，那也说明 nums[mid]就是我们要找的最后一个值等于给定值的元素
     */
    public static int bsearch_lasttarget(int[] nums, int target_value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] > target_value) {
                high = mid - 1;
            } else if (nums[mid] < target_value) {
                low = mid + 1;
            } else {
                if ((mid == nums.length-1) || nums[mid+1] != target_value) {
                    // 最后一个元素，或者后一个值不等于目标
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /*
    查找第一个大于等于给定值的元素
    对于 nums[mid]大于等于给定值 value 的情况
    我们要先看下这个 nums[mid]是不是我们要找的第一个值大于等于给定值的元素
    如果 nums[mid]前面已经没有元素，或者前面一个元素小于要查找的值 value
    那 nums[mid]就是我们要找的元素
     */
    public static int bsearch_firstLargerThan(int[] nums, int target_value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] >= target_value) {
                if ((mid==0) || (nums[mid-1] < target_value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /*
    查找最后一个小于等于给定值的元素
    对于 nums[mid]小于等于给定值 value 的情况
    我们要先看下这个 nums[mid]是不是我们要找的第一个值小于等于给定值的元素。
    如果 nums[mid]是最后一个元素，或者后面一个元素大于要查找的值 value
    那 nums[mid]就是我们要找的元素
     */
    public static int bsearch_lastSmallThan(int[] nums, int target_value) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (nums[mid] <= target_value) {
                if ((mid==nums.length-1) || (nums[mid+1]>target_value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8,11,19,19,33,45,55,67,98};
        int idx = bsearch_lastSmallThan(nums, 19);
    }
}
