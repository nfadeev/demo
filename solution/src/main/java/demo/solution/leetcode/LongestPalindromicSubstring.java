package demo.solution.leetcode;

public class LongestPalindromicSubstring {

    public String find(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;
        int length = s.length();
        int index = length / 2;
        int limit = length - 1;
        while (index < limit) {
            int foundLength = findMaxOddEven(s, index);
            if (foundLength > end - start) {
                start = index - (foundLength - 1) / 2;
                end = index + foundLength / 2 + 1;
                limit = length - (end - start) / 2;
            }
            index++;
        }
        index = length / 2 - 1;
        limit = (end - start) / 2;
        while (index >= limit) {
            int foundLength = findMaxOddEven(s, index);
            if (foundLength > end - start) {
                start = index - (foundLength - 1) / 2;
                end = index + foundLength / 2 + 1;
                limit = (end - start) / 2;
            }
            index--;
        }
        return s.substring(start, end);
    }
    
    private int findMaxOddEven(String s, int i) {
        int oddLength = findLength(s, i - 1, i + 1);
        int evenLength = findLength(s, i, i + 1);
        return oddLength > evenLength ? oddLength : evenLength;
    }

    private int findLength(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left - 1;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
