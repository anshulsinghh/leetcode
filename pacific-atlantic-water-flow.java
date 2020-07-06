class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        
        if (matrix.length == 0) return ret;
        
        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];
        
        // Setting up rows
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, matrix[0].length - 1, Integer.MIN_VALUE, atlantic);
        }
        
        // Setting up columns
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, matrix.length - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (pacific[row][col] == 1 && atlantic[row][col] == 1) {
                    ArrayList<Integer> entry = new ArrayList<>();
                    entry.add(row);
                    entry.add(col);
                    ret.add(entry);
                }
            }
        }
        
        
        return ret;
    }
    
    public void dfs(int[][] matrix, int row, int col, int prev, int[][] ocean) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return;
        if (matrix[row][col] < prev) return;
        if (ocean[row][col] == 1) return;
        
        ocean[row][col] = 1;
        
        dfs(matrix, row - 1, col, matrix[row][col], ocean);
        dfs(matrix, row + 1, col, matrix[row][col], ocean);
        dfs(matrix, row, col + 1, matrix[row][col], ocean);
        dfs(matrix, row, col - 1, matrix[row][col], ocean);
    }
}
