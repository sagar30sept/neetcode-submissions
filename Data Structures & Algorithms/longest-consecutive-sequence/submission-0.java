class Solution {
    public int longestConsecutive(int[] nums) {

        int longest = 1;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;

        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count ++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) { // to keep the counter as it is for any duplicate number in array
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
