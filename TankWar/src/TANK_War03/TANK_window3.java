package TANK_War03;

import javax.swing.*;

public class TANK_window3 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TANK_window3();
    }

    public TANK_window3(){
        mp = new MyPanel();
        this.add(mp);
        //将事件对象传递给面板
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
