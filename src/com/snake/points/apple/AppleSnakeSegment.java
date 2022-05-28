package com.snake.points.apple;

import com.snake.Constants;
import com.snake.points.AbstractSnakeSegment;
import com.snake.points.PointView;

public class AppleSnakeSegment extends AbstractSnakeSegment {
    public AppleSnakeSegment(int x, int y, PointView pointView) {
        super(x, y);
        this.pointView = pointView;
    }

    public AppleSnakeSegment(AbstractSnakeSegment segment) {
        super(segment);
    }
}
