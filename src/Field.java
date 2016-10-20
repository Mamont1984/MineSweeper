import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by evgeny on 14.10.2016.
 */
public class Field extends JPanel {
    final int CELL_SIZE = 25;
    final int FIELD_WIDTH = 8;
    final int FIELD_HEIGHT = 8;
    final int BOMB_COUNT = 10;
    Cell[][] array;
    Random rnd = new Random();

    Field() {
        array = new Cell[FIELD_WIDTH][FIELD_HEIGHT];
        fillArray();
        setBombs();
        calculateNearBombsCount();
    }

    private void fillArray() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Cell();
            }
        }
    }

    private void setBombs() {
        for (int i = 0; i < BOMB_COUNT; i++) {
            int x, y;
            do {
                x = rnd.nextInt(array.length);
                y = rnd.nextInt(array[0].length);
            } while (array[x][y].isBomb());
            array[x][y].setBomb();
        }
    }

    private void calculateNearBombsCount() {

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                int count = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (x + dx >= 0 && x + dx < array.length && y + dy >= 0 && y + dy < array[x].length) {
                            if (array[x + dx][y + dy].isBomb()) {
                                count++;
                            }
                        }
                    }
                }
                array[x][y].setBombsAround(count);
            }
        }
    }

    public void showFieldInConsole() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].isBomb()) {
                    System.out.print("* ");
                } else {
                    System.out.print(array[i][j].getBombsAround() + " ");
                }
            }
            System.out.println();
        }
    }

    public int getFieldWidth() {
        return FIELD_WIDTH;
    }

    public int getFieldHeight() {
        return FIELD_HEIGHT;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (!array[i][j].isVisible()) {
                    g.setColor(Color.GRAY);
                    g.fill3DRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, true);
                } else if (!array[i][j].isBomb()) {
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("",Font.BOLD,CELL_SIZE));
                    g.drawString(Integer.toString(array[i][j].getBombsAround()), i * CELL_SIZE + 6, j * CELL_SIZE + 22);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRoundRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
}
