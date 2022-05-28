package com.snake.points.pear;

import com.snake.Constants;
import com.snake.points.AbstractFood;
import com.snake.points.PointView;

public class PearFood extends AbstractFood {
    public PearFood(int x, int y, PointView pointView) {
        super(x, y);
        this.pointView = pointView;
    }
}
