package TANK_War;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TANK_window extends JFrame {
    MyPanel mp = null;
     Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        new TANK_window();
    }
    public TANK_window(){
        System.out.println("请输入选择 1: 新游戏 2：继续上局游戏");
        String key = scanner.next();
        mp = new MyPanel(key);
        new Thread(mp).start();
        this.add(mp);
        //将事件对象传递给面板
        this.addKeyListener(mp);
        this.setSize(1250,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //在JFrame中增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepallEnemyTankNum();
                System.exit(0);
            }
        });

    }
}
