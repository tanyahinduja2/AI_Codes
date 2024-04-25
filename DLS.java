import java.util.*;

public class DLS {
    static HashMap<String, List<Map<String, Integer>>> graph = new HashMap<>();
    public static void main(String []args) {
        graph.put("1", Arrays.asList(Map.of("2", 1), Map.of("3", 2)));
        graph.put("2", Arrays.asList(Map.of("4", 3), Map.of("5", 4)));
        graph.put("3", Arrays.asList(Map.of("6", 5), Map.of("7", 6)));
        graph.put("4", new ArrayList<>());
        graph.put("5", new ArrayList<>());
        graph.put("6", new ArrayList<>());
        graph.put("7", new ArrayList<>());
        String startNode = "1";
        String goalNode = "7";
        int maxDepth = 1;
        List<String> result = dls(startNode, goalNode, maxDepth);
        if(!result.isEmpty()) {
            System.out.println("Goal node '" + goalNode + "' was found!");
            System.out.println("Path : " + String.join(" -> ", result));
        } else {
            System.out.println("Goal node '" + goalNode + "' not found within depth limit " + (maxDepth + 1) + ".");
        }
    }
    public static List<String> dls(String start, String goal, int maxDepth) {
        Stack<List<String>> stack = new Stack<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(start);
        stack.push(initialPath);

        while(!stack.isEmpty()) {
            List<String> path = stack.pop();
            String node = path.get(path.size() - 1);
            if(path.size() > maxDepth + 1) {
                continue;
            }
            System.out.println("Visiting node : " + node);
            if(node.equals(goal)) {
                return path;
            }
            List<Map<String, Integer>> neighbours = graph.getOrDefault(node, new ArrayList<>());
            for(int i = neighbours.size() - 1; i >= 0; i--) {
                String neighbour = neighbours.get(i).keySet().iterator().next();
                if(!path.contains(neighbour)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbour);
                    stack.push(newPath);
                }
            }
        }
        return new ArrayList<>();
    }
}
