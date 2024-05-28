package BST;

public class NodeLevelFinder {
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

    public NodeLevelFinder() {
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

    public int findLevel(int target) {
        return findLevel(root, target, 1); // Start at level 1
    }

    private int findLevel(TreeNode root, int target, int level) {
        if (root == null) {
            return -1; // Target node not found
        }

        if (root.val == target) {
            return level; // Found the target node
        }

        // Recursively search in the left and right subtrees
        int leftLevel = findLevel(root.left, target, level + 1);
        int rightLevel = findLevel(root.right, target, level + 1);

        // Return the maximum of left and right subtree levels
        return Math.max(leftLevel, rightLevel);
    }

    public static void main(String[] args) {
        NodeLevelFinder finder = new NodeLevelFinder();

        // Insert elements into the BST
        finder.insert(5);
        finder.insert(3);
        finder.insert(7);
        finder.insert(2);
        finder.insert(4);
        finder.insert(6);
        finder.insert(8);

        int target = 4;
        int level = finder.findLevel(target);
        if (level != -1) {
            System.out.println("Level of node " + target + " in the BST: " + level); // Output: Level of node 4 in the BST: 3
        } else {
            System.out.println("Node " + target + " not found in the BST.");
        }
    }
}

