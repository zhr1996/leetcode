
class Solution {
    //This solution can be improved 
    //You can first set all 0 that is connected to edge to 1
    //Thinks it like weiqi

    public int closedIsland(int[][] grid) {
        // 2 means visted, 3 mean checked not a closed island
        int count = 0;
        
        // for (int i = 0; i < grid.length ; ++i){
        //     for (int j =0; j < grid[0].length; ++j){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < grid.length ; ++i){
            for (int j =0; j < grid[0].length; ++j){
                if(grid[i][j] == 0 && DFScheck(grid,i,j)){
                    ++count;
                }
            }
        }
        
        // for (int i = 0; i < grid.length ; ++i){
        //     for (int j =0; j < grid[0].length; ++j){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return count;
    }
    
    public boolean DFScheck(int[][] grid, int x, int y){
        //boolean left, right, up, down;
        grid[x][y] = 2;
        //check left
        if (y == 0){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x][y-1] == 3){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x][y-1] == 0){
            if (!DFScheck(grid, x, y - 1)){
                grid[x][y] = 3;
                return false;
            }
        }
        
        //check right
       if (y == grid[0].length - 1){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x][y+1] == 3){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x][y+1] == 0){
            if (!DFScheck(grid, x, y + 1)){
                grid[x][y] = 3;
                return false;
            }
        }
        //check up
        if (x == 0){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x-1][y] == 3){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x-1][y] == 0){
            if (!DFScheck(grid, x-1, y)){
                grid[x][y] = 3;
                return false;
            }
        }
        //check down
        if (x == grid.length - 1){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x+1][y] == 3){
            grid[x][y] = 3;
            return false;
        }
        else if (grid[x+1][y] == 0){
            if (!DFScheck(grid, x+1, y)){
                grid[x][y] = 3;
                return false;
            }
        }
        return true;
    }
}