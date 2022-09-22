import java.util.Map.Entry;
class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int freqNumber = frequencies.getOrDefault(arr[i], 0);
            frequencies.put(arr[i], freqNumber + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> frequencies.get(b) - frequencies.get(a)
        );
        for (Entry<Integer, Integer> element : frequencies.entrySet()) {
            queue.add(element.getKey());
        }
        int minSetSize = 0;
        int currentLen = 0;
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext() && currentLen < (len / 2)) {
            int currentNum = queue.poll();
            currentLen += frequencies.get(currentNum);
            minSetSize++;
        }
        return minSetSize;
    }
}
