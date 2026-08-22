class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for(int i = 0; i<rows; i++){
            pacificQueue.add(new int[]{i,0});
            atlanticQueue.add(new int[]{i,cols-1});
            pacific[i][0] = true;
            atlantic[i][cols-1] = true;
        }
        for(int j = 0; j<cols; j++){
            pacificQueue.add(new int[]{0,j});
            atlanticQueue.add(new int[]{rows-1,j});
            pacific[0][j] = true;
            atlantic[rows-1][j] = true;
        }
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited){
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols){
                    continue;
                }
                if(visited[newRow][newCol]){
                    continue;
                }
                if(heights[newRow][newCol]<heights[row][col]){
                    continue;
                }
                visited[newRow][newCol] = true;
                queue.add(new int[]{newRow, newCol});
            }
        }
    }
}
