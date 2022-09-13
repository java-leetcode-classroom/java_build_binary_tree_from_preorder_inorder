import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void buildTreeExample1() {
    assertTrue(
        sol.isSampleTree(sol.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}),
            sol.createBinaryTree(new String[]{"3", "9", "20", "null", "null", "15", "7"}))
    );
  }
  @Test
  void buildTreeExample2() {
    assertTrue(
        sol.isSampleTree(sol.buildTree(new int[]{-1}, new int[]{-1}),
            sol.createBinaryTree(new String[]{"-1"}))
    );
  }
}