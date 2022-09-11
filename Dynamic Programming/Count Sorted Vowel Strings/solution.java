class Solution {
    
    int[][] memo;
    public int countVowelStrings(int currentIndx, int len) {
        if(currentIndx == 5) {
            return 0;
        }
        
        if(len == 0) {
            return 1;
        }
        if(memo[currentIndx][len] != 0)
            return memo[currentIndx][len];
        int next = countVowelStrings(currentIndx + 1, len);
        int current = countVowelStrings(currentIndx, len - 1);
        return memo[currentIndx][len] = next + current;
    }
    public int countVowelStrings(int n) {
        memo = new int[5][n + 1];
        return countVowelStrings(0, n);
    }
}
