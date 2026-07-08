class Solution {

    public String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();

        for (String s : strs) {
            res.append(s.length()).append("#").append(s); //encoded string "4#neet4#code"
        }
        return res.toString(); //stringbuilder to string

    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j)); //We have found the integer which is length of string before #
            i = j + 1; //As j is currently on #, we move by 1 to be on first character of actual 1st string
            j = i + length; //j is moved to last character of actual 1st string
            res.add(str.substring(i, j)); //add the actual string to list<string>
            i = j; //move i to end of 1st string so that next loop starts for 2nd string
        }
        return res;
    }
}
