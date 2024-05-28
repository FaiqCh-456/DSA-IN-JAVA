package BST;
//let a and b are 2 integers. Print numbers in a range of a and b in BST
public class RangePrinter {
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

    public RangePrinter() {
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

    public void printRange(int a, int b) {
        printRange(root, a, b);
    }

    private void printRange(TreeNode root, int a, int b) {
        if (root == null) {
            return;
        }
        // Traverse the left subtree if the current node's value is greater than a
        if (root.val > a) {
            printRange(root.left, a, b);
        }
        // Print the current node's value if it falls within the range [a, b]
        if (root.val >= a && root.val <= b) {
            System.out.print(root.val + " ");
        }
        // Traverse the right subtree if the current node's value is less than b
        if (root.val < b) {
            printRange(root.right, a, b);
        }
    }

    public static void main(String[] args) {
        RangePrinter rangePrinter = new RangePrinter();

        // Insert elements into the BST
        rangePrinter.insert(5);
        rangePrinter.insert(3);
        rangePrinter.insert(7);
        rangePrinter.insert(2);
        rangePrinter.insert(4);
        rangePrinter.insert(6);
        rangePrinter.insert(8);

        int a = 3;
        int b = 7;
        System.out.println("Numbers in the range [" + a + ", " + b + "] in the BST:");
        rangePrinter.printRange(a, b); // Output: 3 4 5 6 7
    }
}
