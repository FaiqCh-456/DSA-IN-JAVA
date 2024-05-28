package BST;

public class TreeHeightFinder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public TreeHeightFinder() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        // The height of the tree is the maximum of the heights of the left and right subtrees, plus 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeHeightFinder tree = new TreeHeightFinder();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        int height = tree.getHeight();
        System.out.println("Height of the tree: " + height); // Output: 3
    }
}

