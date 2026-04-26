class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int freq = frequency.getOrDefault(nums[i], 0);
            frequency.put(nums[i], freq + 1);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }

        return result;
    }
}
