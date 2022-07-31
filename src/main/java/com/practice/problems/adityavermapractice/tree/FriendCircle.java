package com.practice.problems.adityavermapractice.tree;

public class FriendCircle {

    private int rows;
    private int columns;
    private int[][] connections;

    public int findCircleNum(int[][] connections) {
        if (connections == null || connections.length == 0) return 0;
        this.connections = connections;
        this.columns = connections[0].length;
        this.rows = connections.length;
        return findCircle(connections);
    }

    private int findCircle(int[][] connections) {
        int provinces = 0;
        for (int row = 0; row < rows; row++) {
            if (connections[row][row] == 1) {
                provinces++;
                dfs(row);
            }
        }
        return provinces;
    }

    private void dfs(int src) {
        connections[src][src] = 0;
        for (int col = 0; col < columns; col++) {
            if (connections[src][col] == 1) {
                connections[src][col] = 0;
                if (connections[col][col] == 1) dfs(col);
            }
        }
    }
}
