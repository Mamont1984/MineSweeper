import java.util.Random;

/**
 * Created by evgeny on 14.10.2016.
 */
public class Field {


    final int BOMB_COUNT = 10;
    final Cell[][] array;
    Random rnd = new Random();

    Field(int FIELD_WIDTH, int FIELD_HEIGHT) {
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

    public void show() {
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
}
