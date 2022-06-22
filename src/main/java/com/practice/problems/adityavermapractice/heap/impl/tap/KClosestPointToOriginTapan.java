package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.KClosestPointToOrigin;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestPointToOriginTapan extends KClosestPointToOrigin {

    final Comparator<Position> MAX_TOP = Comparator.reverseOrder();

    final PriorityQueue<Position> MAX_HEAP = new PriorityQueue<>(MAX_TOP);

    @Override
    protected List<List<Integer>> kClosestPointToOrigin(Integer[][] input, int k) {

        for (int i = 0; i < input.length; i++) {
            int x = input[i][0];
            int y = input[i][1];
            int distance = getDistance(x, y);
            Position position = new Position(distance, new Point(x, y));
            MAX_HEAP.add(position);
            if (MAX_HEAP.size() > k) MAX_HEAP.poll();
        }

        List<List<Integer>> points = MAX_HEAP.stream().map(position -> position.point().getCoordinates()).collect(Collectors.toList());

        return points;
    }

    private int getDistance(int x, int y) {
        return x * x + y * y;
    }

    record Position(Integer distance, Point point) implements Comparable<Position> {

        @Override
        public int compareTo(Position withPair) {
            return this.distance.compareTo(withPair.distance());
        }

    }

    record Point(Integer x, Integer y) implements Comparable<Point> {
        @Override
        public int compareTo(Point pair) {
            return this.x.compareTo(pair.x());
        }

        public List<Integer> getCoordinates() {
            return List.of(this.x, this.y);
        }
    }
}
