class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (Character c : s.toCharArray()) {
                count[c - 'a']++; //count of characters will be same for anagrams
            }
            String key = Arrays.toString(count); //"[1,0,0,....,1,....,0]"
            res.putIfAbsent(key, new ArrayList<>()); // key not present → res = {key: []}, key already exists → does nothing
            res.get(key).add(s); // res = {key: ["eat", "tea"]}, above line is important so that nullpointer does not come for a new key.
        }
        return new ArrayList<>(res.values()); //only values consist of ["eat", "tea"]
        
    }
}
