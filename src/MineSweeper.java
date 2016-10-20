import javax.swing.*;
import java.awt.*;

/**
 * Created by evgeny on 14.10.2016.
 */
public class MineSweeper extends JFrame {

    final String TITLE_OF_PROGRAM = "MineSweeper";
    final int FIELD_DX = 16;
    final int FIELD_DY = 38;

    public static void main(String[] args) throws InterruptedException {
        new MineSweeper().run();
    }

    private void run() throws InterruptedException {
        Field field = new Field();
        JPanel fl = new JPanel();
        fl.setBackground(Color.black);
        JFrame frame = new JFrame(TITLE_OF_PROGRAM);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(500, 200, field.getFieldWidth() * field.getCellSize()+FIELD_DX, field.getFieldHeight() * field.getCellSize()+FIELD_DY);
        field.setBackground(Color.white);
        field.showFieldInConsole();
        frame.add(field);
        frame.setVisible(true);
    }
}
