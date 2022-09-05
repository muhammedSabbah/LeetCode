class Solution {
    
    static int memo[][];
    public int longestCommonSubsequence(String text1, String text2, int indx1, int indx2) {
        if (indx1 == text1.length() || indx2 == text2.length()) {
            return 0;
        }
        if(memo[indx1][indx2] != 0) {
            return memo[indx1][indx2];
        }
        if (text1.charAt(indx1) == text2.charAt(indx2)) {
            return 1 + longestCommonSubsequence(text1, text2, indx1 + 1, indx2 + 1);
        }
        
        int choice1 = longestCommonSubsequence(text1, text2, indx1 + 1, indx2);
        int choice2 = longestCommonSubsequence(text1, text2, indx1, indx2 + 1);
        return memo[indx1][indx2] = Math.max(choice1, choice2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2, 0, 0);
    }
}
