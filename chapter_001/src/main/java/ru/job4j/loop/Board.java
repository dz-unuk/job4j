package ru.job4j.loop;

/**
 * "Шахматная" доска
 * @author Denis
 * @version 0.1
 * @since 10.12.18
 */
public class Board {
    /**
     *Рисуем "шахматную доску" с заданными высотой и шириной
     * @param width - ширина "доски"
     * @param height - высота "доски"
     * @return String с переносами строк - шахматная доска
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                screen.append(((i + j) % 2 == 0) ? "X" : " ");
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
