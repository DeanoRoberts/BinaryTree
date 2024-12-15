import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 *
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     *
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size() - 1));
    }

    /**
     * A function that searches for a value in the tree
     *
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return searchHelper(val, this.getRoot());

    }

    public boolean searchHelper(int val, BSTNode root) {
        // Base case
        if (root == null) {
            return true;
        }
        // Check if val is found
        if (val == root.getVal()) {
            return true;
        }
        // Checks left root
        if (val < root.getVal()) {
            return searchHelper(val, root.getLeft());
        }
        // Check right root
        if (val > root.getVal()) {
            return searchHelper(val, root.getRight());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> treeNodes = new ArrayList<BSTNode>();
        getInorderHelper(this.getRoot(), treeNodes);
        return treeNodes;

    }

    public void getInorderHelper(BSTNode root, ArrayList<BSTNode> treeNodes) {
        if (root == null) {
            return;
        }
        // calls sequences of inorder (left, root, right)
        getInorderHelper(root.getLeft(), treeNodes);
        treeNodes.add(root);
        getInorderHelper(root.getRight(), treeNodes);

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> treeNodes = new ArrayList<BSTNode>();
        getPreorderHelper(this.getRoot(), treeNodes);
        return treeNodes;
    }

    public void getPreorderHelper(BSTNode root, ArrayList<BSTNode> treeNodes) {
        if (root == null) {
            return;
        }

        // Calls sequences of preorder (root, left, right)
        treeNodes.add(root);
        getPreorderHelper(root.getLeft(), treeNodes);
        getPreorderHelper(root.getRight(), treeNodes);

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> treeNodes = new ArrayList<BSTNode>();
        getPostorderHelper(this.getRoot(), treeNodes);
        return treeNodes;
    }

    public void getPostorderHelper(BSTNode root, ArrayList<BSTNode> treeNodes) {
        // Base case,
        if (root == null) {
            return;
        }
        // Calls sequences of postorder (left, right, root)
        getPostorderHelper(root.getLeft(), treeNodes);
        getPostorderHelper(root.getRight(), treeNodes);
        treeNodes.add(root);


    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     *
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(this.root, val);
    }

    public void insertHelper(BSTNode root, int val) {
        // Base case if this node has no right or left child
        if (root.getLeft() == null && root.getRight() == null) {
            // If value is less then node create a left child
            if (val < root.getVal()) {
                root.setLeft(new BSTNode(val));
            }
            // If value is greater than node, create right child
            if (val > root.getVal()) {
                root.setRight(new BSTNode(val));
            }

            return;
        }

        // Goes left if value is less than node
        if (val < root.getVal()) {
            insertHelper(root.getLeft(), val);
        }
        // Goes right if value is greater tha node
        if (val > root.getVal()) {
            insertHelper(root.getRight(), val);
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     *
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        tree.getInorder();
        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
