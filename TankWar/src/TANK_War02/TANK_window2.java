package TANK_War02;

import javax.swing.*;

public class TANK_window2 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TANK_window2();
    }

    public TANK_window2(){
        mp = new MyPanel();
        this.add(mp);
        //将事件对象传递给面板
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
