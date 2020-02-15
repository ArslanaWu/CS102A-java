import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.*;


public class Game {
    private ArrayList<MyEdge> edges = new ArrayList<>();
    private ArrayList<Dot> dots = new ArrayList<>();
    private ArrayList<Text> texts = new ArrayList<>();

    public static LoginWindow factors;

    private ArrayList<EdgeForTriangle> edgeForTriangles = new ArrayList<>();

    private Logic logic = new Logic();
    public User[] user = new User[2];

    public User currentUser;
    private int m ;
    private int n ;
    private int kind ;
    public int mode ;

    public static Semaphore semaphore = new Semaphore(0);

    public Game(int canvasWidth, int canvasHeight) {
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(800, 0);
        initialize();
    }

    public void initialize() {
        m = factors.getWidth();
        n = factors.getLength();
        kind = factors.getKind();
        mode = factors.getMode();
        if (kind == 0 && mode == 1) {
            modeInitialize1();
            addObjects();
        }else if(kind == 0 && mode == 3){
            modeInitialize3();
            addObjects();
        }else if(kind == 0 && mode == 2){
            modeInitialize2();
            addObjects();
       }else if(kind == 1 && mode == 1){
            modeInitialize1();
            addTriangleObjects();
        }else if(kind == 1 && mode == 2){
            modeInitialize2();
            addTriangleObjects();
        }else if(kind == 1 && mode == 3){
            modeInitialize3();
            addTriangleObjects();
        }
    }

    public void modeInitialize1(){
        user[0] = new User(factors.getName1(),returnColor(factors.getColor1()),0);
        user[1] = new User(factors.getName1(),returnColor(factors.getColor2()),0);

        currentUser = user[0];
        System.out.printf("It is %s's turn\n", currentUser.getName());
    }

    public void modeInitialize2(){
        user[0] = new User(factors.getName3(), returnColor(factors.getColor3()), 0);
        user[1] = new User("machine", new Color(100,19,200), 0);

        if(factors.getCheck() == 0){
            currentUser = user[0];
        }else if(factors.getCheck() == 1){
            currentUser = user[1];
        }
        System.out.printf("It is %s's turn\n", currentUser.getName());
    }

    public void modeInitialize3(){
        user[0] = new User("machine1", new Color(132,104,199), 0);
        user[1] = new User("machine2", new Color(255,231,201), 0);

        currentUser = user[0];
        System.out.printf("It is %s's turn\n", currentUser.getName());
    }

    public void addObjects(){
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                edges.add(new MyEdge(i, j, 0));
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                edges.add(new MyEdge(i, j, 2));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 15));
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                texts.add(new Text(150 * i, 150 * j));
            }
        }
    }

    public void addTriangleObjects(){
        for (int i = 0; i <= m ; i++) {
            if(i % 2 == 0){
                for (int j = 2; j <= n; j = j + 2) {
                    edgeForTriangles.add(new EdgeForTriangle(i, j, 0));
                }
            }else{
                for (int j = 1; j < n; j = j + 2) {
                    edgeForTriangles.add(new EdgeForTriangle(i, j, 0));
                }
            }

        }
        for (int i = 1; i <= m; i++) {
            if(i % 2 == 0){
                for (int j = 2; j <= n; j = j + 2) {
                    edgeForTriangles.add(new EdgeForTriangle(i, j, 1));
                }
            }else{
                for (int j = 1; j <= n + 1; j = j + 2) {

                        edgeForTriangles.add(new EdgeForTriangle(i, j, 1));

                }
            }
        }
        for (int i = 1; i <= m; i++) {
            if(i % 2 == 1){
                for (int j = 1; j < n; j = j + 2) {

                    edgeForTriangles.add(new EdgeForTriangle(i, j, 2));
                }
            }else{
                for (int j = 0; j <= n + 1; j = j + 2) {

                    edgeForTriangles.add(new EdgeForTriangle(i, j, 2));

                }
            }

        }
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(j % 2 == 0){
                    dots.add(new Dot(150 + 150 * i, 75 + 150 * j, 15));
                }else if(j % 2 == 1){
                    dots.add(new Dot(75 + 150 * i, 75 + 150 * j, 15));
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                texts.add(new Text(150 * i, 150 * j));
            }
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Dots and Boxes  Login");
        LoginWindow.frame = frame;
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        LoginWindow.placeComponents(panel);
        frame.setVisible(true);

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginWindow.launchGame();

    }

    public static void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void human() {
        if(kind == 0){
            for (MyEdge edge : edges) {
                if (edge.isFree()) {
                    humanGameLogic(edge);
                }
            }
        }else if(kind == 1){
            for (EdgeForTriangle edge : edgeForTriangles) {
                if (edge.isFree()) {
                    humanGameLogicTriangle(edge);
                }
            }
        }
    }



    public void machine(){
        if(kind == 0){
            randomClick(edges);
        }else if(kind == 1){
            randomClickTriangle(edgeForTriangles);
        }

        sameGameLogic();
    }

    public void humanMachine(){
        if(kind == 0){
            randomClickHuman(edges);
        }else if(kind == 1){
            randomClickTriangle(edgeForTriangles);
        }

        sameGameLogic();
    }

    public void humanGameLogic(MyEdge edge){
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();

        if (edge.getBounds().contains(mousePoint)) {
            edge.setColor(currentUser.getColor());
            edge.setVisible(true);

            if (isMousePressed) {
                LoginWindow.playMusicWhenCilcked();
                setClick(edge);
                edge.setFree(false);

                sameGameLogic();
            }
        } else {
            edge.setVisible(false);
        }
    }

    public void humanGameLogicTriangle(EdgeForTriangle edge){
        Point mousePoint = new Point((int) StdDraw.mouseX(), (int) StdDraw.mouseY());
        boolean isMousePressed = StdDraw.isMousePressed();

        if (edge.getBounds().contains(mousePoint)) {
            edge.setColor(currentUser.getColor());
            edge.setVisible(true);

            if (isMousePressed) {
                LoginWindow.playMusicWhenCilcked();
                logic.isClickTriangle(edge.getX(),edge.getY(),edge.getDirection(),m,n);
                edge.setFree(false);

                sameGameLogicTriangle();
            }
        } else {
            edge.setVisible(false);
        }
    }


    public void sameGameLogic(){
        if (logic.updateBoard(m, n) > 0) {
            int times = logic.updateBoard(m, n);
            for(int i = 0;i < times;i++){
                int[] place = logic.findEnclosedTag(m, n);
                changeTextState(place[0],place[1]);
                currentUser.setScore(currentUser.getScore() + 1);
            }

            if (logic.checkEnd(m, n)) {
                logic.result(user);
            } else if (!logic.checkEnd(m, n)) {
                System.out.printf("It is still %s's turn\n", currentUser.getName());
            }
        } else {
            currentUser = currentUser == user[0] ? user[1] : user[0];
            System.out.printf("It is %s's turn\n", currentUser.getName());
        }
    }

    public void sameGameLogicTriangle(){
        if (logic.updateBoardTriangle(m, n) > 0) {
            int times = logic.updateBoardTriangle(m, n);
            for(int i = 0;i < times;i++){
                int[] place = logic.findEnclosedTagTriangle(m, n);
                changeTextState(place[0],place[1]);
                currentUser.setScore(currentUser.getScore() + 1);
            }

            if (logic.checkEnd(m, n)) {
                logic.result(user);
            } else if (!logic.checkEnd(m, n)) {
                System.out.printf("It is still %s's turn\n", currentUser.getName());
            }
        } else {
            currentUser = currentUser == user[0] ? user[1] : user[0];
            System.out.printf("It is %s's turn\n", currentUser.getName());
        }
    }



    public void paint() {
        StdDraw.clear();
        if(kind == 0){
            for (MyEdge edge : edges) {
                edge.create();
            }
        }else if(kind == 1){
            for (EdgeForTriangle edge : edgeForTriangles) {
                edge.create();
            }
        }
        for (Dot dot : dots) {
            dot.paint();
        }
        for (Text text : texts) {
            text.paint();
        }
        StdDraw.show();
    }


    public void setClick(MyEdge edge) {

        int x = edge.getX();
        int y = edge.getY();

        if (edge.getDierction() == 0) {
            logic.isClick(x - 1, y, x, y);
        } else if (edge.getDierction() == 1) {
            logic.isClick(x, y, x + 1, y);
        } else if (edge.getDierction() == 2) {
            logic.isClick(x, y - 1, x, y);
        } else if (edge.getDierction() == 3) {
            logic.isClick(x, y, x, y + 1);
        }
    }

    public void changeTextState(int x,int y){
        for(Text text : texts){
            if(!text.isVisible()){
                if(text.getX() == x * 150 && text.getY() == y * 150){
                    text.setColor(currentUser.getColor());
                    text.setVisible(true);
                }
            }
        }
    }

    public void randomClick(ArrayList<MyEdge> edges){
        int[] place = logic.findTagWithoutOneEdge(m,n);
        int x = place[0];
        int y = place[1];
        int direction = place[2];
        if(x != 0 && y != 0){
            for(MyEdge edge : edges){
                if(edge.isFree()){
                    if(edge.getX() == x && edge.getY() == y && edge.getDierction() == direction){
                        edge.setColor(currentUser.getColor());
                        edge.setVisible(true);
                        edge.setFree(false);
                        setClick(edge);
                        LoginWindow.playMusicWhenCilcked();
                        return;
                    }
                }
            }
        }

        while(true){
            int random = (int)(Math.random() * edges.size());
            MyEdge edge = edges.get(random);
            if(edge.isFree()){
                edge.setColor(currentUser.getColor());
                edge.setVisible(true);
                edge.setFree(false);
                setClick(edge);
                LoginWindow.playMusicWhenCilcked();
                break;
            }
        }
    }

    public void randomClickHuman(ArrayList<MyEdge> edges){
        int[] place = logic.findTagWithoutOneEdge(m,n);
        int x = place[0];
        int y = place[1];
        int direction = place[2];
        if(x != 0 && y != 0){
            for(MyEdge edge : edges){
                if(edge.isFree()){
                    if(edge.getX() == x && edge.getY() == y && edge.getDierction() == direction){
                        edge.setColor(currentUser.getColor());
                        edge.setVisible(true);
                        edge.setFree(false);
                        setClick(edge);
                        LoginWindow.playMusicWhenCilcked();
                        return;
                    }
                }
            }
        }

        int[] wrongPlace = logic.findTagWithoutTwoEdges(m,n);
        int xR = wrongPlace[0];
        int yR = wrongPlace[1];
        int directionR = wrongPlace[2];

        while(true){
            int random = (int)(Math.random() * edges.size());
            MyEdge edge = edges.get(random);
            if(edge.isFree()){
                if(edge.getX() != xR && edge.getY() != yR && edge.getDierction() != directionR){
                edge.setColor(currentUser.getColor());
                edge.setVisible(true);
                edge.setFree(false);
                setClick(edge);
                LoginWindow.playMusicWhenCilcked();
                break;
                }
            }
        }
    }

    public void randomClickTriangle(ArrayList<EdgeForTriangle> edgeForTriangles){
        int[] place = logic.findTagWithoutOneEdgeTriangle(m,n);
        int x = place[0];
        int y = place[1];
        int direction = place[2];
        if(x != 0 && y != 0){
            for(EdgeForTriangle edge : edgeForTriangles){
                if(edge.isFree()){
                    if(edge.getX() == x && edge.getY() == y && edge.getDirection() == direction){
                        edge.setColor(currentUser.getColor());
                        edge.setVisible(true);
                        edge.setFree(false);
                        logic.isClickTriangle(edge.getX(),edge.getY(),edge.getDirection(),m,n);
                        LoginWindow.playMusicWhenCilcked();
                        return;
                    }
                }
            }
        }

        while(true){
            int random = (int)(Math.random() * edgeForTriangles.size());
            EdgeForTriangle edge = edgeForTriangles.get(random);
            if(edge.isFree()){
                edge.setColor(currentUser.getColor());
                edge.setVisible(true);
                edge.setFree(false);
                logic.isClickTriangle(edge.getX(),edge.getY(),edge.getDirection(),m,n);
                LoginWindow.playMusicWhenCilcked();
                break;
            }
        }
    }

    public Color returnColor(String color){
        if(color.equals("RED")){
            return Color.RED;
        }else if(color.equals("ORANGE")){
            return Color.ORANGE;
        }else if(color.equals("YELLOW")){
            return Color.YELLOW;
        }else if(color.equals("PINK")){
            return Color.PINK;
        }else if(color.equals("GREEN")){
            return Color.GREEN;
        }else if(color.equals("BLUE")){
            return Color.BLUE;
        }else if(color.equals("MAGENTA")){
            return Color.MAGENTA;
        }else if(color.equals("BLACK")){
            return Color.BLACK;
        }else{
            return null;
        }
    }

    public void print(ArrayList<EdgeForTriangle> edgeForTriangles){
        for(EdgeForTriangle edge : edgeForTriangles){
            System.out.printf("%d %d %d %b %b",edge.getX(),edge.getY(),edge.getDirection(),edge.isVisible(),edge.isFree());
        }
    }


}
