/* You have a rabbit that wants to eat all carrots in the garden.
 * The rabbit always enters the garden from the top-left tile.
 * After eating all adjecent carrots the rabbot hops to the others.
 * How many times the rabbit will have to hop in order to eat all carrots?
 */

import java.lang.reflect.Array;

public class rabbit {
  static void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;
   
    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '-') {
      return;
    }
   
    grid[r][c] = '-';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
   
  public static int numOfCarrotPlaces(char [][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    char start = grid[0][0];
    int nr = grid.length;
    int nc = grid[0].length;
    int num_carrrots = 0;
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == 'c') {
          ++num_carrrots;
          dfs(grid, r, c);
        }
      }
    }
    if (start == 'c'){
      return num_carrrots;
    }else{
      return num_carrrots + 1;
    }
   
    
  }
    public static void main(String[] args){
      
    char [][] matrix = {
        {'-', 'c', '-', 'c'},
        {'c', 'c', '-', 'c'},
        {'-', '-', '-', '-'},
        {'-', '-', 'c', 'c'},
        {'-', '-', 'c', 'c'}
    };
    
    System.out.println(rabbit.numOfCarrotPlaces(matrix));
    

}
}