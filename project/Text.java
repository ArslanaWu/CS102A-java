import java.awt.*;

public class Text {
    private int x,y;

    private String content;
    private Color color = Color.WHITE;
    private boolean visible = false;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Text(int x,int y){
        this.x = x;
        this.y = y;
        //this.content = content;
    }

    public void paint(){
        if (!isVisible()) {
            return;
        }
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(y,x,65);
    }

}
