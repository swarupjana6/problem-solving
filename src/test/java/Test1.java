import java.util.HashSet;
import java.util.Set;

public class Test1 {

    private char[] arr;
    private int index = 0;

    public static void main(String[] args) {
        System.out.println(new Test1().calculate("(7)-(0)+(4)"));
        //System.out.println(new Test().calculate("3+22*2"));
        //System.out.println(new Test().calculate("1 + 1"));
        //System.out.println(new Test().calculate(" 1 + 1"));
        //System.out.println(new Test().calculate("12-3*4"));
    }

    public int calculate(String s) {
        this.arr = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        int sum = 0, operator = 1;

        while (index < arr.length) {

            switch (arr[index]) {
                case ')' -> {
                    break;
                }
                case '(' -> {

                }
            }

            if (arr[index] == ')') {
                break;
            } else if (arr[index] == '(') {
                index++;
                sum += operator * dfs();
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (arr[index] == '+') {
                operator = 1;
            } else if (Character.isDigit(arr[index])) {

                StringBuilder number = new StringBuilder();
                while (index < arr.length && Character.isDigit(arr[index]))
                    number.append(arr[index++]);

                index--;
                sum += Integer.parseInt(number.toString()) * operator;
            }

            index++;
        }
        return sum;
    }


    public boolean isGridValid(int[][] grid) {
        if(grid == null)
            return false;

        int rowLen = grid[0].length;
        int colLen = grid.length;

        if(rowLen == 1 && colLen == 1) return true;

        int rowIndex = 0;
        int colIndex = 0;
        Set<Point1> visited = new HashSet<>();

        while(rowIndex >= 0 && rowIndex < rowLen && colIndex >= 0 && colIndex < colLen) {
            if(rowIndex == rowLen - 1 && colIndex == colLen - 1) {
                return true;
            }
            if(visited.contains(new Point1(rowIndex, colIndex))) {
                return false;
            }

            //if(grid[0][colIndex] == 'u' || grid[0][colIndex] == 'l') return false;
            //if(grid[rowIndex][0] == 'u' || grid[rowIndex][0] == 'u') return false;


            visited.add(new Point1(rowIndex, colIndex));
            if(grid[rowIndex][colIndex] == 'r') {
                rowIndex++;
            } else if(grid[rowIndex][colIndex] == 'd') {   // rowIndex 1 colIndex 0
                colIndex++;                                 // rowIndex 1 colIndex 1
            } else if(grid[rowIndex][colIndex] == 'u') {
                colIndex--;
            } else if(grid[rowIndex][colIndex] == 'l') {
                rowIndex--;
            }
        }

        return false;
    }
}
record Point1(int x, int y) {}

