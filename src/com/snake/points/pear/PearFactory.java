package com.snake.points.pear;

import com.snake.Constants;
import com.snake.GameSnake;
import com.snake.points.AbstractFood;
import com.snake.points.AbstractPointFactory;
import com.snake.points.AbstractSnakeSegment;
import com.snake.points.PointView;
import com.snake.points.apple.AppleFood;

import java.util.Random;

public class PearFactory extends AbstractPointFactory {
    private Random random = new Random();

    public PearFactory() {
        super();
        this.foodCount = 2;
    }

    @Override
    public AbstractFood createFood() {
        AbstractFood pearFood;
        PointView pearView = getPointView(Constants.PEAR_FOOD_COLOR);
        do {
            int x = random.nextInt(Constants.FILLED_WIDTH);
            int y = random.nextInt(Constants.FILLED_HEIGHT);
            pearFood = new PearFood(x, y, pearView);
        } while(GameSnake.snake.isInsideSnake(pearFood));
        return pearFood;
    }

    @Override
    public AbstractSnakeSegment createSnakeSegment(int x, int y) {
        PointView pearSegmentView = getPointView(Constants.PEAR_SEGMENT_COLOR);
        return new PearSnakeSegment(x, y, pearSegmentView);
    }

    @Override
    public AbstractSnakeSegment createSnakeSegment(AbstractSnakeSegment segment) {
        return new PearSnakeSegment(segment);
    }
}
