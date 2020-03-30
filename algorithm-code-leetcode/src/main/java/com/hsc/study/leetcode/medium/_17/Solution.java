package com.hsc.study.leetcode.medium._17;

import com.hsc.study.leetcode.ListNode;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 *  代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,1],[0,0,0],[1,0,1]] 输出：2 解释： 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,0,0],[0,0,0],[0,0,0]] 输出：4 解释： 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100 grid[i][j] 不是 0 就是 1
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int maxDis=0;

        return maxDis;

    }

    private int dis(int x0, int y0, int x1, int y1) {
        return Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
