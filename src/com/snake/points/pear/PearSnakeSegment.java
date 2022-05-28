package com.snake.points.pear;

import com.snake.Constants;
import com.snake.points.AbstractSnakeSegment;

public class PearSnakeSegment extends AbstractSnakeSegment {
    public PearSnakeSegment(int x, int y) {
        super(x, y);
        this.color = Constants.PEAR_SEGMENT_COLOR;
    }
}
