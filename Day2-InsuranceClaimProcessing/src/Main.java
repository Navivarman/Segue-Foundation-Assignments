import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        // ==========================================
        // TASK 1: Claim BST (Binary Search Tree)
        // ==========================================
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


        // ==========================================
        // TASK 2: Claim Hashing (Duplicate Check)
        // ==========================================
        System.out.println("\n===== TASK 2: HASHING =====");
        ClaimManager manager = new ClaimManager();

        System.out.println(manager.isDuplicate("POL123", "2026-11-10")); // false (first time)
        System.out.println(manager.isDuplicate("pol123", "2026-11-10")); // true (duplicate due to normalization)
        System.out.println(manager.isDuplicate("POL 123", "2026-11-11")); // false (different date)


        // ==========================================
        // TASK 3: Approval Graph (BFS Shortest Path & Cycle Detection)
        // ==========================================
        System.out.println("\n===== TASK 3: GRAPH =====");
        ApprovalGraph graph = new ApprovalGraph();

        graph.addEdge("Registration", "Assessment");
        graph.addEdge("Assessment", "Surveyor");
        graph.addEdge("Surveyor", "Settlement");

        System.out.println("Shortest path: " +
                graph.shortestPath("Registration", "Settlement"));

        System.out.println("Cycle exists: " + graph.hasCycle());

        // Add a backward edge to demonstrate cycle detection
        graph.addEdge("Settlement", "Assessment");

        System.out.println("Cycle after adding backward edge: " +
                graph.hasCycle());


        // ==========================================
        // TASK 4: Claim Analyzer (Sliding Window)
        // ==========================================
        System.out.println("\n===== TASK 4: SLIDING WINDOW =====");
        int[] dailyClaims = {
                80, 120, 150, 130, 90, 140, 160, 170, 110
        };

        System.out.println("Longest spike streak: " +
                ClaimAnalyzer.longestClaimSpike(dailyClaims));


        // ==========================================
        // TASK 5: Claim Merger (Two Pointers)
        // ==========================================
        System.out.println("\n===== TASK 5: TWO POINTERS =====");
        List<Integer> region1 = Arrays.asList(101, 103, 105, 109);
        List<Integer> region2 = Arrays.asList(102, 104, 106, 108);

        System.out.println("Merged claims: " +
                ClaimMerger.merge(region1, region2));
    }
}