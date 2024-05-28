package BST;

public class NodeCounter {
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

    public NodeCounter() {
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

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Count the current node and recursively count nodes in the left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        NodeCounter nodeCounter = new NodeCounter();

        nodeCounter.insert(5);
        nodeCounter.insert(3);
        nodeCounter.insert(7);
        nodeCounter.insert(2);
        nodeCounter.insert(4);
        nodeCounter.insert(6);
        nodeCounter.insert(8);

        int numberOfNodes = nodeCounter.countNodes();
        System.out.println("Number of nodes in the BST: " + numberOfNodes); // Output: 7
    }
}
