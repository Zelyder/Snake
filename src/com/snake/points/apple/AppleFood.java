package com.snake.points.apple;

import com.snake.Constants;
import com.snake.points.AbstractFood;
import com.snake.points.PointView;

public class AppleFood extends AbstractFood {
    public AppleFood(int x, int y, PointView pointView) {
        super(x, y);
        this.pointView = pointView;
    }
}
