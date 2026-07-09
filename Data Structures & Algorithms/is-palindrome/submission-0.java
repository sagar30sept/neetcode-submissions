class Solution {
    public boolean isPalindrome(String s) {
        return checkPalindrome(s, 0, s.length() -1);       
    }

    private boolean checkPalindrome(String s, int left, int right) {

        //Skipping any other characters or space except letter and digit
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left ++;
        }

        //Skipping any other characters or space except letter and digit
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right --;
        }

        //base Case
        if (left >= right) return true;

        //Condition check
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

        //Recursive call
        return checkPalindrome(s, left + 1, right - 1);

    }
}
