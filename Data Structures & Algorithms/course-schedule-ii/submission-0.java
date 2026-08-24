class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // graph[i] = courses that depend on course i
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Create an empty list for every course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            // prerequisite → course
            graph.get(prerequisite).add(course);
        }

        // 0 = not visited
        // 1 = currently visiting
        // 2 = completely processed
        int[] state = new int[numCourses];

        // Stores the course order
        ArrayList<Integer> order = new ArrayList<>();


        // Run DFS for every course
        for (int i = 0; i < numCourses; i++) {

            // Cycle found → impossible to finish
            if (dfs(graph, i, state, order)) {
                return new int[0];
            }
        }


        // DFS finishes courses from the end,
        // so reverse the order
        Collections.reverse(order);


        // Convert ArrayList<Integer> to int[]
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }


    private boolean dfs(
            ArrayList<ArrayList<Integer>> graph,
            int course,
            int[] state,
            ArrayList<Integer> order) {

        // Course is already in current DFS path
        // Therefore, there is a cycle
        if (state[course] == 1) {
            return true;
        }

        // Already completely processed
        if (state[course] == 2) {
            return false;
        }

        // Mark as currently visiting
        state[course] = 1;


        // Visit all courses that depend on this course
        for (int next : graph.get(course)) {

            // If a cycle is found, stop
            if (dfs(graph, next, state, order)) {
                return true;
            }
        }


        // Finished processing this course
        state[course] = 2;

        // Add course to the order
        order.add(course);

        return false;
    }
}