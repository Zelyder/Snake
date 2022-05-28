package com.snake.points.pear;

import com.snake.Constants;
import com.snake.points.AbstractFood;

public class PearFood extends AbstractFood {
    public PearFood(int x, int y) {
        super(x, y);
        this.color = Constants.PEAR_FOOD_COLOR;
    }
}
