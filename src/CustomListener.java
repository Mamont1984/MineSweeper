import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by evgeny.mamontov on 20.10.2016.
 */
public class CustomListener implements MouseListener {
    Field field;

    CustomListener(Field field) {
        this.field = field;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            field.getCell(e.getX()/field.getCellSize(),e.getY()/field.getCellSize()).setVisible(true);
        }
        field.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
