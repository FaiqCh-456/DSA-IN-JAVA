package BST;

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
            System.out.println("Inserted key " + key + " at level " + level);
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

    public void delete(int key) {
        root = deleteRec(root, key, 0);
    }

    private TreeNode1 deleteRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteRec(node.left, key, level + 1);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key, level + 1);
        } else {
            System.out.println("Deleted key " + key + " at level " + level);
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }

            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key, level + 1);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    private int minValue(TreeNode1 node) {
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    private int maxValue(TreeNode1 node) {
        int maxv = node.key;
        while (node.right != null) {
            maxv = node.right.key;
            node = node.right;
        }
        return maxv;
    }

    public boolean search(int key) {
        return searchRec(root, key, 0);
    }

    private boolean searchRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            System.out.println("Key " + key + " not found at level " + level);
            return false;
        }

        if (node.key == key) {
            System.out.println("Key " + key + " found at level " + level);
            return true;
        }

        return key < node.key ? searchRec(node.left, key, level + 1) : searchRec(node.right, key, level + 1);
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

    public int getSize() {
        return size;
    }

    public int getMinValue() {
        return root == null ? Integer.MIN_VALUE : minValue(root);
    }

    public int getMaxValue() {
        return root == null ? Integer.MAX_VALUE : maxValue(root);
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

    public static void main(String[] args) {
        BST bst = new BST();

        int[] elements = {15, 10, 20, 8, 12, 16, 25};
        for (int el : elements) {
            bst.insert(el);
        }

        System.out.println("Size: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Minimum value: " + bst.getMinValue());
        System.out.println("Maximum value: " + bst.getMaxValue());
        System.out.println("Is balanced: " + bst.isBalanced());
        System.out.println("");

        bst.search(10);
        bst.search(100);

        bst.delete(20);
        System.out.println("Delete 20:");
        System.out.println("Size: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Minimum value: " + bst.getMinValue());
        System.out.println("Maximum value: " + bst.getMaxValue());
        System.out.println("Is balanced: " + bst.isBalanced());
        bst.search(20);
        System.out.println("");

        bst.delete(15);
        System.out.println("Delete 15:");
        System.out.println("Size: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Minimum value: " + bst.getMinValue());
        System.out.println("Maximum value: " + bst.getMaxValue());
        System.out.println("Is balanced: " + bst.isBalanced());
        bst.search(15);
        System.out.println("");

        bst.delete(8);
        System.out.println("Delete 8:");
        System.out.println("Size: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Minimum value: " + bst.getMinValue());
        System.out.println("Maximum value: " + bst.getMaxValue());
        System.out.println("Is balanced: " + bst.isBalanced());
        bst.search(8);
        System.out.println("");
    }


}
