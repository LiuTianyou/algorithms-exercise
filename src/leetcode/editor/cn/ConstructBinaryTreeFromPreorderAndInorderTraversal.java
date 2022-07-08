//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1656 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            return build(preList, inList);
        }

        private TreeNode build(List<Integer> prev, List<Integer> in) {
            if (prev.isEmpty()) {
                return null;
            }
            if (prev.size() == 1) {
                return new TreeNode(prev.get(0));
            }
            int rootVal = prev.get(0);
            TreeNode node = new TreeNode(rootVal);

            int mid = 0;
            //寻找左右子树
            for (int i = 0; i < in.size(); i++) {
                if (rootVal == in.get(i)) {
                    mid = i;
                    break;
                }
            }
            node.left = build(prev.subList(1, mid + 1), in.subList(0, mid));
            node.right = build(prev.subList(mid + 1, prev.size()), in.subList(mid + 1, in.size()));
            return node;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}


