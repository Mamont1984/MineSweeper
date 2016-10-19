import javax.swing.*;
import java.awt.*;

/**
 * Created by evgeny on 14.10.2016.
 */
public class MineSweeper extends JFrame {

    final String TITLE_OF_PROGRAM = "MineSweeper";
    final int FIELD_WIDTH = 10;
    final int FIELD_HEIGHT = 10;
    final int FIELD_DX = 6;
    final int FIELD_DY = 28;
    final int CELL_SIZE = 25;

    public static void main(String[] args) {
        new MineSweeper().run();
    }

    private void run() {
       // new Field().show();
        Field field = new Field(FIELD_WIDTH, FIELD_HEIGHT);
        Canvas canvas = new Canvas();
        //canvas.setBackground(Color.BLACK);
        JFrame frame = new JFrame(TITLE_OF_PROGRAM);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(500, 200, FIELD_WIDTH*CELL_SIZE+FIELD_DX, FIELD_HEIGHT*CELL_SIZE+FIELD_DY);
        frame.setResizable(false);
        frame.add(canvas);
        frame.setVisible(true);
        field.show();
    }
}
