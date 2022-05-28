package com.snake.points.apple;

import com.snake.Constants;
import com.snake.GameSnake;
import com.snake.points.AbstractFood;
import com.snake.points.AbstractPointFactory;
import com.snake.points.AbstractSnakeSegment;

import java.util.Random;

public class AppleFactory extends AbstractPointFactory {
    private Random random = new Random();

    public AppleFactory() {
        super();
        this.foodCount = 3;
    }

    @Override
    public AbstractFood createFood() {
        AbstractFood appleFood;
        do {
            int x = random.nextInt(Constants.FILLED_WIDTH);
            int y = random.nextInt(Constants.FILLED_HEIGHT);
            appleFood = new AppleFood(x, y);
        } while(GameSnake.snake.isInsideSnake(appleFood));
        return appleFood;
    }

    @Override
    public AbstractSnakeSegment createSnakeSegment(int x, int y) {
        return new AppleSnakeSegment(x, y);
    }
}
