package com.snake.points.apple;

import com.snake.Constants;
import com.snake.points.AbstractFood;

import java.awt.*;

public class AppleFood extends AbstractFood {
    public AppleFood(int x, int y) {
        super(x, y);
        this.color = Constants.APPLE_FOOD_COLOR;
    }
}
