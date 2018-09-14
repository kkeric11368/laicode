//Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

//Assumptions
//The given sequence is not null
//There are no duplicate keys in the binary search tree

//Examples
//postorder traversal = {1, 4, 3, 11, 8, 5}
//the corresponding binary search tree is
//  
//          5
//        /    \
//      3        8
//    /   \        \
//  1      4        11

//How is the binary tree represented?
//We use the pre order traversal sequence with a special symbol "#" denoting the null node.

//For Example:
//The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:
//
//      1
//    /   \
//   2     3
//        /
//      4




// My solution
//
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  // BST的postOrder，最后一个点必然是root；
  // 这个点之前，所有比这个点的值小的点必然属于左子树；
  // 这个点之前，所有比这个点的值大的点必然属于右子树；
  // 对于左右子树而言，子树的root和左右子树判断条件不变
  public TreeNode reconstruct(int[] post) {
    if (post.length == 0) {
      return null;
    }
    // index表示当前处理到哪个点
    int[] index = new int[] {post.length - 1};
    return reconstruct(post, index, Integer.MIN_VALUE);
  }
  
  // min表示当前所有点中的最小值
  private TreeNode reconstruct(int[] post, int[] index, int min) {
    if (index[0] < 0 || post[index[0]] < min) {
      return null;
    }
    
    TreeNode root = new TreeNode(post[index[0]--]);
    root.right = reconstruct(post, index, root.key);
    root.left = reconstruct(post, index, min);
    return root;
  }
}




// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.8odnjibk1mx1



