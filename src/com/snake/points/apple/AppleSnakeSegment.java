package com.snake.points.apple;

import com.snake.Constants;
import com.snake.points.AbstractSnakeSegment;

public class AppleSnakeSegment extends AbstractSnakeSegment {

    public AppleSnakeSegment(int x, int y) {
        super(x, y);
        this.color = Constants.APPLE_SEGMENT_COLOR;
    }
}
