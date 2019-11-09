/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursion
//Check if left and right tree have same length(root = root.left, root = root.right)
//if length is same, then it is a complete tree
//If length is not the same, then recursive 
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftCount = countLeft(root);
        int rightCount = countRight(root);
        if(leftCount == rightCount){
            return (1 << leftCount) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
        
    }
    public int countLeft(TreeNode root){
        if(root == null){
            return 0;
        }
        int height = 1;
        while(root.left != null){
            root = root.left;
            height++;
        }
        return height;
    }
    public int countRight(TreeNode root){
        if(root == null){
            return 0;
        }
        int height = 1;
        while(root.right != null){
            root = root.right;
            height++;
        }
        return height;
    }
}