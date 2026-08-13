class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        
        if (count.size() == k) {
            int[] res = new int[k];
            int index = 0;
            for (int i : count.keySet()) {
                res[index ++] = i;
            }
        }

        Queue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );

        for (int i : count.keySet()) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {   
            res[i] = minHeap.poll();
        }
        return res;
    }
}
