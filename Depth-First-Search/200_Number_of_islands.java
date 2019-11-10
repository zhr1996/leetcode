class Solution {
    //DFS
    //A typical question
    //When meeting a '1', use DFS to continue to mark his adjaacent cell to be 0
    //Then continue searching if there is a '1' in the graph
    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        for (int i = 0; i < height ; ++i){
            for (int j = 0; j < width ; ++j){
                if(grid[i][j] == '1'){
                    DFSMarking(grid, height, width, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void DFSMarking(char[][] grid, int height, int width , int i, int j){
        if ( i < 0 || i >= height || j < 0 || j >= width || grid[i][j] != '1'){
            return;
        }
        else{
            grid[i][j] = '0';
            //Continue to search down , until reach a 0 or bottom
            DFSMarking(grid, height, width, i + 1 , j);
            //Continue to search up , until reach a 0 or edge
            DFSMarking(grid, height, width, i - 1 , j);
            //Continue to search right , until reach a 0 or edge
            DFSMarking(grid, height, width, i , j + 1);
            //Continue to search right , until reach a 0 or edge
            DFSMarking(grid, height, width, i , j - 1);
        }
    }
}