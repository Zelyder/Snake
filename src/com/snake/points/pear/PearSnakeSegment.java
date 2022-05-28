package com.snake.points.pear;

import com.snake.Constants;
import com.snake.points.AbstractSnakeSegment;
import com.snake.points.PointView;

public class PearSnakeSegment extends AbstractSnakeSegment {
    public PearSnakeSegment(int x, int y, PointView pointView) {
        super(x, y);
        this.pointView = pointView;
    }

    public PearSnakeSegment(AbstractSnakeSegment segment) {
        super(segment);
    }
}
