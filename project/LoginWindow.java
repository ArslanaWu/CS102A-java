import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
//import javafx.scene.media.AudioClip;
import javax.swing.ImageIcon;
import java.awt.event.*;


public class LoginWindow {
    protected static JFrame frame;
    private static boolean start;
    private String name, name1, name2, name3;
    private int mode, check;
    private int kind = 0;
    private String color1, color2, color3;
    private int width, length;

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public static boolean isStart() {
        return start;
    }

    public static void setStart(boolean start) {
        LoginWindow.start = start;
    }

    public static void main(String[] args) {
        frame = new JFrame("Dots and Boxes  Login");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {
        LoginWindow a = new LoginWindow();
        Game.factors = a;
        panel.setLayout(null);
        //设置用户组件
        /*JLabel userLabel = new JLabel("Player:");
        userLabel.setFont(new Font("宋体", Font.BOLD, 20));
        userLabel.setBounds(10, 250, 80, 25);
        panel.add(userLabel);
        //创建文本域用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 250, 165, 25);
        panel.add(userText);
        String name = userText.getText().trim();*/
        JLabel modeLabel = new JLabel("Mode:");
        modeLabel.setFont(new Font("宋体", Font.BOLD, 20));
        modeLabel.setBounds(10, 230, 80, 25);
        panel.add(modeLabel);
        //加入背景图片
//        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
//        panel.setOpaque(false);
 //       JLabel background = new JLabel(new ImageIcon("D:\\各种Projects\\IdeaProjects\\java project\\背景图片3.jpg"));
 //       panel.add(background);
 //      background.setBounds(400,120,200,150);

        //创建登录按钮
        JButton loginButton = new JButton("Login in");
        loginButton.setFont(new Font("宋体", Font.CENTER_BASELINE, 20));
        loginButton.setBounds(220, 380, 150, 40);
        panel.add(loginButton);
        //添加单选按钮选择模式
        JRadioButton rb1 = new JRadioButton("人  V.S. 人");
        JRadioButton rb2 = new JRadioButton("人  V.S. 机");
        JRadioButton rb3 = new JRadioButton("机  V.S. 机");
        ButtonGroup group = new ButtonGroup();
        rb1.setBounds(20, 250, 150, 100);
        rb2.setBounds(220, 250, 150, 100);
        rb3.setBounds(420, 250, 150, 100);
        rb1.setFont(new Font("宋体", Font.BOLD, 15));
        rb2.setFont(new Font("宋体", Font.BOLD, 15));
        rb3.setFont(new Font("宋体", Font.BOLD, 15));
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);

        JButton rb4 = new JButton("矩形");
        JButton rb5 = new JButton("三角形");

        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setFont(new Font("宋体", Font.BOLD, 20));
        lengthLabel.setBounds(10, 50, 100, 25);
        panel.add(lengthLabel);
        JTextField lengthText = new JTextField(20);
        lengthText.setBounds(100, 50, 50, 25);
        panel.add(lengthText);

        JLabel widthLabel = new JLabel("Width:");
        widthLabel.setFont(new Font("宋体", Font.BOLD, 20));
        widthLabel.setBounds(300, 50, 100, 25);
        panel.add(widthLabel);
        JTextField widthText = new JTextField(20);
        widthText.setBounds(380, 50, 50, 25);
        panel.add(widthText);
//加入背景图片
//       JLabel background = new JLabel(new ImageIcon("D:\\各种Projects\\IdeaProjects\\java project\\背景图片3.jpg"));
//       panel.add(background);
 //       background.setBounds(0,0,650,550);

        //加入监听器
        ActionListener ourListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonName = e.getActionCommand();
                if (buttonName.equalsIgnoreCase("人  V.S. 人")) {
                    setHumanVsHuman(a);
                } else if (buttonName.equalsIgnoreCase("人  V.S. 机")) {
                    setHumanVsMachine(a);
                } else if (buttonName.equalsIgnoreCase("机  V.S. 机")) {
                    a.mode = 3;
                    JOptionPane.showMessageDialog(null, "机  V.S. 机被点击");
                }

                if (buttonName.equalsIgnoreCase("Login in")) {
                    setStart(true);
//                    frame.dispose();
                    frame.setVisible(false);
                    a.width = Integer.parseInt(widthText.getText().trim());
                    a.length = Integer.parseInt(lengthText.getText().trim());
                    Game.semaphore.release();
                }
                if (buttonName.equalsIgnoreCase("矩形")) {
                    a.kind = 0;
                    //JOptionPane.showInputDialog(null,"kind1");
                } else if (buttonName.equalsIgnoreCase("三角形")) {
                    a.kind = 1;
                    //JOptionPane.showInputDialog(null,"kind2");
                }
            }

        };
        rb1.addActionListener(ourListener);
        rb2.addActionListener(ourListener);
        rb3.addActionListener(ourListener);
        loginButton.addActionListener(ourListener);
        rb4.addActionListener(ourListener);
        rb5.addActionListener(ourListener);
        //设置长和宽（组件）

        String length1 = lengthText.getText().trim();
        //a.length = Integer.parseInt(length1);
        System.out.println(length1);


        String width1 = lengthText.getText().trim();
        //a.width = Integer.parseInt(width1);
        JLabel kindLabel = new JLabel("Choose the shape of your board");
        kindLabel.setFont(new Font("宋体", Font.BOLD, 20));
        kindLabel.setBounds(10, 120, 400, 25);
        panel.add(kindLabel);
        ButtonGroup group2 = new ButtonGroup();
        rb4.setBounds(20, 150, 150, 50);
        rb5.setBounds(220, 150, 150, 50);
        rb4.setFont(new Font("宋体", Font.BOLD, 15));
        rb5.setFont(new Font("宋体", Font.BOLD, 15));
        group.add(rb4);
        group.add(rb5);
        panel.add(rb4);
        panel.add(rb5);
    }

    private static void setHumanVsMachine(LoginWindow a) {
        JTextField xField = new JTextField(10);
        JPanel panel2 = new JPanel();
        panel2.setSize(100, 100);
        panel2.add(new JLabel("Your name"));
        panel2.add(xField);
        JOptionPane.showConfirmDialog(null, panel2, "Please Enter Your name", JOptionPane.OK_CANCEL_OPTION);
        a.name3 = xField.getText();
        a.mode = 2;
        Object[] colors = {"RED", "ORANGE", "YELLOW", "MAGENTA", "GREEN", "BLUE", "PURPLE", "BLACK"};
        a.color3 = (String) JOptionPane.showInputDialog(null, "请选择你喜欢的颜色:\n", "颜色", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), colors, "蓝色");
        a.check = JOptionPane.showConfirmDialog(null, "是否先手？", "", JOptionPane.YES_NO_OPTION);
    }

    private static void setHumanVsHuman(LoginWindow a) {
        //JOptionPane.showInputDialog(null,"player1 name:");
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.setSize(50, 50);
        myPanel.add(new JLabel("player1:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("player2:"));
        myPanel.add(yField);
        JOptionPane.showConfirmDialog(null, myPanel, "Please Enter players' names", JOptionPane.OK_CANCEL_OPTION);
        a.name1 = xField.getText();
        a.name2 = yField.getText();
        a.mode = 1;
        Object[] colors = {"RED", "ORANGE", "YELLOW", "MAGENTA", "GREEN", "BLUE", "PURPLE", "BLACK"};
        a.color1 = (String) JOptionPane.showInputDialog(null, "请选择player1的颜色:\n", "颜色", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), colors, "红色");
        a.color2 = (String) JOptionPane.showInputDialog(null, "请选择player2的颜色:\n", "颜色", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), colors, "蓝色");
    }

    public static void launchGame() {
        Game game = new Game(600, 600);
        LoginWindow.playMusic();
        StdDraw.showFrame();
        while (true) {
            if(game.mode == 1){
                game.human();
                game.paint();
                Game.delay(10);

            }else if(game.mode == 2){
                game.paint();
                if(game.currentUser == game.user[0]){
                    game.human();
                    Game.delay(10);
                }else if(game.currentUser == game.user[1]){
                    game.machine();
                    Game.delay(500);
                }

            }else if(game.mode == 3){
                game.paint();
                game.machine();
                Game.delay(1000);
            }
        }
    }

    public static void endWINDOW(String string) {
        JOptionPane.showMessageDialog(null, string, "结果显示", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void playMusic() {
        try {
            String fileName = "D:\\SUSTech\\subjects\\y1s2\\Java\\project\\myProject\\src\\Saika-Rabpit.wav";
            File audioFile = new File(fileName);

            Clip audioClip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile.getAbsoluteFile().toURL());
            audioClip.open(audioStream);
            audioClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void playMusicWhenCilcked(){
        try {
            String fileName = "D:\\南科大\\科目资料\\Java\\project\\myProject\\src\\unsure.wav";
            //D:\南科大\科目资料\Java\project\myProject\src
            File audioFile = new File(fileName);

            Clip audioClip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile.getAbsoluteFile().toURL());
            audioClip.open(audioStream);
            audioClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}