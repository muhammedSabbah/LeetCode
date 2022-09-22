import java.util.Map.Entry;
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencies = constructFrequencies(s);
        PriorityQueue<Character> queue = constructMaxPriorityFrequenxies(frequencies);
        StringBuilder result = frequencySort(frequencies, queue);
        return result.toString();
    }
    
    private Map<Character, Integer> constructFrequencies(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            int currentFreq = frequencies.getOrDefault(currentChar, 0);
            frequencies.put(currentChar, currentFreq + 1);
        }
        return frequencies;
    }
    
    private PriorityQueue<Character> constructMaxPriorityFrequenxies(Map<Character, Integer> frequencies) {
        PriorityQueue<Character> queue = new PriorityQueue<>(
            (a, b) -> frequencies.get(b) - frequencies.get(a)
        );
        for(Entry<Character, Integer> entry : frequencies.entrySet()) {
            queue.offer(entry.getKey());
        }
        return queue;
    }
    
    private StringBuilder frequencySort(Map<Character, Integer> frequencies, PriorityQueue<Character> queue) {
        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = queue.iterator();
        while(iterator.hasNext()) {
            Character currentChar = queue.poll();
            for (int i = 0; i < frequencies.get(currentChar); i++) {
                result.append(currentChar);
            }
        }
        return result;
    }
}
