package TANK_War01;

import javax.swing.*;

public class TANK_window extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TANK_window();
    }

    public TANK_window(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
