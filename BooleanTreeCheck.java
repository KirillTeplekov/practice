/*
Алгоритм:
Рекурсивно проверяем , что все узлы в левом поддереве меньше текущего узла, а все узлы в правом поддереве — больше
*/
public class BooleanTreeCheck {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBoolean(TreeNode root, int low, int high) {
        if (root == null) return true;
        if (root.value < low || root.value > high) return false;
        return isBoolean(root.left, low, root.value) && isBoolean(root.right, root.value, high);
    }
}
