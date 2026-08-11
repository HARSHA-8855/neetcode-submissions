class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
        
    }
    private void dfs(char[][] grid, int rows, int cols){
        if(rows<0 || rows>=grid.length || cols<0 || cols>=grid[0].length){
            return;
        }
        if(grid[rows][cols]=='0'){
            return;
        }
        grid[rows][cols] = '0';
        dfs(grid,rows-1,cols);  //to go up
        dfs(grid,rows+1,cols);  //to go down
        dfs(grid,rows,cols-1);  //to go left
        dfs(grid,rows,cols+1);  //to go right
        

    }
}
