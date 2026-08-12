class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if (mp.containsKey(reminder)) {
                return new int[]{mp.get(reminder), i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
    }
}
