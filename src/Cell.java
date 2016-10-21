
/**
 * Created by evgeny on 14.10.2016.
 */
public class Cell {

    private boolean visible = false;
    private boolean bomb = false;
    private int bombsAround;
    private boolean flag = false;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible() {
        if (!flag)
        visible = true;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb() {
        this.bomb = true;
    }

    public int getBombsAround() {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) {
        this.bombsAround = bombsAround;
    }

    public boolean isFlag() {
        return flag;
    }

    public void invertFlag() {
        flag = !flag;
    }

}
