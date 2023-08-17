package TANK_War05;

import javax.swing.*;

public class TANK_window5 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TANK_window5();
    }

    public TANK_window5(){
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        //将事件对象传递给面板
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
