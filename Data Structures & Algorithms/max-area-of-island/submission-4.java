class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j);
                    maxArea = Math.max(maxArea, area);

                }
            }
        }
        return maxArea;
        
    }
    public int dfs(int[][]grid, int rows, int cols){
        if(rows<0 || rows>=grid.length || cols<0 || cols>=grid[0].length){
            return 0;
        }
        if(grid[rows][cols] == 0){
            return 0; 
        }
        grid[rows][cols] = 0;
        int area = 1;
        area += dfs(grid, rows-1, cols);
        area += dfs(grid, rows+1, cols);
        area += dfs(grid, rows, cols-1);
        area += dfs(grid, rows, cols+1);
        return area;
    }
}
