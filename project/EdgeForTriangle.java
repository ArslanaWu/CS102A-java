import java.awt.*;

public class EdgeForTriangle {
    private int x,y,direction;
    private Color color = Color.WHITE;

    private boolean free = true;
    private boolean visible = false;

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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public EdgeForTriangle(int m, int n, int direction){
        this.x = m ;
        this.y = n ;
        this.direction = direction;
    }

    public Rectangle getBounds() {
        if(direction == 0){
            if(x % 2 == 0){
                return new Rectangle(75 - 37 + 75 + 150 * (int)(y / 2 - 1),75 + x * 145, 150, 10);
            }else if(x % 2 == 1){
                return new Rectangle(75 - 37 + 75 + 150 * (int)((y - 1) / 2),15 + 65 + x * 145, 150, 10);
            }else{
                return null;
            }
        }else if(direction == 1){
            if(x % 2 == 1){
                return new Rectangle(113 + 75 + 75 + 150 * (int)(y / 2 - 1),x * 130, 10, 150);
            }else if(x % 2 == 0){
                return new Rectangle(113 + 75 + 150 * (int)((y - 1) / 2),x * 130 - 65, 10, 150);
            }else{
                return null;
            }
        }else if(direction == 2){
            if(x % 2 == 1 ){
                return new Rectangle(188 + 75 + 75 + 150 * (int)(y / 2 - 1),x * 130, 10, 150);
            }else if(x % 2 == 0 && y != 0){
                return new Rectangle(188 + 75 + 150 * (int)((y - 1) / 2),x * 130 - 65, 10, 150);
            }else if(x % 2 == 0 && y == 0){
                return new Rectangle(38 + 75 + 150 * (int)(y / 2), y * 130 - 65, 10, 150);
            }else{
                return null;
            }
        } else {
            return null;
        }
    }

    public void create(){
        if (!isVisible()) {
            return;
        }
        StdDraw.setPenColor(color);

        int row = x;
        int column = y;

        if(direction == 0){
            if(row % 2 == 0){
                StdDraw.filledRectangle(150 + 75 + 150 * (int)(column / 2 - 1), 75 + row * 150, 75, 5);
            }else if(row % 2 == 1){
                StdDraw.filledRectangle(75 + 75 + 150 * (int)((column - 1) / 2), 75 + row * 150, 75, 5);
            }
        }else if(direction == 2){
            if(row % 2 == 0 && y == 0){
                StdDraw.filledRectangle(38 + 75 + 150 * (int)((column - 1) / 2), row * 150, 5, 75,25);
            }
            else if(row % 2 == 1){
                StdDraw.filledRectangle(263 + 75 + 150 * (int)(column / 2 - 1), row * 150, 5,75,25);
            }else if(row % 2 == 0 && y != 0){
                StdDraw.filledRectangle(188 + 75 + 150 * (int)((column - 1) / 2), row * 150, 5, 75,25);
            }
        }else if(direction == 1){
            if(row % 2 == 1){
                StdDraw.filledRectangle(188 + 75 + 150 * (int)(column / 2 - 1), row * 150, 5,75,-25);
            }else if(row % 2 == 0){
                StdDraw.filledRectangle(113 + 75 + 150 * (int)((column - 1) / 2), row * 150, 5, 75,-25);
            }
        }
    }
}
