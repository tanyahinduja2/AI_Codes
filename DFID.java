import java.util.*;

public class DFID {
    public static void main(String []args) {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("4", "5"));
        graph.put("3", Arrays.asList("6", "7"));
        graph.put("4", new ArrayList<>());
        graph.put("5", new ArrayList<>());
        graph.put("6", new ArrayList<>());
        graph.put("7", new ArrayList<>());

        String startNode = "1";
        String goalNode = "9";
        int maxDepthLimit = maxDepth(graph, startNode, goalNode);
        System.out.println("Max depth limit set to " + maxDepthLimit);
        int depth = 0;

        while (depth <= maxDepthLimit) {
            System.out.println("Iteration: " + (depth + 1));
            System.out.println("Depth Level: " + depth);
            boolean found = iddfs(graph, startNode, goalNode, depth, new HashSet<>(), new ArrayList<>());

            if (found) {
                System.out.println("Goal node '" + goalNode + "' found starting from node '" + startNode + "' using IDDFS at depth " + depth + ".");
                break;
            } else {
                System.out.println("Goal node '" + goalNode + "' not found at depth " + depth + ".");
            }

            depth++;
            System.out.println();
        }

        if (depth > maxDepthLimit) {
            System.out.println("Search reached maximum depth " + maxDepthLimit + " without finding the goal node '" + goalNode + "'.");
        }
    }
    public static int maxDepth(Map<String, List<String>> graph, String startNode, String goalNode) {
        int maxDepth = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()) {
            String node = queue.poll();
            visited.add(node);
            maxDepth = Math.max(maxDepth, visited.size());

            if(node.equals(goalNode)) {
                break;
            }

            for(String neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        return maxDepth;
    }

    public static boolean iddfs(Map<String, List<String>> graph, String node, String goal, int depth, Set<String> visited, List<String> path) {
        path.add(node);
        visited.add(node);
        System.out.println("Visiting node : " + node);

        if(node.equals(goal)) {
            return true;
        }

        if(depth > 0) {
            for(String neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbour)) {
                    if(iddfs(graph, neighbour, goal, depth - 1, visited, path)) {
                        return true;
                    }
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
