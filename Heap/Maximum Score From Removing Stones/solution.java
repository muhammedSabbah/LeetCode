class Solution {
    /*
    4 4 4
    
    3 3 4
    2 3 3
    2 2 2
    1 1 2
    1 0 1
    0 0 0
    */
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((element1, element2) -> element2 - element1);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        int maximumScore = 0;
        while(queue.size() > 1) {
            int firstBigOne = queue.poll();
            int secondBig = queue.poll();
            if (firstBigOne - 1 > 0) {
                queue.add(firstBigOne - 1);
            }
            if (secondBig - 1 > 0) {
                queue.add(secondBig - 1);
            }
            maximumScore++;
        }
        return maximumScore;
    }
}
