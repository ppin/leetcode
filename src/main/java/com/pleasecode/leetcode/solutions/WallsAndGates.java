package com.pleasecode.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] != 0) {
                    continue;
                }
                queue.offer(new Point(i, j, 0));
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visit(rooms, point.x - 1, point.y, point.distance + 1, queue);
            visit(rooms, point.x + 1, point.y, point.distance + 1, queue);
            visit(rooms, point.x, point.y - 1, point.distance + 1, queue);
            visit(rooms, point.x, point.y + 1, point.distance + 1, queue);
        }
    }

    private void visit(int[][] rooms, int i, int j, int distance, Queue<Point> queue) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        // include wall, gate and shorter distance cases
        if (rooms[i][j] <= distance) {
            return;
        }
        if (rooms[i][j] > distance) {
            rooms[i][j] = distance;
        }
        queue.offer(new Point(i, j, distance));
    }

    class Point {
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public void wallsAndGatesUsingDFS(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] != 0) {
                    continue;
                }
                dfs(rooms, i, j, 0, visited);
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int distance, boolean[][] visited) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        if (visited[i][j] || rooms[i][j] < distance) {
            return;
        }
        rooms[i][j] = distance;
        visited[i][j] = true;
        dfs(rooms, i - 1, j, distance + 1, visited);
        dfs(rooms, i + 1, j, distance + 1, visited);
        dfs(rooms, i, j - 1, distance + 1, visited);
        dfs(rooms, i, j + 1, distance + 1, visited);
        visited[i][j] = false;
    }
}
