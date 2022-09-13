import java.util.HashMap;

public class Solution {

  public TreeNode createBinaryTree(String[] inputs) {
    TreeNode result = null, cur;
    HashMap<Integer, TreeNode> hash = new HashMap<>();
    int size = inputs.length;
    for (int idx = 0; idx < size; idx++) {
      int num = 0;
      String val = inputs[idx];
      if (!val.equals("null")) {
        num = Integer.parseInt(val);
      }
      if (idx == 0) {
        result = new TreeNode(num);
        hash.put(num, result);
      }
      if (hash.containsKey(num)) {
        cur = hash.get(num);
      } else {
        cur = new TreeNode(num);
        hash.put(num, cur);
      }
      if (2*idx+1 < size) {
        if (!inputs[2*idx+1].equals("null")) {
          int leftVal = Integer.parseInt(inputs[2*idx+1]);
          if (hash.containsKey(leftVal)) {
            cur.left = hash.get(leftVal);
          } else {
            cur.left = new TreeNode(leftVal);
            hash.put(leftVal, cur.left);
          }
        }
      }
      if (2*idx+2 < size) {
        if (!inputs[2*idx+2].equals("null")) {
          int rightVal = Integer.parseInt(inputs[2*idx+2]);
          if (hash.containsKey(rightVal)) {
            cur.right = hash.get(rightVal);
          } else {
            cur.right = new TreeNode(rightVal);
            hash.put(rightVal, cur.right);
          }
        }
      }
    }
    return result;
  }

  int preorderIdx;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIdx = 0;
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();
    for (int idx = 0; idx < inorder.length; idx++) {
      inorderIdxMap.put(inorder[idx], idx);
    }
    return arrayToTree(preorder, 0, preorder.length - 1, inorderIdxMap);
  }
  public TreeNode arrayToTree(int[] preorder, int left, int right, HashMap<Integer, Integer> inorderIdxMap) {
    if (left > right) {
      return null;
    }
    int rootValue = preorder[preorderIdx];
    preorderIdx++;
    TreeNode root = new TreeNode(rootValue);
    root.left = arrayToTree(preorder, left, inorderIdxMap.get(rootValue) - 1, inorderIdxMap);
    root.right = arrayToTree(preorder,inorderIdxMap.get(rootValue) + 1, right, inorderIdxMap);
    return root;
  }
  public boolean isSampleTree(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2 == null;
    }
    if (root2 != null ) {
      if (root1.val != root2.val) {
        return false;
      }
      return isSampleTree(root1.left, root2.left) && isSampleTree(root1.right, root2.right);
    }
    return false;
  }
}
