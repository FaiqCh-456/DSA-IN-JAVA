package BST;

public class BinarySearchTree {
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

    public BinarySearchTree() {
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

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    private TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            // Node to delete found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node to delete has two children
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    public void inorderTraversal() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println("Inorder traversal before deletion:");
        bst.inorderTraversal(); // Output: 2 3 4 5 6 7 8

        bst.delete(5);

        System.out.println("Inorder traversal after deletion:");
        bst.inorderTraversal(); // Output: 2 3 4 6 7 8
    }
}

