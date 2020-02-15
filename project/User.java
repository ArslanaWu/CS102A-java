import java.awt.*;

public class User {
    private String name;
    private Color color;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int grade) {
        this.score = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User(String name, Color color, int score){
        this.name = name;
        this.color = color;
        this.score = score;

    }





}
