package com.pleasecode.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                bfs(grid, i, j);
                count++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '#') {
                    continue;
                }
                grid[i][j] = '1';
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        visit(grid, i, j, queue);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visit(grid, point.x - 1, point.y, queue);
            visit(grid, point.x + 1, point.y, queue);
            visit(grid, point.x, point.y - 1, queue);
            visit(grid, point.x, point.y + 1, queue);
        }
    }

    private void visit(char[][] grid, int i, int j, Queue<Point> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        queue.offer(new Point(i, j));
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslandsUsingDFS(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '1') {
                    continue;
                }
                dfs(grid, i, j);
                count++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '#') {
                    continue;
                }
                grid[i][j] = '1';
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
