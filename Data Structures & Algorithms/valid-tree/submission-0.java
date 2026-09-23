class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have exactly n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        // Create an adjacency list for the graph.
        List<List<Integer>> graph = new ArrayList<>();

        // Create an empty list for every node.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add every edge in both directions because
        // this is an undirected graph.
        for (int[] edge : edges) {

            // First node of the edge.
            int u = edge[0];

            // Second node of the edge.
            int v = edge[1];

            // Connect u to v.
            graph.get(u).add(v);

            // Connect v to u.
            graph.get(v).add(u);
        }

        // Keep track of which nodes have been visited.
        boolean[] visited = new boolean[n];

        // Start DFS from node 0.
        dfs(0, graph, visited);

        // Check whether every node was visited.
        for (boolean nodeVisited : visited) {

            // If even one node wasn't reached,
            // the graph is disconnected.
            if (!nodeVisited) {
                return false;
            }
        }

        // Since we already know there are exactly n - 1 edges
        // and the graph is connected, it must be a tree.
        return true;
    }

    private void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited
    ) {

        // Mark the current node as visited.
        visited[node] = true;

        // Visit every neighbor of the current node.
        for (int neighbor : graph.get(node)) {

            // Don't visit a node that we've already visited.
            if (visited[neighbor]) {
                continue;
            }

            // Recursively visit the neighbor.
            dfs(neighbor, graph, visited);
        }
    }
}