class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //createneighbor list for every course
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
        }
        int[] state = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(dfs(graph,i,state)){
                return false;
            }
        }
        return true;
        
    }
    private boolean dfs(ArrayList<ArrayList<Integer>>graph, int course, int[]state){
        if(state[course]==1){
            return true;
        }
        if(state[course]==2){
            return false;
        }
        state[course] = 1;
        for(int next : graph.get(course)){
            if(dfs(graph,next,state)){
                return true;
            }
        }
        state[course] = 2;
        return false;
    }
}
