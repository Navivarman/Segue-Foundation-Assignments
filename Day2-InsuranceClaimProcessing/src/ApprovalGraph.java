import java.util.*;

class ApprovalGraph {
    private Map<String, List<String>> graph = new HashMap<>();

    void addStage(String stage) {
        graph.putIfAbsent(stage, new ArrayList<>());
    }

    void addEdge(String from, String to) {
        addStage(from);
        addStage(to);

        graph.get(from).add(to);
    }

    // BFS - Find shortest path
    List<String> shortestPath(String start, String end) {
        List<String> path = new ArrayList<>();

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return path;
        }

        Queue<String> queue = new ArrayDeque<>();
        Map<String, String> parent = new HashMap<>();

        queue.offer(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            for (String neighbor : graph.get(current)) {
                if (!parent.containsKey(neighbor)) {
                    parent.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        if (!parent.containsKey(end)) {
            return path;
        }

        // Reconstruct the path
        String current = end;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    // DFS - Detect a directed cycle
    boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();

        for (String stage : graph.keySet()) {
            if (detectCycle(stage, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean detectCycle(
            String node,
            Set<String> visited,
            Set<String> recursionStack) {

        if (recursionStack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recursionStack.add(node);

        for (String neighbor : graph.get(node)) {
            if (detectCycle(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
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


    }

}

