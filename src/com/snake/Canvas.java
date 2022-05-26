package com.snake;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    @Override
    public void paint (Graphics q) {
        super.paint(q);
        GameSnake.snake.paint(q);
        GameSnake.food.paint(q);
        if (GameSnake.gameOver) {
            q.setColor(Color.red);
            q.setFont(new Font("Arial", Font.BOLD, 38));
            FontMetrics fm = q.getFontMetrics();
            q.drawString(Constants.GAME_OVER_MSG, (Constants.FILLED_WIDTH * Constants.POINT_RADIUS + Constants.FILLED_DX - fm.stringWidth(Constants.GAME_OVER_MSG))/2,
                    (Constants.FILLED_HEIGHT * Constants.POINT_RADIUS + Constants.FILLED_DY)/2);
        }
    }

}
