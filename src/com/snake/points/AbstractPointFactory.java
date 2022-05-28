package com.snake.points;

import com.snake.points.apple.AppleSnakeSegment;

public abstract class AbstractPointFactory {
    protected int foodCount = 1;
    public int getFoodCount() {
        return this.foodCount;
    }
    public abstract AbstractFood createFood();
    public abstract AbstractSnakeSegment createSnakeSegment(int x, int y);
}
