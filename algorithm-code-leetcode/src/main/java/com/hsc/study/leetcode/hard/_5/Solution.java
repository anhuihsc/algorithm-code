package com.hsc.study.leetcode.hard._5;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符 删除一个字符 替换一个字符 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros" 输出: 3 解释: horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除 'r') rose -> ros (删除
 * 'e') 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution" 输出: 5 解释: intention -> inention (删除 't') inention -> enention (将 'i' 替换为
 * 'e') enention -> exention (将 'n' 替换为 'x') exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 定义 dp[i][j] 表示第一字符串前 i 个字符串 和 第二个字符前 j个字符串
 * 分析问题  word1[i]==word2[j]
 * dp[i][j]=dp[i-1][j-1]
 * 如果不相等就会有三种情况
 *   增加一个字符串
 *  dp[i][j]=dp[i][j-1]+1
 *   删除一个字符串
 * dp[i][j]=dp[i-1][j]+1
 *   替换
 *  dp[i][j]=dp[i-1][j-1]+1
 *
 *  dp[i] [j] = min(dp[i-1] [j-1]，dp[i] [j-1]，dp[[i-1] [j]]) + 1;
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[m ][n ];
    }
}
