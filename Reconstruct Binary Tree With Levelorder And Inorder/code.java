//Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

//Assumptions
//The given sequences are not null and they have the same length
//There are no duplicate keys in the binary tree

//Examples
//levelorder traversal = {5, 3, 8, 1, 4, 11}
//inorder traversal = {1, 3, 4, 5, 8, 11}
//the corresponding binary tree is
//  
//          5
//        /    \
//      3        8
//    /   \        \
//  1      4        11

//How is the binary tree represented?
//We use  level order traversal sequence with a special symbol "#" denoting the null node.

//For Example:
//The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    if (inOrder.length == 0) {
      return null;
    }
    
    Map<Integer, Integer> idxMap = new HashMap<>();
    List<Integer> level = new LinkedList<>();
    for (int i = 0; i < inOrder.length; ai++) {
      idxMap.put(inOrder[i], i);
      level.add(levelOrder[i]);
    }    
    return reconstruct(level, idxMap);
  }
  
  private TreeNode reconstruct(List<Integer> level, Map<Integer, Integer> idxMap) {
    if (level.size() == 0) {
      return null;
    }
    List<Integer> left = new LinkedList<>();
    List<Integer> right = new LinkedList<>();
    TreeNode root = new TreeNode(level.remove(0));
    for (int num : level) {
      if (idxMap.get(num) < idxMap.get(root.key)) {
        left.add(num);
      }
      else {
        right.add(num);
      }
    }
    root.left = reconstruct(left, idxMap);
    root.right = reconstruct(right, idxMap); 
    return root;
  }
}





// Professional solution
//
https://docs.google.com/document/d/1FqVLq6Pu6FMr0cObsjUskr7MNLVZfCiTKOrbrTaB0ko/edit#heading=h.kfkkmrqop71p



