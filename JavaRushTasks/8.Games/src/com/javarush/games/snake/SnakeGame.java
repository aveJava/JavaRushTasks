package com.javarush.games.snake;


import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 14;
    public static final int HEIGHT = 15; // 15

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    // метод отрисовки экрана
    private void drawScene() {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, Color.values()[48]);
            }
        }


        /**
         всего цветов 148
         норм. цвета: 22, 56, 112?, 49, 3, 48, 5
         WIDTH - ширина, HEIGHT - высота

         Вернуть цвет клетки
            Color myColor = getCellColor(2, 0);

         Поместить текст в клетку с координатами
            setCellValue(3, 3, "text");

         устанавливает клетке с координатами (x, y) цвет фона cellColor, контент value и цвет контента textColor:
            void setCellValueEx(int x, int y, Color cellColor, String value, Color textColor) —
                setCellValueEx(0, 2, Color.BLACK, "56", Color.GREEN);


         Для подбора цветов:
            int k = 73;
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    Color color = Color.values()[0];
                    setCellColor(x, y, color);
                    setCellValue(x, y, String.valueOf(k/2));
                    k++;
                }
            }


         */



    }

    // метод, отвечающий за действия, которые нужно выполнить для создания игры
    private void createGame() {
        drawScene();
    }
}
