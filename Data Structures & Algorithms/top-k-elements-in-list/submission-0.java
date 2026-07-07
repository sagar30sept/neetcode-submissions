class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        //Create a frequency map of (number, its frequency)
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // If k equals the number of distinct elements, just return all of them
        if (k == count.size()) {
            int[] res = new int[k];
            int index = 0;
            for (int key : count.keySet()) {
                res[index ++] = key;
            }
        }

        //Min heap ordered by frequency. The heap stores the numbers themselves (not their counts), but the comparator looks up count.get(x) to order them. So this is a min-heap where the element with the smallest frequency sits at the top (peek/poll position).
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );

        //Look into the keys of count frequency map and add it to heap up till size k.
        for (int i : count.keySet()) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        //Collect it in array to return. size should be of k as only k frquent elements returning
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = heap.poll();
        }
        return res;
        
    }
}
