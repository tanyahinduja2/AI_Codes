import java.util.*;

public class BFS {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("4", "5"));
        graph.put("3", Arrays.asList("6", "7"));
        graph.put("4", new ArrayList<>());
        graph.put("5", new ArrayList<>());
        graph.put("6", new ArrayList<>());
        graph.put("7", new ArrayList<>());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the goal node : ");
        String goalNode = sc.next();
        String startNode = "1";
        System.out.println("Breadth-First Search : ");
        bfs(graph, startNode, goalNode);
        sc.close();
    }

    public static void bfs(Map<String, List<String>> graph, String startNode, String goalNode) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");
            visited.add(node);

            if (node.equals(goalNode)) {
                return;
            }

            for (String neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbour) && !queue.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }

        }
    }
}
