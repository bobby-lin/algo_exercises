import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int ROOT_NODE = 0;
    private WeightedQuickUnionUF trackPercolation, nonBottomSet;
    private int[][] grid;
    private int nSize, curId, numOfOpenSites, bottomNode;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is less or equals to 0");
        }
        
        this.nSize = n;
        this.trackPercolation = new WeightedQuickUnionUF(n*n + 2);
        this.nonBottomSet = new WeightedQuickUnionUF(n*n+1);
        
        this.grid = new int[n][n];
        this.bottomNode = nSize * nSize + 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = -1;
            }
        }
        this.numOfOpenSites = 0;
    }

    public void open(int row, int col) {
        
        checkExceptions(row, col);
        
        if (!(grid[row-1][col-1] == 1)) {
            grid[row-1][col-1] = 1;
            numOfOpenSites++;
        }
        
        curId = xyTo1D(row, col);

        if (row == 1) {
            trackPercolation.union(curId, ROOT_NODE); // top row
            nonBottomSet.union(curId, ROOT_NODE);
        }

        if (row == nSize) {
            trackPercolation.union(curId, bottomNode); // bottom row
        }

        // Left
        if (col - 1 > 0 && grid[row-1][col-2] == 1) {
            trackPercolation.union(curId, xyTo1D(row, col-1));
            nonBottomSet.union(curId, xyTo1D(row, col-1));
        }

        // Right
        if (col + 1 <= nSize && grid[row-1][col] == 1) {
            trackPercolation.union(curId, xyTo1D(row, col+1));
            nonBottomSet.union(curId, xyTo1D(row, col+1));
        }

        // Up
        if (row - 1 > 0 && grid[row-2][col-1] == 1) {
            trackPercolation.union(curId, xyTo1D(row-1, col));
            nonBottomSet.union(curId, xyTo1D(row-1, col));
        }

        // Down
        if (row + 1 <= nSize && grid[row][col-1] == 1) {
            trackPercolation.union(curId, xyTo1D(row+1, col));
            nonBottomSet.union(curId, xyTo1D(row+1, col));
        }    
        
    }

    public boolean isOpen(int row, int col) {
        checkExceptions(row, col);
        return grid[row-1][col-1] == 1;
    }

    public boolean isFull(int row, int col) {
        checkExceptions(row, col);
        curId = xyTo1D(row, col);
        return nonBottomSet.connected(curId, ROOT_NODE);
    }

    public int numberOfOpenSites() {
        return numOfOpenSites;
    }

    public boolean percolates() {
        return trackPercolation.connected(ROOT_NODE, bottomNode);
    }
    
    private void checkExceptions(int row, int col) {
        if (row > nSize || row <= 0) {
            throw new IndexOutOfBoundsException("row is out of bounds");
        }
        
        if (col > nSize || col <= 0) {
            throw new IndexOutOfBoundsException("col is out of bounds");
        }
        
    }

    private int xyTo1D(int row, int col) {
        return (row - 1) * nSize + (col-1) + 1;
    }

    public static void main(String[] args) {
        // test client
    }

}
