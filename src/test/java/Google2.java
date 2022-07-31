public class Google2 {


}

// You are given a grid of size N X N. Each of the cells represent the direction you can go from that cell (l,r,u,d).
// Check that if there is a path from (0,0) to (N-1, N-1).

record Point(int x, int y) {}

    R D U
        L R D
        D D D

public boolean isGridValid(int[] grid) {
        if(grid == null)
        return false;

        int rowLen = grid[0].length;
        int colLen = grid.length;

        if(rowLen == colLen == 1)
        return true;

        boolean result = false;
        int rowIndex = 0;
        int colIndex = 0;
        Set<Point> visited = new HashSet<>();

        while(rowIndex >= 0 && rowIndex < rowLen && colIndex >= 0 && colIndex < colLen) {
        if(rowIndex == rowLen - 1 && colIndex == colLen - 1) {
        return true;
        }
        if(visited.contains(new Point(rowIndex, colIndex))) return false;

        if(grid[0][colIndex] == 'u' || grid[0][colIndex] == 'l') return false;
        if(grid[rowIndex][0] == 'u' || grid[rowIndex][0] == 'u') return false;


        if(grid[rowIndex][colIndex] == 'r') {
        visited.add(new Point(rowIndex, colIndex)); // rowIndex 0
        // rowIndex 2 colIndex 1
        rowIndex++;
        } else if(grid[rowIndex][colIndex] == 'd') {   // rowIndex 1 colIndex 0
        visited.add(new Point(rowIndex, colIndex));
        colIndex++;                                 // rowIndex 1 colIndex 1
        } else if(grid[rowIndex][colIndex] == 'u') {
        visited.add(new Point(rowIndex, colIndex));
        colIndex--;
        } else if(grid[rowIndex][colIndex] == 'l') {
        visited.add(new Point(rowIndex, colIndex));
        rowIndex--;
        }


        }

        return false;
        }




        r r u u
        r u u d
        d r u
        d
        End


        use1 : Top row cell should
        NOT VALID u & l
        VALID -> (r & d)

        Extreme Left col
        VAlID : d & r
        NOT VALID: l & u

        Extreme Right col
        VAlID : d & l
        NOT VALID: r & u

        Bottom row cell should
        NOT VALID d & l
        VALID -> (r & u)




        use2 : r l not a valid move
        use3 : d u not a valid move
        use4 : top line we cannot have u


        R D U
        L R D
        D D D


        R R R
        D
        D


        D U
        D
        D R R