class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (res.containsValue(nums[i])) {
                return true;
            }
            res.put(i, nums[i]);
        }
        return false;
    }
}