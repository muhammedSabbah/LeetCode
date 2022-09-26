class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stonesWeight = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < stones.length; i++) {
            stonesWeight.add(stones[i]);
        }
        while(stonesWeight.size() > 1) {
            int firstStone = stonesWeight.poll();
            int secondStone = stonesWeight.poll();
            if (firstStone != secondStone) {
                stonesWeight.add(firstStone - secondStone);
            }
        }
        return stonesWeight.size() == 1 ? stonesWeight.poll() : 0;
    }
}
