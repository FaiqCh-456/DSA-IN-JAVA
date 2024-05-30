package Lab_final;

class TreeNode1 {
    int key;
    TreeNode1 left, right;
    int height;

    public TreeNode1(int item) {
        key = item;
        left = right = null;
        height = 1;
    }
}

class BST {
    private TreeNode1 root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void insert(int key) {
        root = insertRec(root, key, 0);
    }

    private TreeNode1 insertRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            size++;
            System.out.println("Inserted node  " + key + " at level " + level);
            return new TreeNode1(key);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key, level + 1);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key, level + 1);
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode1 node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(TreeNode1 node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalancedRec(node.left) && isBalancedRec(node.right);
    }

    public void preorderTraversal() {
        System.out.print("Preorder traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode1 node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        int[] elements = {7, 3, 9, 2, 5, 8, 10};
        for (int el : elements) {
            bst.insert(el);
        }
        System.out.println();

        System.out.println("Depth of the Tree: " + bst.getHeight());
        bst.preorderTraversal();
        System.out.println("Is the tree a BST? : " + bst.isBalanced());
        System.out.println();


    }
}
