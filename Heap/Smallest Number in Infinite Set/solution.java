class SmallestInfiniteSet {
    int MAX_LEN = 1001;
    int[] element;
    int last = 999;
    boolean[] contains;
    
    public SmallestInfiniteSet() {
        element = new int[MAX_LEN];
        contains = new boolean[MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++) {
            element[i] = i + 1;
            contains[i] = true;
        }
    }
    
    public int popSmallest() {
        int smallest = element[0];
        element[0] = element[last];
        last--;
        heapifyDown(0);
        contains[smallest] = false;
        return smallest;
    }
    
    private void heapifyDown(int position) {
        int left = (position * 2) + 1;
        int right = (position * 2) + 2;
        int smallest = position;
        if (left <= last && element[left] < element[smallest]) {
            smallest = left;
        }
        if (right <= last && element[right] < element[smallest]) {
            smallest = right;
        }
        if (smallest != position) {
            swap (smallest, position);
            heapifyDown(smallest);
        }
    }
    
    public void addBack(int num) {
        if (contains[num]) {
            return;
        }
        last++;
        element[last] = num;
        contains[num] = true;
        heapifyUp(last);
    }
    
    private void heapifyUp(int position) {
        int parent = (position - 1) / 2;
        if (parent >= 0 && parent <= last) {
            if (element[position] < element[parent]) {
                swap(position, parent);
                heapifyUp(parent);
            }
        }
    }
    
    private void swap(int first, int second) {
        int tmp = element[first];
        element[first] = element[second];
        element[second] = tmp;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
