import java.awt.*;

public class MyEdge {
    private int x,y,direction;
    private Color color = Color.WHITE;

    private boolean free = true;
    private boolean visible = false;


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDierction() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public MyEdge(int x, int y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Rectangle getBounds() {
        if(direction == 0 || direction == 1){
            return new Rectangle(75 + (y - 1)* 150,70 + (x - 1) * 150, 150, 10);
        }else if(direction == 2 || direction == 3){
            return new Rectangle(70 + (y - 1) * 150,x * 150 - 75, 10, 150); ////行列xy
        }else{
            return null;
        }
    }

    public void create(){
        if (!isVisible()) {
            return;
        }
        StdDraw.setPenColor(color);

        if(direction == 0 || direction == 1){
            StdDraw.filledRectangle(150 + (y - 1) * 150, 75 + (x - 1) * 150, 75, 5);
        }else if(direction == 2 || direction == 3){
            StdDraw.filledRectangle(75 + (y - 1) * 150, x * 150, 5, 75);
        }
    }




}
