import java.util.*;

public class DFS {
    static HashMap<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("4", "5"));
        graph.put("3", Arrays.asList("6", "7"));
        graph.put("4", new ArrayList<>());
        graph.put("5", new ArrayList<>());
        graph.put("6", new ArrayList<>());
        graph.put("7", new ArrayList<>());
        System.out.println("Enter the goal node : ");
        String goalNode = sc.next();
        System.out.println("Depth-First Search:");
        dfs("1", goalNode);
        sc.close();
    }
    public static boolean dfs(String node, String goalNode) {
        if(!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            if(node.equals(goalNode)) {
                return true;
            }
            for(String neighbour : graph.get(node)) {
                if(dfs(neighbour, goalNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
