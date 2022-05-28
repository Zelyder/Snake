package com.snake.points;

import com.snake.points.apple.AppleSnakeSegment;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPointFactory {
    protected Set<PointView> pointViews = new HashSet<>();
    protected PointView getPointView(Color color) {
        PointView newPointView = new PointView(color);
        for (PointView pointView : pointViews) {
            if (newPointView.equals(pointView)) {
                return pointView;
            }
        }
        pointViews.add(newPointView);
        return newPointView;
    }
    protected int foodCount = 1;
    public int getFoodCount() {
        return this.foodCount;
    }
    public abstract AbstractFood createFood();
    public abstract AbstractSnakeSegment createSnakeSegment(int x, int y);
}
