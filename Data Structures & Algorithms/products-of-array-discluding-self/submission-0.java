class Solution {
    public int[] productExceptSelf(int[] nums) {

        int prefix = 1;
        int postfix = 1;

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        //check notes for logic
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = nums[i] * prefix;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = nums[i] * postfix;
        }
        return result;
        
    }
}  
