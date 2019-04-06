package info.liuxiao.problems;

/**
 * @author seanlxliu
 * @since 2019/4/6
 */
public class Solution {

  /**
   * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
   *
   * 示例 1：
   *
   * 输入: "babad"
   * 输出: "bab"
   * 注意: "aba" 也是一个有效答案。
   *
   * 示例 2：
   *
   * 输入: "cbbd"
   * 输出: "bb"
   *
   * 判断回文：增加一个字母后，第一个是否和最后一个相等。例如：“bab” 是回文，那么很明显，“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。
   *
   * 回文中心可以为字母，也可以为两个字母之间。例如 “abba” 的中心在两个 ‘b’ 之间
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if (s == null || "".equals(s)) {
      return "";
    }
    int first = 0;
    int last = 0;

    for (int i = 0; i < s.length(); i++) {

        int len1 = getLenthByCenter(s, i, i); // 从字母开始
        int len2 = getLenthByCenter(s, i, i+1); // 从字母之间开始
        int len = Math.max(len1, len2);

        if (len > last - first) {
          first = i - (len - 1) / 2;
          last = i + len / 2;
        }
    }

    return s.substring(first, last+1);

  }

  private int getLenthByCenter(String s, int first, int last) {

    int L = first, R = last;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }

    return R - L - 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.longestPalindrome("babad"));
    System.out.println(solution.longestPalindrome("cbbd"));
    System.out.println(solution.longestPalindrome("abcda"));
  }
}
