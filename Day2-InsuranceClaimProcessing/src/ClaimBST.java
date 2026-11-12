class Node {
    int claimId;
    Node left, right;

    Node(int claimId) {
        this.claimId = claimId;
    }
}

class ClaimBST {
    Node root;
    
    void insert(int claimId) {
        root = insertNode(root, claimId);
    }

    private Node insertNode(Node node, int claimId) {
        if (node == null) {
            return new Node(claimId);
        }

        if (claimId < node.claimId) {
            node.left = insertNode(node.left, claimId);
        } else if (claimId > node.claimId) {
            node.right = insertNode(node.right, claimId);
        }

        return node;
    }

    boolean search(int claimId) {
        Node current = root;

        while (current != null) {
            if (current.claimId == claimId) {
                return true;
            }

            if (claimId < current.claimId) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Inorder: Left -> Root -> Right
    void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.claimId + " ");
        inorder(node.right);
    }

    // Preorder: Root -> Left -> Right
    void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.claimId + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder: Left -> Right -> Root
    void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.claimId + " ");
    }

    public static void main(String[] args) {
        System.out.println("===== TASK 1: BST =====");

        ClaimBST bst = new ClaimBST();

        int[] claimIds = {105, 102, 108, 101, 104, 107, 110};

        for (int id : claimIds) {
            bst.insert(id);
        }

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);

        System.out.println("\nSearch 104: " + bst.search(104));
        System.out.println("Search 999: " + bst.search(999));
    }
}
